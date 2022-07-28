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
        for(Pessoa pessoa : listaPessoas){
            if(pessoa.getCPF().equals(CPF)) return pessoa;
        }
        throw new RuntimeException("CPF não encontrado!");
    }
    public Pessoa selecionarPorEmail(String email){
        for(Pessoa pessoa : listaPessoas){
            if(pessoa.getEmail().equals(email)){
                return pessoa;
            }
        }
        throw new RuntimeException("Email não encontrado!");
    }
}
