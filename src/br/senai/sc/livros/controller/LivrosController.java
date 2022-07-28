package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.Autor;
import br.senai.sc.livros.model.entities.Editora;
import br.senai.sc.livros.model.entities.Livro;
//Objeto que vai intermediar a view com a classe livros;
//Livro livro = new Livro(new Autor("123","Leo","Rafaelli","leonardo@gmail.com","masc","123"), "Fourteen Ways To Do It", 3, 7000, 1243578);
//LivrosView livroView = new LivroView();

public class LivrosController {

        Livro livro = new Livro();

    public Autor getAutor() {
        return livro.getAutor();
    }

    public void setAutor(Autor autor) {
        livro.setAutor(autor);
    }

    public Editora getEditora() {
        return livro.getEditora();
    }

    public void setEditora(Editora editora) {
        livro.setEditora(editora);
    }

    public String getTitulo() {
        return livro.getTitulo();
    }

    public void setTitulo(String titulo) {
        livro.setTitulo(titulo);
    }

    public int getStatus() {
        return livro.getStatus();
    }

    public void setStatus(int status) {
        livro.setStatus(status);
    }

    public int getQntdPaginas() {
        return livro.getQntdPaginas();
    }

    public void setQntdPaginas(int qntdPaginas) {
        livro.setQntdPaginas(qntdPaginas);
    }

    public int getISBN() {
        return livro.getISBN();
    }

    public void setISBN(int ISBN) {
        livro.setISBN(ISBN);
    }

    public double getPaginasRevisadas() {
        return livro.getPaginasRevisadas();
    }

    public void setPaginasRevisadas(double paginasRevisadas) {
        livro.setPaginasRevisadas(paginasRevisadas);
    }
}
