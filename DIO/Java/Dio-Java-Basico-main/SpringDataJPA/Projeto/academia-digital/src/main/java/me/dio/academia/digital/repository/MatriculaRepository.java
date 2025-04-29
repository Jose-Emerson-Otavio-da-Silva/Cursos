package me.dio.academia.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.dio.academia.digital.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    /**
     * @param dataDeNascimento: data de nascimento do aluno
     * @return lista com todos os alunos com a data de nascimento passada como
     *         parmetro da função
     */

    @Query(value = "SELECT * FROM tb_matriculas m INNER JOIN tb_alunos a ON m.aluno_id  = a.id WHERE a.bairro = : bairro", nativeQuery = true)
    // @Query("SELECT m FROM Matricula m WHERE m.aluno.bairro = :bairro")
    List<Matricula> findAlunosMatriculadosBairro(String bairro);

    // List<Matricula> findByalunoBairro(String bairro);
}
