package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;

import java.util.ArrayList;

public class LivroDAO {
    private static ArrayList<Livro> listaLivros = new ArrayList<>();

//    Autor autor, String titulo, Status status, int qntdPaginas, int ISBN
    static{
        listaLivros.add(new Livro(new Autor("12435678", "Leozin", "Rafaellizin",
                        "autor@", Genero.MASCULINO, "123"),
                "O fogo", Status.AGUARDANDO_REVISAO, 568, 1234));
        listaLivros.add(new Livro(new Autor("123", "Bernadete", "#@!", "123@321", Genero.FEMININO, "123"),
                "A água", Status.AGUARDANDO_EDICAO, 348, 2345));
        listaLivros.add(new Livro(new Autor("123", "Bernadete", "#@!", "123@321", Genero.FEMININO, "123"),
                "A pedra", Status.AGUARDANDO_REVISAO, 346, 2542));
        listaLivros.add(new Livro(new Autor("123", "Bernadete", "#@!", "123@321", Genero.FEMININO, "123"),
                "O Henrique", Status.AGUARDANDO_REVISAO, 467, 4367));
    }


    public void inserir(Livro livro){
        listaLivros.add(livro);
    }

    public void remover(Livro livro){
        listaLivros.remove(livro);
    }

    public Livro selecionar(int isbn){
        for(Livro livro : listaLivros){
            if(livro.getISBN() == isbn){
                return livro;
            }
        };
        return null;
    }

    public void atualizar(int isbn, Livro livroAtualizado){
        int i = listaLivros.indexOf(selecionar(isbn));
        listaLivros.set(i, livroAtualizado);
    }

    public ArrayList<Livro> selecionarLista(){
      return listaLivros;
    };

    public ArrayList<Livro> selecionarPorAutor(Pessoa pessoa){
        ArrayList<Livro> livrosAutor = new ArrayList<>();
        for(Livro livro : listaLivros){
            if(livro.getAutor().getCPF().equals(pessoa.getCPF())){
                System.out.println("adicionou");
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

    public ArrayList<Livro> selecionarAtividadesAutor(Pessoa pessoa){
        ArrayList<Livro> livrosAutor = new ArrayList<>();
        for(Livro livro : selecionarLista()){
            if(livro.getAutor().equals(pessoa) && livro.getStatus().equals(Status.AGUARDANDO_EDICAO)){
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

    public ArrayList<Livro> selecionarPorStatus(Status status){
        ArrayList<Livro> livrosStatus = new ArrayList<>();
        for(Livro livro : selecionarLista()){
            if(livro.getStatus() == status){
                livrosStatus.add(livro);
            }
        }
        return livrosStatus;
    }


}
