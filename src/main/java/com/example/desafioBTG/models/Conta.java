package com.example.desafioBTG.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Conta {

    @Id
    @GeneratedValue
    private Long numeroConta;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "cpf",nullable = false)
    private Cliente cliente;
    private String tipoConta;
    private BigDecimal saldo;

    @OneToMany(mappedBy = "conta")
    @JsonManagedReference
    private List<Transacao> listaTransacoesConta;

    public Conta(Long numeroConta, Cliente cliente, String tipoConta, BigDecimal saldo, List<Transacao> listaTransacoesConta) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.listaTransacoesConta = listaTransacoesConta;
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

    public List<Transacao> getListaTransacoesConta() {
        return listaTransacoesConta;
    }

    public void setListaTransacoesConta(List<Transacao> listaTransacoesConta) {
        this.listaTransacoesConta = listaTransacoesConta;
    }
}
