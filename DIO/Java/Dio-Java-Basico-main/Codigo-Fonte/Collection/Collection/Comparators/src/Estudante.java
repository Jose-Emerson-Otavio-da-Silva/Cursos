// A class representing a student that implements the Comparable interface
public class Estudante implements Comparable<Estudante> {

    // Private final fields for the student's name and age
    private final String nome;
    private final Integer idade;

    // Constructor to initialize the student's name and age
    public Estudante(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Getter method for the student's name
    public String getNome() {
        return nome;
    }

    // Getter method for the student's age
    public Integer getIdade() {
        return idade;
    }

    // Overriding the toString method to return a string representation of the
    // student
    @Override
    public String toString() {
        return nome + " - " + idade;
    }

    // Overriding the compareTo method to compare students by age
    @Override
    public int compareTo(Estudante o) {
        return this.getIdade() - o.getIdade();
    }

}
