package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.Livro;

import java.util.ArrayList;

public class LivroDAO {
    private static ArrayList<Livro> listaLivros = new ArrayList<>();

    public void inserir(Livro livro){
        listaLivros.add(livro);
    }

    public void remover(Livro livro){
        listaLivros.remove(livro);
    }

    public Livro selecionar(int isbn){
        return (Livro)listaLivros.stream().filter((Livro e) -> e.getISBN() == isbn);
    }

    public void atualizar(int isbn, Livro livroAtualizado){
        int i = listaLivros.indexOf(selecionar(isbn));
        listaLivros.set(i, livroAtualizado);
    }


}
