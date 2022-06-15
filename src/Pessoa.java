import java.util.ArrayList;

public abstract class Pessoa {
    private String CPF, nome, sobrenome, email, genero, senha;

    public abstract void listarLivros();
    public abstract void editarLivro() throws RuntimeException;
    public abstract String listarAtividades();
    public abstract String[] opcoes();

    static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    public Pessoa(String CPF, String nome, String sobrenome, String email, String genero, String senha) {
        this.CPF = CPF;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.genero = genero;
        this.senha = senha;
    }


    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "CPF='" + CPF + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", genero='" + genero + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
