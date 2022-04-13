import java.util.ArrayList;

public class Autor extends Pessoa{
    static ArrayList<Autor> listaAutores = new ArrayList<Autor>();


    public Autor(String CPF, String nome, String sobrenome, String email, String genero, String senha) {
        super(CPF, nome, sobrenome, email, genero, senha);
    }


}
