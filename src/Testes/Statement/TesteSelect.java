package Testes.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteSelect {
    public static void main(String[] args) throws SQLException {
        select("2 or 2=2");
    }
    public static Contato select(Object id) throws SQLException {
        String sql = "select * from contatos where id = "+id;
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();
        Statement statement = connection.createStatement();
        ResultSet resultset =  statement.executeQuery(sql);
        Contato contato = null;
        if(resultset != null) {
            if (resultset.next()) {
                contato = new Contato(resultset.getInt("id"),
                        resultset.getString("nome"),
                        resultset.getString("email"),
                        resultset.getString("telefone"),
                        resultset.getInt("idade")
                );
                System.out.println(contato);
                return contato;
            }
        }
        throw new RuntimeException("Deu ruim!");

    }
}
