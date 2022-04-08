import java.util.ArrayList;

public class Autor extends Pessoa{
    private ArrayList<Livro> listaLivrosAutor = new ArrayList<Livro>();
    static ArrayList<Autor> listaAutores = new ArrayList<Autor>();

    public Autor(String CPF, String nome, String sobrenome, String email, String genero, String senha) {
        super(CPF, nome, sobrenome, email, genero, senha);
    }

    public ArrayList<Livro> getListaLivrosAutor() {
        return listaLivrosAutor;
    }

    public void setListaLivrosAutor(ArrayList<Livro> listaLivrosAutor) {
        this.listaLivrosAutor = listaLivrosAutor;
    }
}
