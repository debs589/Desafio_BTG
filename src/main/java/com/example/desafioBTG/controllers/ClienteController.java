package com.example.desafioBTG.controllers;

import com.example.desafioBTG.models.Cliente;
import com.example.desafioBTG.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping("/cliente")
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }
    @PutMapping("/cliente")
    public Cliente atualizarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }
    @GetMapping("/cliente/{cpf}")
    public Optional<Cliente> listarClientes(@PathVariable("cpf") String cpf){
        return clienteService.listarClienteId(cpf);
    }

}





