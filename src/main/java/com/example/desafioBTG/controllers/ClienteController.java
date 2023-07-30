package com.example.desafioBTG.controllers;

import com.example.desafioBTG.models.Cliente;
import com.example.desafioBTG.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente")
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }
    @PostMapping("/cliente")
    public Cliente criarCliente(@RequestBody Cliente cliente){
        return clienteService.criarCliente(cliente);
    }




}
