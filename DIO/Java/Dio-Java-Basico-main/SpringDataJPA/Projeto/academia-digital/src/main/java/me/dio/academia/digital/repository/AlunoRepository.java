package me.dio.academia.digital.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.academia.digital.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    /**
     * @param dataDeNascimento: data de nascimento do aluno
     * @return lista com todos os alunos com a data de nascimento passada como
     *         parmetro da função
     */
    List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);
}
