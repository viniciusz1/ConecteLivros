package Testes;

import br.senai.sc.livros.model.dao.Conexao;
import br.senai.sc.livros.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) throws SQLException {
        Editora editora = new Editora("vinicius", "1234567890");
        String query = "insert into editoras(nomeEditora,cnpjEditora)values(?,?)";

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,editora.getNome());
        statement.setString(2,editora.getCNPJ());
        statement.execute();
        connection.close();
    }
}
