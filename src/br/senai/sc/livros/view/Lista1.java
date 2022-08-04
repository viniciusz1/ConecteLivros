package br.senai.sc.livros.view;

import br.senai.sc.livros.model.entities.Livro;

import java.util.ArrayList;

public class Lista1 extends DefaultTableModelArrayList{
    public Lista1(ArrayList<Livro> lista) {
        super(lista);
    }
}
