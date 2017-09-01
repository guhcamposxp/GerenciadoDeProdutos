package br.senac.tads.gerenciador.dao;

import br.senac.tads.gerenciador.exceptions.ProdutoException;
import br.senac.tads.gerenciador.utils.ConnectionUtils;
import br.senac.tads.gerenciador.produto.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class daoProduto {
    private static void executarSQL(String sql) throws
            ProdutoException, SQLException, Exception {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            statement.execute(sql);
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public static void inserir(Produto produto)
            throws SQLException, Exception {
        String sql = "INSERT INTO PRODUTO (NOME, "
                + "DESCRICAO, VLRCOMPRA, VLRVENDA, CATEGORIAS, ENABLED) VALUES ("
                + "'" + produto.getNome() + "', "
                + "'" + produto.getDescricao()+ "', "
                + "'" + produto.getValorCompra()+ "', "
                + "'" + produto.getValorVenda()+ "', "
                + "'" + produto.getCategorias()+ "', "
                + "true"
                + ")";
        executarSQL(sql);
    }
    
    public static java.util.List<Produto> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM PRODUTO WHERE enabled=true";

        return executarConsulta(sql);
    }
    
    public static List<Produto> executarConsulta(String sql) throws
            ProdutoException, SQLException, Exception {
       List<Produto> listaProdutos = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<>();
                }
                Produto produto = new Produto();
                produto.setNome(result.getString("NOME"));
                produto.setDescricao(result.getString("DESCRICAO"));
                produto.setValorCompra(result.getString("VLRCOMPRA"));
                produto.setValorVenda(result.getString("VLRVENDA"));
                produto.setCategorias(result.getString("CATEGORIAS"));                                
                listaProdutos.add(produto);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaProdutos;
    }
}
