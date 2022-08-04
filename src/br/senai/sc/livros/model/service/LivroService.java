package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.LivroDAO;
import br.senai.sc.livros.model.entities.Livro;
import br.senai.sc.livros.model.entities.Pessoa;
import br.senai.sc.livros.model.entities.Status;

import java.util.ArrayList;

public class LivroService {
    LivroDAO bd = new LivroDAO();

    public void inserir(Livro livro) {
        bd.inserir(livro);
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

    public ArrayList<Livro> selecionarLista() {
        return bd.selecionarLista();
    }

    public ArrayList<Livro> selecionarPorAutor(Pessoa pessoa) {
        return bd.selecionarPorAutor(pessoa);
    }

    public ArrayList<Livro> selecionarAtividadesAutor(Pessoa pessoa) {
        return bd.selecionarAtividadesAutor(pessoa);
    }

    public ArrayList<Livro> selecionarPorStatus(Status status) {
        return bd.selecionarPorStatus(status);
    }
}
