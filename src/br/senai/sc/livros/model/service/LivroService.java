package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.LivroDAO;
import br.senai.sc.livros.model.entities.Livro;

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

    public void atualizar(int isbn, Livro livroAtualizado) {
        bd.atualizar(isbn, livroAtualizado);
    }
}
