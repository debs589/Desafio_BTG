package com.example.desafioBTG.controllers;

import com.example.desafioBTG.models.Conta;
import com.example.desafioBTG.models.Conta;
import com.example.desafioBTG.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping("/conta")
    public List<Conta> listarContas(){
        return contaService.listarContas();
    }
    @PostMapping("/conta")
    public Conta criarConta(@RequestBody Conta conta){
        return contaService.criarConta(conta);
    }
    @PutMapping("/conta")
    public Conta atualizarConta(@RequestBody Conta conta) {
        return contaService.criarConta(conta);
    }
}
