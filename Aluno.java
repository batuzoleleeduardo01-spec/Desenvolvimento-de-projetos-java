import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String matricula;

    private List<Emprestimo> emprestimos;

    private static final int MAX_EMPRESTIMOS = 3;

    // CONSTRUTOR
    public Aluno(String nome, String matricula) {

        this.nome = nome;
        this.matricula = matricula;

        this.emprestimos = new ArrayList<>();
    }

    // VERIFICA LIMITE
    public boolean podeEmprestar() {

        return emprestimos.size() < MAX_EMPRESTIMOS;
    }

    // ADICIONA EMPRÉSTIMO
    public void adicionarEmprestimo(Emprestimo emp) {

        emprestimos.add(emp);
    }

    // GETTERS
    public String getNome() {

        return nome;
    }

    public String getMatricula() {

        return matricula;
    }

    public List<Emprestimo> getEmprestimos() {

        return emprestimos;
    }

    @Override
    public String toString() {

        return "\n===== ALUNO =====" +
                "\nNome: " + nome +
                "\nMatrícula: " + matricula;
    }
}