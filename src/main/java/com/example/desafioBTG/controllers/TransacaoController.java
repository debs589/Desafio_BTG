package com.example.desafioBTG.controllers;

import com.example.desafioBTG.models.Transacao;
import com.example.desafioBTG.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping("/transacao")
    public List<Transacao> listarTransacaos(){
        return transacaoService.listarTransacoes();
    }
    @PostMapping("/transacao")
    public Transacao criarTransacao(@RequestBody Transacao transacao){
        return transacaoService.criarTransacao(transacao);
    }
    @PutMapping("/transacao")
    public Transacao atualizarTransacao(@RequestBody Transacao transacao) {
        return transacaoService.criarTransacao(transacao);
    }
}
