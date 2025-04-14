// Pacote da classe
package me.dio.academia.digital.entity;

// Importações necessárias
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Anotações Lombok para gerar getters, setters, construtores e outros métodos automaticamente
@Data
@NoArgsConstructor
@AllArgsConstructor

// Indica que esta classe é uma entidade JPA
@Entity

// Define o nome da tabela no banco de dados
@Table(name = "tb_alunos")

// Ignora propriedades específicas do Hibernate ao serializar para JSON
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Aluno {

  // Identificador único da entidade, gerado automaticamente
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Nome do aluno
  private String nome;

  // CPF do aluno, deve ser único no banco de dados
  @Column(unique = true)
  private String cpf;

  // Bairro onde o aluno reside
  private String bairro;

  // Data de nascimento do aluno
  private LocalDate dataDeNascimento;

  // Lista de avaliações físicas associadas ao aluno, carregadas de forma
  // preguiçosa
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
  @JsonIgnore // Ignora esta propriedade ao serializar para JSON
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
