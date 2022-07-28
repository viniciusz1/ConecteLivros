package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.Pessoa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroLivro extends JFrame{
    private JButton voltarButton;
    private JButton cadastrarButton;
    private JTextField tituloInput;
    private JTextField isbnInput;
    private JTextField qtdPagInput;
    private JPanel cadastroLivro;

    CadastroLivro(Pessoa usuario) {
        criarComponentes();
        cadastrarButton.addActionListener(e -> {
            String titulo = tituloInput.getText();
            String isbn = isbnInput.getText();
            String qtdPag = qtdPagInput.getText();
            if(titulo.isEmpty() ||
                isbn.isEmpty() ||
                qtdPag.isEmpty() ){
                JOptionPane.showMessageDialog(null, "Há campos vazios!");
            } else {
                LivrosController controller = new LivrosController();
                controller.cadastrar(titulo, isbn, qtdPag, usuario);
            }
        });
    }

    private void criarComponentes() {
        setContentPane(cadastroLivro);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

}
