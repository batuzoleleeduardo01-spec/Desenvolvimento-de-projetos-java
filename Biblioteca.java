import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Livro> catalogo;
    private List<Aluno> alunos;

    // CONSTRUTOR
    public Biblioteca() {

        catalogo = new ArrayList<>();
        alunos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {

        catalogo.add(livro);
    }

    public void listarLivros() {

        for (Livro livro : catalogo) {

            System.out.println(livro);
        }
    }

    public Livro buscarPorTitulo(String titulo) {

        for (Livro livro : catalogo) {

            if (livro.getTitulo()
                    .equalsIgnoreCase(titulo)) {

                return livro;
            }
        }

        return null;
    }

    public Livro buscarPorAutor(String autor) {

        for (Livro livro : catalogo) {

            if (livro.getAutor()
                    .equalsIgnoreCase(autor)) {

                return livro;
            }
        }

        return null;
    }

    public Livro buscarPorIsbn(String isbn) {

        for (Livro livro : catalogo) {

            if (livro.getIsbn()
                    .equalsIgnoreCase(isbn)) {

                return livro;
            }
        }

        return null;
    }

    public void removerLivro(Livro livro) {

        catalogo.remove(livro);
    }


    // ALUNOS

    public void adicionarAluno(Aluno aluno) {

        alunos.add(aluno);
    }

    public void listarAlunos() {

        for (Aluno aluno : alunos) {

            System.out.println(aluno);
        }
    }

    public Aluno buscarAluno(String matricula) {

        for (Aluno aluno : alunos) {

            if (aluno.getMatricula()
                    .equalsIgnoreCase(matricula)) {

                return aluno;
            }
        }

        return null;
    }

    public void removerAluno(Aluno aluno) {

        alunos.remove(aluno);
    }
    public String getMatricula(){
        return getMatricula();
    }
}


