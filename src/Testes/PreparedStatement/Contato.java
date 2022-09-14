package Testes.PreparedStatement;

import java.util.Objects;

public class Contato {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private Integer idade;

    public Contato(Integer id, String nome, String email, String telefone, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
    }

    public Contato(String nome, String email, String telefone, Integer idade) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && email.equals(contato.email) && telefone.equals(contato.telefone) && idade.equals(contato.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone, idade);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", idade=" + idade +
                '}';
    }
}
