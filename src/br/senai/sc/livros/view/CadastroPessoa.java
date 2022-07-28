package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.PessoaController;
import br.senai.sc.livros.model.entities.Genero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPessoa extends JFrame{
    private JButton voltarButton;
    private JButton cadastrarButton;
    private JPanel cadastroPessoa;
    private JTextField sobrenomeInput;
    private JTextField emailInput;
    private JPasswordField senhaInput;
    private JPasswordField confirmaSenhaInput;
    private JTextField nomeInput;
    private JTextField cpfInput;
    private JComboBox generoInput;

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
                PessoaController controller = new PessoaController();

                controller.cadastrar(nomeInput.getText(), sobrenomeInput.getText(), emailInput.getText(), generoInput.getSelectedItem(), senhaInput.getText(), cpfInput.getText());
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
            }
        });
    }

    public void criarComponentes() {
        generoInput.setModel(new DefaultComboBoxModel(Genero.values()));
        setContentPane(cadastroPessoa);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
