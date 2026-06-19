package com.jptech.gerenciador_pedidos.principal;

import com.jptech.gerenciador_pedidos.model.Categoria;
import com.jptech.gerenciador_pedidos.model.Pedido;
import com.jptech.gerenciador_pedidos.model.Produto;
import com.jptech.gerenciador_pedidos.repository.CategoriaRepository;
import com.jptech.gerenciador_pedidos.repository.PedidoRepository;
import com.jptech.gerenciador_pedidos.repository.ProdutoRepository;

import java.time.LocalDate;

public class Principal {

    private PedidoRepository repositoryPedido;

    private ProdutoRepository repositoryProduto;

    private CategoriaRepository repositoryCategoria;

    public Principal(PedidoRepository repositoryPedido, ProdutoRepository repositoryProduto, CategoriaRepository repositoryCategoria) {
        this.repositoryPedido = repositoryPedido;
        this.repositoryProduto = repositoryProduto;
        this.repositoryCategoria = repositoryCategoria;
    }

    public void run(){
        Produto produto = new Produto("Sabonete", 10.98);
        Categoria categoria = new Categoria("Higiene");
        Pedido pedido = new Pedido(LocalDate.of(2022,05,05));

        repositoryProduto.save(produto);
        repositoryCategoria.save(categoria);
        repositoryPedido.save(pedido);

    }
}

