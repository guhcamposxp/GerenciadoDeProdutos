package br.senac.tads.Servicos;

import br.senac.tads.gerenciador.dao.daoProduto;
import br.senac.tads.gerenciador.produto.Produto;
import java.util.List;

public class ServicoGerenciador {
    public static void addProduto(Produto produto) throws Exception {        
        daoProduto.inserir(produto);
    }

    public static List<Produto> listar() throws Exception {
     return daoProduto.listar();
    }
}
