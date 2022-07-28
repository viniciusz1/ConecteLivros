package br.senai.sc.livros.model.entities;

import java.util.ArrayList;

public class Pessoa {
    private String CPF, nome, sobrenome, email, senha;
    private Genero genero;

//    public abstract void listarLivros();
//    public abstract void editarLivro() throws RuntimeException;
//    public abstract String listarAtividades();
//    public abstract String[] opcoes();

    static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public Pessoa(String CPF, String nome, String sobrenome, String email, Genero genero, String senha) {
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean validaLogin(String senha){
        return this.getSenha().equals(senha);
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

    public static Pessoa cadastrar(String nome, String sobrenome, String email, Genero genero, String senha, String cpf){
        return new Pessoa(cpf,nome,sobrenome,email,genero,senha);
    };
}
