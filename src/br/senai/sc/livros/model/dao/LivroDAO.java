package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.*;

import java.util.*;

public class LivroDAO {
    private static Collection<Livro> listaLivros = new HashSet<>();

    //    Autor autor, String titulo, Status status, int qntdPaginas, int ISBN
    static {
        listaLivros.add(new Livro(new Autor("12435678", "Vinícius", "Bonatti",
                "autor@", Genero.MASCULINO, "123"),
                "O fogo", Status.AGUARDANDO_REVISAO, 568, 1234));
        listaLivros.add(new Livro(new Autor("123", "Fernando", "de Noronha", "123@321", Genero.FEMININO, "123"),
                "A água", Status.AGUARDANDO_EDICAO, 348, 2345));
        listaLivros.add(new Livro(new Autor("123", "Sergipe", "Minas", "123@321", Genero.FEMININO, "123"),
                "A pedra", Status.AGUARDANDO_REVISAO, 346, 2542));
        listaLivros.add(new Livro(new Autor("123", "Cliengle", "Binaudo", "123@321", Genero.FEMININO, "123"),
                "O Henrique", Status.EM_REVISAO, 467, 4367));
        listaLivros.add(new Livro(new Autor("123", "Cliengle", "Binaudo", "123@321", Genero.FEMININO, "123"),
                "O Henrique", Status.APROVADO, 467, 4363));
        listaLivros.add(new Livro(new Autor("123", "Cliengle", "Binaudo", "123@321", Genero.FEMININO, "123"),
                "O Henrique", Status.REPROVADO, 467, 4364));
        listaLivros.add(new Livro(new Autor("123", "Cliengle", "Binaudo", "123@321", Genero.FEMININO, "123"),
                "O Henrique", Status.REPROVADO, 467, 4365));

    }


    public Boolean inserir(Livro livro) {
        Boolean tmp = !listaLivros.contains(livro);
        listaLivros.add(livro);
        return tmp;
    }

    public void remover(Livro livro) {
        listaLivros.remove(livro);
    }

    public Livro selecionar(int isbn) {
        for (Livro livro : listaLivros) {
            if (livro.getISBN() == isbn) {
                return livro;
            }
        }
        return null;
    }

    public void atualizar(int isbn, Livro livroAtualizado) {

        for (Livro livro : listaLivros) {
            if (livro.getISBN() == isbn) {
                listaLivros.remove(livro);
                listaLivros.add(livroAtualizado);
            }
        }
    }

    public Collection<Livro> selecionarLista() {
        return Collections.unmodifiableCollection(listaLivros);
    }

    public Collection<Livro> selecionarPorAutor(Pessoa pessoa) {
        Collection<Livro> livrosAutor = new ArrayList<>();
        for (Livro livro : listaLivros) {
            if (livro.getAutor().getCPF().equals(pessoa.getCPF())) {
                System.out.println("adicionou");
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

    public Collection<Livro> selecionarAtividadesAutor(Pessoa pessoa) {
        Collection<Livro> livrosAutor = new ArrayList<>();
        for (Livro livro : selecionarLista()) {
            if (livro.getAutor().equals(pessoa) && livro.getStatus().equals(Status.AGUARDANDO_EDICAO)) {
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

    public Collection<Livro> selecionarPorStatus(Status status) {
        Collection<Livro> livrosStatus = new ArrayList<>();
        for (Livro livro : selecionarLista()) {
            if (livro.getStatus() == status) {
                livrosStatus.add(livro);
            }
        }
        return livrosStatus;
    }


}
