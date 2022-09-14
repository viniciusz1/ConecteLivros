package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CadastroLivro extends JFrame{
    private JButton voltarButton;
    private JButton cadastrarButton;
    private JTextField tituloInput;
    private JTextField isbnInput;
    private JTextField qtdPagInput;
    private JPanel cadastroLivro;
    private JComboBox select;
    private JLabel labelTitulo;

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
                Boolean add = null;
                try {
                    add = controller.cadastrar(titulo, isbn, qtdPag, usuario);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println(add);
                if(add.equals(true)){
                    JOptionPane.showMessageDialog(null, "Livro g cadastrado com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Livro não cadastrado com sucesso!");
                }
                dispose();
                Menu menu = new Menu(usuario);
                menu.setVisible(true);
            }

        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu(Menu.getUsuario());
                menu.setVisible(true);
            }
        });
    }

    CadastroLivro(Pessoa usuario, Livro livro) {
        criarComponentes();
        tituloInput.setText(livro.getTitulo());
        isbnInput.setText(Integer.toString(livro.getISBN()));
        isbnInput.disable();
        qtdPagInput.setText(Integer.toString(livro.getQntdPaginas()));
        if(usuario instanceof Revisor){
            select.addItem(Status.EM_REVISAO);
            select.addItem(Status.APROVADO);
        }else if(usuario instanceof Diretor){
            select.addItem(Status.EM_REVISAO);
            select.addItem(Status.APROVADO);
            select.addItem(Status.REPROVADO);
            select.addItem(Status.AGUARDANDO_REVISAO);
            select.addItem(Status.AGUARDANDO_EDICAO);
            select.addItem(Status.PUBLICADO);
        }else if(usuario instanceof Autor){
            select.addItem(Status.AGUARDANDO_EDICAO);
            select.addItem(Status.AGUARDANDO_REVISAO);
        }

        cadastrarButton.setText("Editar");
        labelTitulo.setText("Edição de livros");

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
                livro.setTitulo(titulo);
                livro.setISBN(Integer.parseInt(isbn));
                livro.setQntdPaginas(Integer.parseInt(qtdPag));
                livro.setStatus((Status) select.getSelectedItem());
                controller.editarLivro(isbn, livro);
                JOptionPane.showMessageDialog(null, "Livro editado com sucesso!");
                dispose();
                Menu menu = new Menu(usuario);
                menu.setVisible(true);
            }

        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu(Menu.getUsuario());
                menu.setVisible(true);
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
