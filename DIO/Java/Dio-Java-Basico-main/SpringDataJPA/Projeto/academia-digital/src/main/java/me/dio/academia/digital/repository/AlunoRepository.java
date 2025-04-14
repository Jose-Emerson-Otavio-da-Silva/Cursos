package me.dio.academia.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.academia.digital.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    // Por exemplo:
    // List<Aluno> findByNome(String nome);
    // Optional<Aluno> findByCpf(String cpf);
}
