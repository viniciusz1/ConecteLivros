package Testes.Statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsert {

    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato("Vyton","k43ru@terra.com.jp","004400-0000",18);
        String query = "insert into contatos(nome, email, telefone, idade) " +
                "values('"+contato.nome+"','"+contato.email+"','"+contato.telefone+"', '"+contato.idade+"')";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();
        Statement statement = connection.createStatement();
        statement.execute(query);
        connection.close();
    }

}
