package com.example.desafioBTG.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Transacao {


    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "numero_conta")
    private Conta conta;
    private BigDecimal valor;

    public Transacao(Long id, Conta conta, BigDecimal valor) {
        this.id = id;
        this.conta = conta;
        this.valor = valor;
    }

    public Transacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
