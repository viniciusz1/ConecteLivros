package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Pessoa;
import br.senai.sc.livros.model.service.PessoaService;

public class PessoaController {
    Pessoa pessoa;

    public boolean validaLogin(String email, String senha) {
        PessoaService service = new PessoaService();
        pessoa = service.selecionarPorEmail(email);
        return pessoa.validaLogin(pessoa.getSenha());
    }

    public void cadastrar(String nome, String sobrenome, String email, Object genero, String senha, String cpf) {
        PessoaService service = new PessoaService();
        service.inserir(pessoa.cadastrar(nome, sobrenome, email, (Genero)genero, senha, cpf));
    }
}
