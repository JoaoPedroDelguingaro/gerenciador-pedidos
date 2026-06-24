package com.jptech.gerenciador_pedidos.principal;

import com.jptech.gerenciador_pedidos.model.Categoria;
import com.jptech.gerenciador_pedidos.model.Fornecedor;
import com.jptech.gerenciador_pedidos.model.Pedido;
import com.jptech.gerenciador_pedidos.model.Produto;
import com.jptech.gerenciador_pedidos.repository.CategoriaRepository;
import com.jptech.gerenciador_pedidos.repository.FornecedorRepository;
import com.jptech.gerenciador_pedidos.repository.PedidoRepository;
import com.jptech.gerenciador_pedidos.repository.ProdutoRepository;

import java.time.LocalDate;
import java.util.List;

public class Principal {

    private PedidoRepository repositoryPedido;

    private ProdutoRepository repositoryProduto;

    private CategoriaRepository repositoryCategoria;

    private FornecedorRepository repositoryFornecedor;

    public Principal(PedidoRepository repPedido, ProdutoRepository repProduto, CategoriaRepository repCategoria, FornecedorRepository repFornecedor) {
        this.repositoryPedido = repPedido;
        this.repositoryProduto = repProduto;
        this.repositoryCategoria = repCategoria;
        this.repositoryFornecedor = repFornecedor;
    }

    public void run(){
       Categoria moveis = new Categoria("Móveis");
       Categoria eletronicos = new Categoria("Eletronicos");
       repositoryCategoria.saveAll(List.of(moveis,eletronicos));

       Fornecedor distribuiMoveis = new Fornecedor("Móveis do Tião");
       Fornecedor distribuiEletronicos = new Fornecedor("Jptech");
       repositoryFornecedor.saveAll(List.of(distribuiEletronicos,distribuiMoveis));


       Produto p1 = new Produto("mesa", 199.99, moveis);
       Produto p2 = new Produto("radio", 1909.99, eletronicos);
       Produto p3 = new Produto("estante", 256.52, moveis);
       Produto p4 = new Produto("celular", 7500.0, eletronicos);

       p1.setFornecedor(distribuiMoveis);
       p2.setFornecedor(distribuiEletronicos);
       p3.setFornecedor(distribuiMoveis);
       p4.setFornecedor(distribuiEletronicos);
       repositoryProduto.saveAll(List.of(p1, p2, p3, p4));

       Pedido pedido1 = new Pedido(LocalDate.now());
       pedido1.setProdutos(List.of(p1, p4));
       Pedido pedido2 = new Pedido(LocalDate.now().plusDays(10));
       pedido2.setProdutos(List.of(p2, p3));
       repositoryPedido.saveAll(List.of(pedido1, pedido2));


        System.out.println("Todos os produtos eletronicos");
        repositoryCategoria.findAll().stream()
                .filter(c -> c.getNome().toLowerCase().contains("eletronicos"))
                .findFirst()
                .ifPresent(c -> c.getProdutos()
                        .forEach(p -> System.out.println("- Produto: " + p.getNome()))
                );

        System.out.println("\nPedidos e seus produtos:");
        repositoryPedido.findAll().forEach(p ->{
            System.out.println("Pedido " + p.getId() + ": ");
            p.getProdutos().forEach(prod->
                    System.out.println("- " + prod.getNome())
            );
        });

        System.out.println("Produtos e seus Fornecedores");
        repositoryProduto.findAll()
                .forEach(p-> System.out.println("Produto: " + p.getNome()
                        + " Fornecidos por "+ p.getFornecedor().getNome())
                );

    }
}

