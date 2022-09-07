import br.senai.sc.livros.model.dao.LivroDAO;
import br.senai.sc.livros.model.entities.Autor;
import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Livro;
import br.senai.sc.livros.model.entities.Status;

import java.util.Collection;
import java.util.HashSet;

public class Teste {
    public static void main(String[] args) {
        Livro livro = (new Livro(new Autor("123", "Fernando", "de Noronha", "123@321", Genero.FEMININO, "123"),
                "A água", Status.AGUARDANDO_EDICAO, 348, 2345));
        teste(livro.getISBN());
        teste(livro.getTitulo());
        teste(livro.getAutor());
    }
    public static void teste(Object o){
        System.out.println(o);
    }
}
