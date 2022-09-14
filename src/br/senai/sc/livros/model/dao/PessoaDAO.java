package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PessoaDAO {
    private static final Set<Pessoa> listaPessoas = new HashSet<>();

    static{
        listaPessoas.add(new Autor("12435678", "Leozin", "Rafaellizin",
                "autor@", Genero.MASCULINO, "123"));
        listaPessoas.add(new Revisor("1265", "LeGSFDozin", "RafaeHTFDllizin",
                "revisor@", Genero.MASCULINO, "123"));
        listaPessoas.add(new Diretor("1243657565678", "LeSDAozin", "RafaHDFGellizin",
                "diretor@", Genero.MASCULINO, "123"));
    }

    public void inserir(Pessoa pessoa) throws SQLException {

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();

        String query = "insert into pessoas(cpfPessoa, nomePessoa, sobrenomePessoa, emailPessoa, senhaPessoa," +
                "generoPessoa)values(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, pessoa.getCPF());
        statement.setString(2, pessoa.getNome());
        statement.setString(3, pessoa.getSobrenome());
        statement.setString(4, pessoa.getEmail());
        statement.setString(5, pessoa.getSenha());
        statement.setString(6, pessoa.getGenero().name());
        statement.execute();

        query = "insert into autores(PESSOAS_cpfPessoa)values(?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, pessoa.getCPF());
        statement.execute();


        connection.close();
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
