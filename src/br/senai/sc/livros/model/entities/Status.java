package br.senai.sc.livros.model.entities;

public enum Status {
    AGUARDANDO_REVISAO("Aguardando revisão"),
    EM_REVISAO("Em revisão"),
    APROVADO("Aprovado"),
    AGUARDANDO_EDICAO("Aguardando_edicao"),
    REPROVADO("Reprovado"),
    PUBLICADO("Publicado");

    String nome;

    Status(String nome){
        this.nome = nome;
    }
}
