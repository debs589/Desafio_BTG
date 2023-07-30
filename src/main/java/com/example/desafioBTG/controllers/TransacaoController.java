package com.example.desafioBTG.controllers;

import com.example.desafioBTG.models.Conta;
import com.example.desafioBTG.models.Transacao;
import com.example.desafioBTG.services.ContaService;
import com.example.desafioBTG.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private ContaService contaService;

    @GetMapping("/transacao")
    public List<Transacao> listarTransacaos(){
        return transacaoService.listarTransacoes();
    }
    @PostMapping("/transacao")
    public Transacao criarTransacao(@RequestBody Transacao transacao){
        Transacao novaTransacao = transacaoService.criarTransacao(transacao);
        Conta conta = contaService.listarContaId(transacao.getConta().getNumeroConta()).get();
        BigDecimal saldoFinal =  conta.getSaldo().add(novaTransacao.getValor());
        conta.setSaldo(saldoFinal);
        contaService.criarConta(conta);
        return novaTransacao;
    }

}
