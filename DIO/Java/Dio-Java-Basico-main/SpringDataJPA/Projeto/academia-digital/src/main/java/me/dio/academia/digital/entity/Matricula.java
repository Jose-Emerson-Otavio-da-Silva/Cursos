// Pacote onde a classe está localizada
package me.dio.academia.digital.entity;

// Importações necessárias para a funcionalidade da classe
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

// Define o nome da tabela no banco de dados associada a esta entidade
@Table(name = "tb_matriculas")
public class Matricula {

  // Identificador único da matrícula, gerado automaticamente
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Relacionamento de um para um com a entidade Aluno
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id") // Define a chave estrangeira no banco de dados
  private Aluno aluno;

  // Data e hora em que a matrícula foi criada, com valor padrão como o momento
  // atual
  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
