package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.*;
import br.senai.sc.livros.model.service.LivroService;
import br.senai.sc.livros.view.Menu;

import java.util.ArrayList;
//Objeto que vai intermediar a view com a classe livros;
//Livro livro = new Livro(new Autor("123","Leo","Rafaelli","leonardo@gmail.com","masc","123"), "Fourteen Ways To Do It", 3, 7000, 1243578);
//LivrosView livroView = new LivroView();

public class LivrosController {

    Livro model = new Livro();

    public Autor getAutor() {
        return model.getAutor();
    }

    public void setAutor(Autor autor) {
        model.setAutor(autor);
    }

    public Editora getEditora() {
        return model.getEditora();
    }

    public void setEditora(Editora editora) {
        model.setEditora(editora);
    }

    public String getTitulo() {
        return model.getTitulo();
    }

    public void setTitulo(String titulo) {
        model.setTitulo(titulo);
    }

    public Status getStatus() {
        return model.getStatus();
    }

    public void setStatus(Status status) {
        model.setStatus(status);
    }

    public int getQntdPaginas() {
        return model.getQntdPaginas();
    }

    public void setQntdPaginas(int qntdPaginas) {
        model.setQntdPaginas(qntdPaginas);
    }

    public int getISBN() {
        return model.getISBN();
    }

    public void setISBN(int ISBN) {
        model.setISBN(ISBN);
    }

    public double getPaginasRevisadas() {
        return model.getPaginasRevisadas();
    }

    public void setPaginasRevisadas(double paginasRevisadas) {
        model.setPaginasRevisadas(paginasRevisadas);
    }

    public void cadastrar(String titulo, String isbn, String qtdPag, Pessoa autor) {
        Livro livro;
        LivroService service = new LivroService();
        livro = Livro.cadastrar(titulo, Integer.parseInt(isbn), Integer.parseInt(qtdPag), (Autor) autor);
        service.inserir(livro);
    }

    public ArrayList<Livro> selecionarLista(int lista) {
        LivroService livroService = new LivroService();
        Pessoa usuario = Menu.getUsuario();
        if (usuario instanceof Autor) {
            if (lista == 1) {
                return livroService.selecionarPorAutor(usuario);
            } else {
                return livroService.selecionarAtividadesAutor(usuario);
            }
        } else if (usuario instanceof Revisor) {
            if (lista == 1) {
                return livroService.selecionarPorStatus(Status.AGUARDANDO_REVISAO);
            } else {
                return livroService.selecionarPorStatus(Status.EM_REVISAO);
            }
        } else {
            if (lista == 1) {
                return livroService.selecionarLista();
            } else {
                return livroService.selecionarPorStatus(Status.APROVADO);
            }
        }
    }

    public void editarLivro(String isbn, Livro novoLivro) {
        LivroService livroService = new LivroService();
        livroService.atualizar(Integer.parseInt(isbn), novoLivro);
    }

    public void editarLivro(String isbn) {
        LivroService livroService = new LivroService();
        Livro livroAtualizado = livroService.selecionar(Integer.parseInt(isbn));
        if(Menu.getUsuario() instanceof Autor){
            livroAtualizado.setStatus(Status.AGUARDANDO_REVISAO);
        }
        livroService.atualizar(Integer.parseInt(isbn), livroAtualizado);
    }

}
