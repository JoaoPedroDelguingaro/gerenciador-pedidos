package com.jptech.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(name = "valor")
    private Double preco;

    @ManyToOne
    private Categoria categoria;

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public Produto(){}

    public Produto(String nome, Double preco, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

     public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}

