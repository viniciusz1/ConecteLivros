import java.util.ArrayList;

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
//    6 - Publicado
    private int qntdPaginas;
    private double paginasRevisadas = 0;
    private int ISBN;

    static ArrayList<Livro>listaLivros = new ArrayList<Livro>();

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

    public double getPaginasRevisadas() {
        return paginasRevisadas;
    }

    public void setPaginasRevisadas(double paginasRevisadas) {
        this.paginasRevisadas = paginasRevisadas;
    }

    @Override
    public String toString() {
        String statusStri = null, editoraNome = null;
        switch(status){
            case 1 -> statusStri = "Aprovado";
            case 2 -> statusStri = "Em revisão";
            case 3 -> statusStri = "Aguardando revisão";
            case 4 -> statusStri = "Aguardando edição";
            case 5 -> statusStri = "Reprovado";
        }

        if(editora == null){
            editoraNome = "Livro não publicado";
        } else {
            editoraNome = editora.getNome();
        }

        return "Livro{" +
                "autor=" + autor.getNome() +
                ", editora=" + editoraNome +
                ", titulo='" + titulo + '\'' +
                ", status=" + statusStri +
                ", qntdPaginas=" + qntdPaginas +
                ", ISBN=" + ISBN +
                ", % Páginas revisadas: " + paginasRevisadas +
                '}';
    }
}
