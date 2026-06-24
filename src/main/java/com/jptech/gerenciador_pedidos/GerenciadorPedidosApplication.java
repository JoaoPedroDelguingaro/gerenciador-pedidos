package com.jptech.gerenciador_pedidos;

import com.jptech.gerenciador_pedidos.principal.Principal;
import com.jptech.gerenciador_pedidos.repository.CategoriaRepository;
import com.jptech.gerenciador_pedidos.repository.FornecedorRepository;
import com.jptech.gerenciador_pedidos.repository.PedidoRepository;
import com.jptech.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository repositoryCategoria;

	@Autowired
	private ProdutoRepository repositoryProduto;

	@Autowired
	private PedidoRepository repositoryPedido;

	@Autowired
	private FornecedorRepository repositoryFornecedor;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal pr = new Principal(repositoryPedido, repositoryProduto, repositoryCategoria, repositoryFornecedor);
		pr.run();
	}
}
