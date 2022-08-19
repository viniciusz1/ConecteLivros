package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.Autor;
import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Livro;
import br.senai.sc.livros.model.entities.Pessoa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Estante extends JFrame {
    private JPanel estante;
    private JTable tabelaLivros;
    private JButton voltarButton;
    private JButton editarButton;
    private static int opcao;

    public Estante(int botao) {
        opcao = botao;
        criarComponentes();
// 1- listar livros
// 2 - listar atividades

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
                LivrosController livrosController = new LivrosController();
                ArrayList<Livro> livros = livrosController.selecionarLista(opcao);
                int isbn = (int) tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0);

                if (tabelaLivros.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um livro para editar!");
                } else {
                    for (Livro livro : livros) {
                        if (livro.getISBN() == isbn) {
                            dispose();
                            CadastroLivro cadastroLivro = new CadastroLivro(Menu.getUsuario(), livro);
                            cadastroLivro.setVisible(true);
                        }
                    }

                }

            }
        });
    }

    private void criarComponentes() {
        LivrosController livrosController = new LivrosController();
        tabelaLivros.setModel(new DefaultTableModelArrayList(livrosController.selecionarLista(opcao)));
        if (opcao == 1) {
            editarButton.setText("Começar edição");
        }else if (opcao == 2) {
            editarButton.setVisible(true);
        }

        tabelaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setContentPane(estante);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
