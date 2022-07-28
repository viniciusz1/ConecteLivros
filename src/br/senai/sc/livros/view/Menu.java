package br.senai.sc.livros.view;

import br.senai.sc.livros.model.entities.Pessoa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JButton cadastrarLivrosButton;
    private JButton SAIRButton;
    private JPanel menu;

    public Menu(Pessoa usuario){
        criarComponentes();
        cadastrarLivrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroLivro cadastroLivro = new CadastroLivro(usuario);
            }
        });
    }

    public void criarComponentes(){
        setContentPane(menu);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
