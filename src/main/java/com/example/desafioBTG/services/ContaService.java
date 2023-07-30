package com.example.desafioBTG.services;

import com.example.desafioBTG.models.Conta;
import com.example.desafioBTG.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }
    public Conta criarConta(Conta conta){
        return contaRepository.save(conta);
    }

}
