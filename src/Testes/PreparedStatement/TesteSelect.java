package Testes.PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteSelect {
    public static void main(String[] args) throws SQLException {
        select("2 or 2=2");
    }
    public static Contato select(Object id) throws SQLException {
        String sql = "select * from contatos where id = ?";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (Integer) id);
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
