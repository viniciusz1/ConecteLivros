package br.senai.sc.livros.model.entities;

import br.senai.sc.livros.view.Menu;

import java.util.ArrayList;
import java.util.Objects;

public class Pessoa {
    private String CPF, nome, sobrenome, email, senha;
    private Genero genero;

//    public abstract void listarLivros();
//    public abstract void editarLivro() throws RuntimeException;
//    public abstract String listarAtividades();
//    public abstract String[] opcoes();

    static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        Pessoa outraPessoa = (Pessoa) o;
        return CPF.equals(outraPessoa.CPF);
    }

    @Override
    public int hashCode() {
        return CPF.charAt(0);
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
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


    public Pessoa validaLogin(String senha) {
        if (this.getSenha().equals(senha)) {
            return this;
        }
        ;
        throw new RuntimeException("Senha incorreta!");
    }


    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    public static Pessoa cadastrar(String nome, String sobrenome, String email, Genero genero, String senha, String cpf, String confSenha) {
        if (senha.equals(confSenha)) {
            if (email.contains("@")) {
                if (Menu.getUsuario() instanceof Diretor) {
                    return new Revisor(cpf, nome, sobrenome, email, genero, senha);
                } else {
                    return new Autor(cpf, nome, sobrenome, email, genero, senha);
                }
            } else {
                throw new RuntimeException("Email inválido!");
            }
        } else {
            throw new RuntimeException("Senhas não conferem!");
        }
    }

    ;
}
