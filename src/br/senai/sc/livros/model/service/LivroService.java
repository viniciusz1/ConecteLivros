package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.LivroDAO;
import br.senai.sc.livros.model.entities.Livro;
import br.senai.sc.livros.model.entities.Pessoa;
import br.senai.sc.livros.model.entities.Status;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class LivroService {
    LivroDAO bd = new LivroDAO();

    public Boolean inserir(Livro livro) throws SQLException {
        return bd.inserir(livro);
    }

    public void remover(Livro livro) {
        bd.remover(livro);
    }

    public Livro selecionar(int isbn) {

        return bd.selecionar(isbn);
    }

    public void atualizar(int isbn, Livro livroAtualizado)
    {
        bd.atualizar(isbn, livroAtualizado);
    }

    public Collection<Livro> selecionarLista() {
        return bd.selecionarLista();
    }

    public Collection<Livro> selecionarPorAutor(Pessoa pessoa) {
        return bd.selecionarPorAutor(pessoa);
    }

    public Collection<Livro> selecionarAtividadesAutor(Pessoa pessoa) {
        return bd.selecionarAtividadesAutor(pessoa);
    }

    public Collection<Livro> selecionarPorStatus(Status status) {
        return bd.selecionarPorStatus(status);
    }
}
