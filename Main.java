import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Biblioteca biblioteca = new Biblioteca();
    public static void main(String[] args) {

        biblioteca =(Biblioteca) Persistencia.carregar("biblioteca.dat");
        if (biblioteca == null)
        {
            biblioteca = new Biblioteca();
        }

        int opcao;

        do {
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1 - Cadastrar Livro\n2 - Listar Livros\n3 - Solicitar Empréstimo\n4 - Ver Disponibilidade\n5- Eliminar cadastro\n6- Novo aluno\n7- Ver alunos\n0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    solicitarEmprestimo();
                    break;
                case 4:
                    verificarDisponibilidade();
                    break;
                case 5:
                    eliminarCadastro();
                    break;
                case 6:
                    cadastrarAluno();
                    break;
                case 7:
                    listarAlunos();
                    break;
                case 0:
                    Persistencia.salvar(
                            biblioteca,
                            "biblioteca.dat");

                    System.exit(opcao);
                    System.out.println("Sair...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    // CADASTRAR LIVRO
    public static void cadastrarLivro() {

        System.out.println("\n=== CADASTRAR LIVRO ===");

        System.out.print("Título: ");
        String titulo = scanner.next();

        System.out.print("Autor: ");
        String autor = scanner.next();

        System.out.print("ISBN: ");
        String isbn = scanner.next();

        System.out.print("Número de cópias: ");
        int copias = scanner.nextInt();
        scanner.nextLine();

        Livro livro = new Livro(
                titulo,
                autor,
                isbn,
                copias
        );

        biblioteca.adicionarLivro(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    // LISTAR LIVROS
    public static void listarLivros() {

        System.out.println("\n=== LIVROS DISPONÍVEIS ===");

        biblioteca.listarLivros();
    }

    // VERIFICAR DISPONIBILIDADE
    public static void verificarDisponibilidade() {

        System.out.print("\nDigite o título: ");

        String titulo = scanner.next();

        Livro livro = biblioteca.buscarPorTitulo(titulo);

        if (livro != null) {

            System.out.println(
                    "Cópias disponíveis: "
                            + livro.getCopiasDisponiveis()
            );

        } else {

            System.out.println("Nenum livro cadastrado.");
        }
    }

    // SOLICITAR EMPRÉSTIMO
    public static void solicitarEmprestimo() {

        System.out.println("\n=== EMPRÉSTIMO ===");

        System.out.print("Matrícula do aluno: ");

        String matricula = scanner.next();

        Aluno aluno =
                biblioteca.buscarAluno(matricula);

        if (aluno == null) {

            System.out.println(
                    "Aluno não cadastrado!"
            );

            return;
        }

        System.out.print("ISBN do livro: ");

        String isbn = scanner.next();

        Livro livro =
                biblioteca.buscarPorIsbn(isbn);

        if (livro == null) {

            System.out.println("Livro não encontrado.");
            return;
        }

        if (!livro.disponivel()) {

            System.out.println("Livro indisponível.");
            return;
        }

        if (!aluno.podeEmprestar()) {

            System.out.println(
                    "Limite de empréstimos atingido."
            );

            return;
        }

        livro.emprestar();

        Emprestimo emp =
                new Emprestimo(livro, aluno, 5);

        aluno.adicionarEmprestimo(emp);

        System.out.println(
                "Empréstimo realizado com sucesso!"
        );

        System.out.println(emp);
    }
    //Eliminar cadastro
    public static void eliminarCadastro() {

        System.out.println("Escolhe uma das opções\n1- Eliminar Livro\n2- Eliminar Aluno");
        int escolhe = scanner.nextInt();
        if (escolhe == 1) {
            System.out.println("\n=== ELIMINAR LIVRO ===");

            System.out.print("Digite o isbn: ");

            String isbn = scanner.next();

            Livro livro =
                    biblioteca.buscarPorIsbn(isbn);

            if (livro == null) {

                System.out.println("Livro não encontrado.");
                return;
            }

            biblioteca.removerLivro(livro);

            System.out.println("Livro removido com sucesso!");

        }
        else if (escolhe == 2) {
            System.out.println("\n=== ELIMINAR ALUNO ===");

            System.out.print("Matrícula do aluno: ");
            String matricula = scanner.next();

            Aluno aluno =
                    biblioteca.buscarAluno(matricula);

            if (aluno == null) {

                System.out.println("Aluno não encontrado.");
                return;
            }

            biblioteca.removerAluno(aluno);

            System.out.println("Aluno removido com sucesso!");
        }
    }
    public static void cadastrarAluno() {

        System.out.println("\n=== CADASTRAR ALUNO ===");

        System.out.print("Nome Completo: ")
    ;
        String nome = scanner.next();

        System.out.print("Matrícula: ");
        String matricula = scanner.next();

        // VERIFICA SE JÁ EXISTE
        Aluno existente =
                biblioteca.buscarAluno(matricula);

        if (existente != null) {

            System.out.println(
                    "Aluno já cadastrado!"
            );

            return;
        }

        Aluno aluno =
                new Aluno(nome, matricula);

        biblioteca.adicionarAluno(aluno);

        System.out.println(
                "Aluno cadastrado com sucesso!"
        );
    }
    public static void listarAlunos() {

        System.out.println("\n=== LISTA DE ALUNOS ===");

        biblioteca.listarAlunos();
    }
}

