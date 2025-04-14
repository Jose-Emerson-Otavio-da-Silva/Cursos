// Pacote da classe
package me.dio.academia.digital.entity;

// Importações necessárias
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Anotações do Lombok para gerar automaticamente getters, setters, construtores, etc.
@Data
@NoArgsConstructor
@AllArgsConstructor

// Indica que esta classe é uma entidade JPA
@Entity

// Define o nome da tabela no banco de dados
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

  // Identificador único da entidade
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
  private Long id;

  // Relacionamento muitos-para-um com a entidade Aluno
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id") // Nome da coluna de chave estrangeira
  private Aluno aluno;

  // Data e hora da avaliação, com valor padrão como o momento atual
  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  // Coluna para armazenar o peso atual do aluno
  @Column(name = "peso_atual")
  private double peso;

  // Coluna para armazenar a altura atual do aluno
  @Column(name = "altura_atual")
  private double altura;

}
