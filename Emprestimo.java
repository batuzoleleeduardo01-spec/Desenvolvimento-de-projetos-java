    import java.io.Serializable;
    import java.time.LocalDate;

    public class Emprestimo implements Serializable {

        private Livro Livro;
        private Aluno Aluno;

        private LocalDate dataEmprestimo;
        private LocalDate prazoDevolucao;

        public Emprestimo(Livro livro, Aluno aluno, int diasPrazo) {

            this.Livro = livro;
            this.Aluno = aluno;

            this.dataEmprestimo = LocalDate.now();
            this.prazoDevolucao = dataEmprestimo.plusDays(diasPrazo);
        }

        public boolean estaAtrasado() {
            return LocalDate.now().isAfter(prazoDevolucao);
        }

        public Livro getLivro() {
            return Livro;
        }

        public Aluno getAluno() {
            return Aluno;
        }

        @Override
        public String toString() {

            String status = estaAtrasado()
                    ? "ATRASADO"
                    : " ";

            return Livro.getTitulo() +
                    " | Aluno: " + Aluno.getNome() +
                    " | Devolver até: " + prazoDevolucao +
                    " | " + status;
        }
    }

