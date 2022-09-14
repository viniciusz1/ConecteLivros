package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.*;
import br.senai.sc.livros.model.service.LivroService;
import br.senai.sc.livros.view.Menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
//Objeto que vai intermediar a view com a classe livros;
//Livro livro = new Livro(new Autor("123","Leo","Rafaelli","leonardo@gmail.com","masc","123"), "Fourteen Ways To Do It", 3, 7000, 1243578);
//LivrosView livroView = new LivroView();

public class LivrosController {

    Livro model = new Livro();

    public Boolean cadastrar(String titulo, String isbn, String qtdPag, Pessoa autor) throws SQLException {
        Livro livro;
        LivroService service = new LivroService();
        livro = Livro.cadastrar(titulo, Integer.parseInt(isbn), Integer.parseInt(qtdPag), (Autor) autor);
        return service.inserir(livro);
    }

    public Collection<Livro> selecionarLista(int lista) {
        LivroService livroService = new LivroService();
        Pessoa usuario = Menu.getUsuario();
        if (usuario instanceof Autor) {
            if (lista == 1) {
                return livroService.selecionarPorAutor(usuario);
            } else {
                return livroService.selecionarAtividadesAutor(usuario);
            }
        } else if (usuario instanceof Revisor) {
            if (lista == 1) {
                return livroService.selecionarPorStatus(Status.AGUARDANDO_REVISAO);
            } else {
                return livroService.selecionarPorStatus(Status.EM_REVISAO);
            }
        } else {
            if (lista == 1) {
                return livroService.selecionarLista();
            } else {
                return livroService.selecionarPorStatus(Status.APROVADO);
            }
        }
    }

    public void editarLivro(String isbn, Livro novoLivro) {
        LivroService livroService = new LivroService();
        livroService.atualizar(Integer.parseInt(isbn), novoLivro);
    }

    public void editarLivro(String isbn) {
        LivroService livroService = new LivroService();
        Livro livroAtualizado = livroService.selecionar(Integer.parseInt(isbn));
        if(Menu.getUsuario() instanceof Autor){
            livroAtualizado.setStatus(Status.AGUARDANDO_REVISAO);
        }
        livroService.atualizar(Integer.parseInt(isbn), livroAtualizado);
    }

}
