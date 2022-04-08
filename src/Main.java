import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Editora rocco = new Editora("Rocco", "74599856000161");
        Editora intrinseca = new Editora("Intrínseca", "20388395000159");
        Editora arqueiro = new Editora("Arqueiro", "65504629000114");
        Pessoa.listaPessoas.add(new Diretor("11209407965", "Leonardo", "Rafaelli", "leonardorafaelli@gmail.com", "Masculino", "123"));
        menuLogin();
    }

    private static void menuLogin(){
        System.out.print("---MENU---" +
                "\n1 - Logar" +
                "\n2 - Cadastrar-se" +
                "\n->: ");
        switch (sc.nextInt()){
            case 1 -> login();
            case 2 -> cadastroAutor();
            default -> {
                System.out.println("Opção inválida!");
                menuLogin();
            }
        }
    }

    private static void login() {
        System.out.print("---LOGIN---" +
                "\nDigite seu email: ");
        String email = sc.next();
        System.out.print("Digite sua senha: ");
        String senha = sc.next();
        boolean verifica = false;

        for (int i = 0; i < Pessoa.listaPessoas.size(); i++) {
            if (Pessoa.listaPessoas.get(i).getEmail().equals(email) && Pessoa.listaPessoas.get(i).getSenha().equals(senha)) {
                if (Pessoa.listaPessoas.get(i) instanceof Autor) {
                    menuPrincipal(1);
                } else if (Pessoa.listaPessoas.get(i) instanceof Revisor) {
                    menuPrincipal(2);
                } else {
                    menuPrincipal(3);
                }
                verifica = true;
            }
        }
        if (!verifica){
            System.out.println("Email e/ou senha incorretos!");
            login();
        }
    }

    private static void menuPrincipal(int pessoa){
        System.out.println("Teste");
    }

    private static void cadastroAutor(){
        System.out.println();
    };

    private static Pessoa coletaDadosPessoa(int opcao){
        System.out.println("---CADASTRO---" +
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
        System.out.print("Senha:");
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
