package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.Genero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Estante extends JFrame {
    private JPanel estante;
    private JTable tabelaLivros;
    private JButton voltarButton;
    private JButton editarButton;
    private static int lista;

    public Estante(int botao){
        lista = botao;
        criarComponentes();


        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu(Menu.getUsuario());
                menu.setVisible(true);
            }
        });
    }

    private void criarComponentes(){
        LivrosController livrosController = new LivrosController();

        tabelaLivros.setModel(new DefaultTableModelArrayList(livrosController.selecionarLista(lista)));
        tabelaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setContentPane(estante);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
