package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.Genero;

import javax.swing.*;

public class Estante extends JFrame {
    private JPanel estante;
    private JTable tabelaLivros;
    private JButton Voltar;
    private JButton editarButton;

    public Estante(){
        criarComponentes();
    }

    private void criarComponentes(){
        LivrosController livrosController = new LivrosController();

        tabelaLivros.setModel(new DefaultTableModelArrayList(livrosController.getAllLivros()));
        tabelaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setContentPane(estante);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
