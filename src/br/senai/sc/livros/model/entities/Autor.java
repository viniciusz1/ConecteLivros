package br.senai.sc.livros.model.entities;

import Exceptions.CodigoInvalidoException;

import java.util.ArrayList;

public class Autor extends Pessoa {
    static ArrayList<Autor> listaAutores = new ArrayList<Autor>();

    public Autor(String CPF, String nome, String sobrenome, String email, Genero genero, String senha) {
        super(CPF, nome, sobrenome, email, genero, senha);
    }


}
