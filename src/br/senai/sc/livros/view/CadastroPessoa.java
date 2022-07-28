package br.senai.sc.livros.view;

import br.senai.sc.livros.model.service.PessoaService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPessoa extends JFrame{
    private JButton voltarButton;
    private JButton cadastrarButton;
    private JPanel cadastroPessoa;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;

    public CadastroPessoa() {
        criarComponentes();
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().run();
                dispose();
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PessoaService service = new PessoaService();
            }
        });
    }

    public void criarComponentes() {
        setContentPane(cadastroPessoa);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
