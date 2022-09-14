package Testes.PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaInsert {

    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato("Vyton","k43ru@terra.com.jp","004400-0000",18);
        String query = "insert into contatos(nome, email, telefone, idade)values(?,?,?,?)";

        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,contato.getNome());
        statement.setString(2,contato.getEmail());
        statement.setString(3,contato.getTelefone());
        statement.setInt(4,contato.getIdade());
        statement.execute();
        connection.close();
    }

}
