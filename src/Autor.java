import java.util.ArrayList;

public class Autor extends Pessoa{
    static ArrayList<Autor> listaAutores = new ArrayList<Autor>();

    @Override
    public void listarLivros() {
        System.out.println("\n---MEUS LIVROS---");
        for(int i = 0; i < Livro.listaLivros.size(); i++){
            if(Livro.listaLivros.get(i).getAutor() == Main.usuario){
                System.out.println(" - " + Livro.listaLivros.get(i).toString());
            }
        }
    }

    @Override
    public void editarLivro() {
        for (int i = 0; i < Livro.listaLivros.size(); i++){
            if(Livro.listaLivros.get(i).getStatus() == 4){
                System.out.println(" - " + Livro.listaLivros.get(i).toString());
            }
        }
        int i = Main.coletaLivro();
        if(i > -1){
            Livro.listaLivros.get(i).setStatus(3);
            System.out.println("Livro reenviado a edição!");
        } else {
            System.out.println("ISBN inválido!");
        }
    }

    @Override
    public String[] opcoes() {
        String[] opcoes = {
                "1 - Listar atividades;",
                "2 - Listar meus livros;",
                "3 - Cadastrar um livro;",
                "4 - Sair;",
                "5 - Encerrar."
        };
        return opcoes;
    }



    @Override
    public String listarAtividades() {
        String livros = "";
        for (int i = 0; i < Livro.listaLivros.size(); i++){
            if(Livro.listaLivros.get(i).getAutor() == Main.usuario && Livro.listaLivros.get(i).getStatus() == 4){
                livros += Livro.listaLivros.get(i).toString();
            }
        }
        return livros;
    }

    public Autor(String CPF, String nome, String sobrenome, String email, String genero, String senha) {
        super(CPF, nome, sobrenome, email, genero, senha);
    }


}
