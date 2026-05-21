import java.io.Serializable;
    public class Livro implements Serializable {

        private String titulo;
        private String autor;
        private String isbn;
        private int copiasDisponiveis;

        // Construtor
        public Livro(String titulo,
                     String autor,
                     String isbn,
                     int copiasDisponiveis) {

            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
            this.copiasDisponiveis = copiasDisponiveis;
        }

        // Verifica disponibilidade
        public boolean disponivel() {
            return copiasDisponiveis > 0;
        }

        // Reduz cópia ao emprestar
        public void emprestar() {

            if (copiasDisponiveis > 0) {
                copiasDisponiveis--;
            } else {
                System.out.println("Livro indisponível.");
            }
        }

        // Aumenta cópia ao devolver
        public void devolver() {
            copiasDisponiveis++;
        }

        // Getters e Setters

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public int getCopiasDisponiveis() {
            return copiasDisponiveis;
        }

        public void setCopiasDisponiveis(int copiasDisponiveis) {
            this.copiasDisponiveis = copiasDisponiveis;
        }

        @Override
        public String toString() {

            return "\n===== LIVRO =====" +
                    "\nTítulo: " + titulo +
                    "\nAutor: " + autor +
                    "\nISBN: " + isbn +
                    "\nCópias Disponíveis: " + copiasDisponiveis;
        }
    }

