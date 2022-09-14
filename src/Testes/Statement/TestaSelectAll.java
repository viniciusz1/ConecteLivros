package Testes.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class TestaSelectAll {
    public static void main(String[] args) throws SQLException {
        Collection<Contato> contatoCollection = new ArrayList<>();
        String sql = "select * from contatos where id = 1 or 10*10=100";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();
        Statement statement = connection.createStatement();
        ResultSet resultset =  statement.executeQuery(sql);
      while (resultset != null && resultset.next()) {
            Contato contato = new Contato(resultset.getInt("id"),
                    resultset.getString("nome"),
                    resultset.getString("email"),
                    resultset.getString("telefone"),
                    resultset.getInt("idade")

            );
//            contatoCollection.add(contato);
        }
        System.out.println(contatoCollection);
    }
}
