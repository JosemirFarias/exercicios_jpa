package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
    public static void main(String[] args) {

        Produto produto = new Produto(60.98, "Mouse");

        DAO<Produto> dao = new DAO<>(Produto.class);
        dao.incluirMultiplos(produto).fechar();

        System.out.println("ID do produto: " + produto.getId());
    }
}
