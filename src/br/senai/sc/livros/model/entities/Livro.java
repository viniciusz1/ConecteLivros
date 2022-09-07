package br.senai.sc.livros.model.entities;

import java.util.ArrayList;
import java.util.Objects;

public class Livro {
    private Autor autor;
    private Editora editora;
    private String titulo;
    private Status status;
    private Double paginasRevisadas = 0.0;
    private Integer ISBN;
    private Integer qntdPaginas;

    static ArrayList<Livro>listaLivros = new ArrayList<Livro>();
    public Livro(){};


    public Livro(Autor autor, String titulo, Status status, int qntdPaginas, int ISBN) {
        this.autor = autor;
        this.titulo = titulo;
        this.status = status;
        this.qntdPaginas = qntdPaginas;
        this.ISBN = ISBN;
    }

    public static Livro cadastrar(String titulo, int isbn, int qtdPag, Autor autor){
        return new Livro(autor, titulo, Status.AGUARDANDO_REVISAO, qtdPag, isbn);
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getQntdPaginas() {
        return qntdPaginas;
    }

    public void setQntdPaginas(int qntdPaginas) {
        this.qntdPaginas = qntdPaginas;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public double getPaginasRevisadas() {
        return paginasRevisadas;
    }

    public void setPaginasRevisadas(double paginasRevisadas) {
        this.paginasRevisadas = paginasRevisadas;
    }

    @Override
    public boolean equals(Object o) {
    //    if (this == o) return true;
    //    if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return ISBN == livro.ISBN;
    }

    @Override
    public int hashCode() {
        return ISBN;
    }

    @Override
public String toString() {
        String editoraNome = null;

        if(editora == null){
            editoraNome = "Livro não publicado";
        } else {
            editoraNome = editora.getNome();
        }

        return "Livro{" +
                "autor=" + autor.getNome() +
                ", editora=" + editoraNome +
                ", titulo='" + titulo + '\'' +
                ", status=" + status.nome +
                ", qntdPaginas=" + qntdPaginas +
                ", ISBN=" + ISBN +
                ", % Páginas revisadas: " + paginasRevisadas +
                '}';
    }
}
