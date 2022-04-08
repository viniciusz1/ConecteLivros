public class Livro {
    private Autor autor;
    private Editora editora;
    private String titulo;
    private int status;
//    1 - Aprovado
//    2 - Em revisão
//    3 - Aguardando revisão
//    4 - Aguardando edição
//    5 - Reprovado
    private int qntdPaginas;
    private int ISBN;

    public Livro(Autor autor, String titulo, int status, int qntdPaginas, int ISBN) {
        this.autor = autor;
        this.titulo = titulo;
        this.status = status;
        this.qntdPaginas = qntdPaginas;
        this.ISBN = ISBN;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    @Override
    public String toString() {
        return "Livro{" +
                "autor=" + autor +
                ", editora=" + editora +
                ", titulo='" + titulo + '\'' +
                ", status=" + status +
                ", qntdPaginas=" + qntdPaginas +
                ", ISBN=" + ISBN +
                '}';
    }
}
