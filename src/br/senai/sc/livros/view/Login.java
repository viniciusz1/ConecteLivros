package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.PessoaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements Runnable{

    PessoaController pessoaController = new PessoaController();

    private JTextField emailInput;
    private JPasswordField passwordInput;
    private JButton CADASTRARSEButton;
    private JButton logarButton;
    private JPanel login;

    public Login(){
        criarComponentes();
        logarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pessoaController.validaLogin(emailInput.getText(), passwordInput.getText())){
//                    dispose();
                    new Menu();
                }
            }
        });
        CADASTRARSEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
                new CadastroPessoa();
            }
        });
    }

    private void criarComponentes(){
        setContentPane(login);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }

    @Override
    public void run() {
        if(!isVisible()){
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "A janela ja está aberta!");
        }
    }

    public static void main(String[] args) {
        Login programa = new Login();
        programa.run();
    }

}
