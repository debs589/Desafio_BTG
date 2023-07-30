package com.example.desafioBTG.services;

import com.example.desafioBTG.models.Transacao;
import com.example.desafioBTG.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> listarTransacoes() {
        return transacaoRepository.findAll();
    }
    public Transacao criarTransacao(Transacao transacao){
        return transacaoRepository.save(transacao);
    }
}
