package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class MatriculaForm {

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "O Id do aluno deve ser positivo.")
  private Long alunoId;

  public Long getAlunoId() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAlunoId'");
  }

}
