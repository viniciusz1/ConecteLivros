package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.Autor;
import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Pessoa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Estante extends JFrame {
    private JPanel estante;
    private JTable tabelaLivros;
    private JButton voltarButton;
    private JButton editarButton;
    private static int lista;

    public Estante(int botao) {
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
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa usuario = Menu.getUsuario();
                if(usuario instanceof Autor){
                    tabelaLivros.get
                }
            }
        });
    }

    private void criarComponentes() {
        LivrosController livrosController = new LivrosController();
        tabelaLivros.setModel(new DefaultTableModelArrayList(livrosController.selecionarLista(lista)));
        if (lista == 1) {
            editarButton.setVisible(false);
        } else {
            String isbn = (String) tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0);
            livrosController.editarLivro(isbn);
        }
        tabelaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setContentPane(estante);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
