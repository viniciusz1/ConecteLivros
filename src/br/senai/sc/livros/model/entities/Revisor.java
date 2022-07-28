package br.senai.sc.livros.model.entities;

import Exceptions.CodigoInvalidoException;

import java.util.ArrayList;

public class Revisor extends Pessoa {

    private ArrayList<Livro> listaLivrosRevisor = new ArrayList<>();

//    @Override
//    public void listarLivros() {
//        System.out.println("\n---LIVROS AGUARDANDO REVISÃO---");
//        for(int i = 0; i < Livro.listaLivros.size(); i++){
//            if(Livro.listaLivros.get(i).getStatus() == 3){
//                System.out.println(" - " + Livro.listaLivros.get(i).toString());
//            }
//        }
//    }
//
//    @Override
//    public void editarLivro() {
//        System.out.println("\n---LIVROS A EDITAR---");
//        int i = Main.coletaLivro(0);
//        if(i > -1){
//            Livro livro = Livro.listaLivros.get(i);
//            Main.editaLivro(livro, this.listaLivrosRevisor);
//        } else {
//            throw new CodigoInvalidoException();
//        }
//    }
//
//    public String[] opcoes() {
//        String[] opcoes = {
//                "1 - Cadastrar um livro;",
//                "2 - Listar meus livros;",
//                "3 - Livros a editar;",
//                "4 - Sair;",
//                "5 - Encerrar."};
//        return opcoes;
//    };
//
//    @Override
//    public String listarAtividades() {
//        String livros = "";
//        for (int i = 0; i < this.listaLivrosRevisor.size(); i++){
//            livros += listaLivrosRevisor.get(i).toString();
//        }
//        return livros;
//    }

    public Revisor(String CPF, String nome, String sobrenome, String email, Genero genero, String senha) {
        super(CPF, nome, sobrenome, email, genero, senha);
    }

    public ArrayList<Livro> getListaLivrosRevisor() {
        return listaLivrosRevisor;
    }

    public void setListaLivrosRevisor(ArrayList<Livro> listaLivrosRevisor) {
        this.listaLivrosRevisor = listaLivrosRevisor;
    }
}
