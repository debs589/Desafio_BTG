package com.example.desafioBTG.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Conta {

    @Id
    @GeneratedValue
    private Long numeroConta;

    @ManyToOne
    @JoinColumn(name = "cpf")
    private Cliente cliente;
    private String tipoConta;
    private BigDecimal saldo;

    public Conta(Long numeroConta, Cliente cliente, String tipoConta, BigDecimal saldo) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public Conta() {
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
