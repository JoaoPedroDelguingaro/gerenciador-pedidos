package com.jptech.gerenciador_pedidos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private LocalDate data;

    public Pedido(LocalDate data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }
}

