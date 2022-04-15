public class Diretor extends Pessoa{

    @Override
    public void listarLivros() {
        System.out.println("\n---LISTAGEM DE TODOS OS LIVROS---");
        for (int i = 0; i < Livro.listaLivros.size(); i++){
            System.out.println(" - " + Livro.listaLivros.get(i).toString());
        }
    }

    @Override
    public void editarLivro() {
        System.out.println("\n---LISTAGEM DE ATIVIDADES---");
        for (int i = 0; i < Livro.listaLivros.size(); i++){
            if(Livro.listaLivros.get(i).getStatus() == 1){
                System.out.println(" - " + Livro.listaLivros.get(i).toString());
            }
        }

        int i = Main.coletaLivro();

        if(i > -1){
            Livro livro = Livro.listaLivros.get(i);
            Main.editaLivroDiretor(livro);
        } else {
            System.out.println("ISBN inexistente!");
        }
    }

    @Override
    public String[] opcoes() {
        String[] opcoes = {"1 - Cadastrar um livro;",
                "2 - Listar meus livros;",
                "3 - Livros a editar;",
                "4 - Sair;",
                "5 - Encerrar."
        };
        return opcoes;

    }


    @Override
    public String listarAtividades() {
        String livros = "";
        for (int i = 0; i < Livro.listaLivros.size(); i++){
            if(Livro.listaLivros.get(i).getStatus() == 1){
                livros += Livro.listaLivros.get(i).toString();
            }
        }
        return livros;
    }
    public Diretor(String CPF, String nome, String sobrenome, String email, String genero, String senha) {
        super(CPF, nome, sobrenome, email, genero, senha);
    }
}
