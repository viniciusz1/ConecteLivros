package br.senai.sc.livros.model.entities;

import java.util.ArrayList;

public class Editora {
    private String nome, CNPJ;

    static ArrayList<Editora> listaEditoras = new ArrayList<>();

    public Editora(String nome, String CNPJ) {
        this.nome = nome;
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public String toString() {
        return "Editora{" +
                "nome='" + nome + '\'' +
                ", CNPJ='" + CNPJ + '\'' +
                '}';
    }
}
