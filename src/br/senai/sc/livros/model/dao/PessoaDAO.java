package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.Livro;
import br.senai.sc.livros.model.entities.Pessoa;

import java.util.ArrayList;

public class PessoaDAO {
    private static ArrayList<Pessoa> listaPessoas = new ArrayList();


    public void inserir(Pessoa pessoa){
        listaPessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa){
        listaPessoas.remove(pessoa);
    }

    public Pessoa selecionarPorCPF(String CPF){
        return (Pessoa)listaPessoas.stream().filter((Pessoa e) -> e.getCPF().equals(CPF));
    }
    public Pessoa selecionarPorEmail(String email){
        return (Pessoa)listaPessoas.stream().filter((Pessoa e) -> e.getEmail().equals(email));
    }
}
