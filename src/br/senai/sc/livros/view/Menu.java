package br.senai.sc.livros.view;

import javax.swing.*;

public class Menu extends JFrame{
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton SAIRButton;
    private JPanel menu;

    public Menu(){
        criarComponentes();
    }

    public void criarComponentes(){
        setContentPane(menu);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
