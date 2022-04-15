import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Pessoa usuario;

    public static void main(String[] args) {
        Editora.listaEditoras.add(new Editora("Rocco", "1"));
        Editora.listaEditoras.add(new Editora("Intrínseca", "2"));
        Editora.listaEditoras.add(new Editora("Arqueiro", "3"));
        Pessoa.listaPessoas.add(new Diretor("11209407965", "Leonardo", "Rafaelli", "leonardorafaelli@gmail.com", "Masculino", "123"));
        Pessoa.listaPessoas.add(new Revisor("1","1", "1", "1", "1", "1"));
        Pessoa.listaPessoas.add(new Autor("2","2", "2", "2", "2", "2"));
        menuLogin();
    }

    private static void menuLogin(){
        System.out.print("\n---MENU---" +
                "\n1 - Logar" +
                "\n2 - Cadastrar-se" +
                "\n->: ");
        switch (sc.nextInt()){
            case 1 -> login();
            case 2 -> cadastro(1);
            default -> {
                System.out.println("Opção inválida!");
                menuLogin();
            }
        }
        menuLogin();
    }

    private static void login() {
        System.out.print("\n---LOGIN---" +
                "\nDigite seu email: ");
        String email = sc.next();
        System.out.print("Digite sua senha: ");
        String senha = sc.next();
//
        int i = verifica(email, senha);
        usuario = Pessoa.listaPessoas.get(i);
        if (i > -1) {
            if (usuario instanceof Autor) {
                menuPrincipal(1);
            } else if (usuario instanceof Revisor) {
                menuPrincipal(2);
            } else {
                menuPrincipal(3);
            }
        } else {
            System.out.println("Email e/ou senha incorretos!");
            login();
        }
    }

    private static int verifica(String email, String senha){
        for (int i = 0; i < Pessoa.listaPessoas.size(); i++) {
            if (Pessoa.listaPessoas.get(i).getEmail().equals(email) && Pessoa.listaPessoas.get(i).getSenha().equals(senha)) {
                return i;
            }
        }
        return -1;
    }

    private static void menuPrincipal(int pessoa){
        switch (pessoa){
            case 1 -> System.out.print("\n---MENU AUTOR---" +
                    "\n1 - Cadastrar um livro;" +
                    "\n2 - Listar meus livros;" +
                    "\n3 - Livros a editar;");
            case 2 -> System.out.print("\n---MENU REVISOR---" +
                        "\n1 - Listar atividades;" +
                        "\n2 - Listar livros;" +
                        "\n3 - Editar livros;");
            case 3 -> System.out.print("\n---MENU DIRETOR---" +
                        "\n1 - Editar livros;" +
                        "\n2 - Listar atividades;" +
                        "\n3 - Cadastrar Revisor;" +
                        "\n4 - Listar livros;");

        }
        System.out.print("\n5 - Sair.\n-->: ");
        int decisao = sc.nextInt();
        if(decisao != 5){
            if(usuario instanceof Autor){
                switch (decisao){
                    case 1 -> cadastrarLivro();
                    case 2 -> usuario.listarLivros();
                    case 3 -> usuario.editarLivro();
                    case 4 -> usuario.listarAtividades();
                }
            } else if(usuario instanceof Revisor){
                    switch (decisao){
                        case 1 -> usuario.listarAtividades();
                        case 2 -> usuario.listarLivros();
                        case 3 -> usuario.editarLivro();
                    }
            } else if(usuario instanceof Diretor){
                switch (decisao){
                    case 1 -> usuario.editarLivro();
                    case 2 -> usuario.listarAtividades();
                    case 3 -> cadastro(2);
                    case 4 -> usuario.listarLivros();
                }
            }
        } else {
            menuLogin();
        }
        menuPrincipal(pessoa);
    }

    private static void menu(){
        String[] opcoes = usuario.opcoes();
        for(String opcao: opcoes){
            System.out.println(opcao);
        }
        int escolha = sc.nextInt();
        if(escolha == opcoes.length){
            System.exit(0);
        } else if(escolha == opcoes.length - 1){
            menuLogin();
        }else if(escolha >= 1 && escolha < opcoes.length){
            if(usuario instanceof Autor){
                switch (escolha){
                    case 2 -> usuario.listarLivros();
                }
            } else if(usuario instanceof Revisor){
                switch (escolha){
                    case 2 -> usuario.listarLivros();
                }
            } else if(usuario instanceof Diretor){

            }
        } else {
            menu();
        }
    }


    public static void editaLivroDiretor(Livro livro){
        System.out.println("---EDIÇÃO DO LIVRO: '" + livro.getTitulo() + "' ---");
        System.out.print("\n1 - Publicar livro;" +
                "\n2 - Reprovar livro;" +
                "\n3 - Retornar para o revisor. (Caso haja alguma falha no livro)");
        switch (sc.nextInt()){
            case 1 -> {
                System.out.println("Insira uma editora para o livro: '" + livro.getTitulo() + "'");
                for(int i = 0; i < Editora.listaEditoras.size(); i++){
                    System.out.println((i+1) + " - " + Editora.listaEditoras.get(i).toString());
                }
                System.out.print("Número da editora: ");
                adicionaEditora(sc.nextInt(), livro);
            }
            case 2 -> {
                livro.setStatus(5);
                System.out.println("Livro reprovado!");
            }
            case 3 -> {
                livro.setStatus(3);
                System.out.println("Livro reenviado ao revisor!");
            }
        }
    }

    private static void adicionaEditora(int num, Livro livro){
        livro.setEditora(Editora.listaEditoras.get(num-1));
        livro.setStatus(6);
        System.out.println("Livro publicado! Parabéns");
    }


    private static void cadastrarLivro(){
        System.out.print("\n---CADASTRO DE LIVROS---" +
                "\nInsira as seguintes informações:" +
                "\nTítulo: ");
        String titulo = sc.next();
        System.out.print("Quantidade de páginas: ");
        int qntdPaginas = sc.nextInt();
        System.out.print("Código ISBN: ");
        int isbn = sc.nextInt();
        Livro.listaLivros.add(new Livro((Autor)usuario, titulo, 3, isbn, qntdPaginas));
        System.out.println("Livro cadastrado com sucesso!!");
    }

    public static void editaLivro(Livro livro, ArrayList<Livro> listaLivrosRevisor){
        System.out.println("---EDIÇÃO DO LIVRO: '" + livro.getTitulo() + "' ---");
        if(livro.getStatus() == 3){
            System.out.print("Começar a revisão deste livro?" +
                    "\n1 - Sim;" +
                    "\n2 - Não." +
                    "\n-->: ");
            switch (sc.nextInt()){
                case 1 -> { livro.setStatus(2);
                    listaLivrosRevisor.add(livro);
                System.out.print("Livro em revisão!"); }
            }
        } else {
            System.out.print("1 - Aprovar livro (Será enviado ao diretor);" +
                    "\n2 - Mandar para reedição (Será enviado para o autor);" +
                    "\n3 - Reprovar livro (Será cancelado);" +
                    "\n4 - Atualizar a quantidade de páginas revisadas." +
                    "\n-->: ");
            switch (sc.nextInt()){
                case 1 -> {
                    livro.setStatus(1);
                    System.out.println("Livro aprovado!");}
                case 2 -> {
                    livro.setStatus(4);
                    System.out.println("Livro enviado para reedição!");
                }
                case 3 -> {
                    livro.setStatus(5);
                    System.out.println("Livro reprovado!");
                }
                case 4 -> {
                    System.out.print("Insira a quantidade de páginas revisadas: ");
                    double revisao = sc.nextDouble();
                    livro.setPaginasRevisadas((revisao * 100) / (livro.getQntdPaginas() - livro.getPaginasRevisadas()));
                }
            }
        }
    }

    public static int coletaLivro(){
        for(int i = 0; i < Livro.listaLivros.size(); i++){
            if(Livro.listaLivros.get(i).getStatus() == 3 || Livro.listaLivros.get(i).getStatus() == 2){
                System.out.println(" - " + Livro.listaLivros.get(i).toString());
            }
        }
        System.out.print("ISBN do livro a editar:" +
                "\n-->: ");
        int isbn = sc.nextInt();
        for(int i = 0; i < Livro.listaLivros.size(); i++){
            if(Livro.listaLivros.get(i).getISBN() == isbn){
                return i;
            }
        }
        return -1;
    }

    private static void cadastro(int opcao){
        if(opcao == 1){
            Pessoa.listaPessoas.add(coletaDadosPessoa(1));
        } else {
            Pessoa.listaPessoas.add(coletaDadosPessoa(2));
        }
        System.out.println("Usuário cadastrado com sucesso!!");
    };

    private static Pessoa coletaDadosPessoa(int opcao){
        System.out.print("---CADASTRO---" +
                "\nNome: ");
        String nome = sc.next();
        System.out.print("Sobrenome: ");
        String sobrenome = sc.next();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Gênero: ");
        String genero = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();
        switch (opcao){
            case 1 -> {
                return new Autor(cpf, nome, sobrenome, email, genero, senha);
            }
            case 2 -> {
                return new Revisor(cpf, nome, sobrenome, email, genero, senha);
            }
        }
    return null;
    };
}
