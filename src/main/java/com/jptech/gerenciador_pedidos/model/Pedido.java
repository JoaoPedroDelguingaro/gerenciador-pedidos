package com.jptech.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private LocalDate data;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;

    public Pedido(){}

    public Pedido(LocalDate data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}

