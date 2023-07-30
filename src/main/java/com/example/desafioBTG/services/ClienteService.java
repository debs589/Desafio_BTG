package com.example.desafioBTG.services;

import com.example.desafioBTG.models.Cliente;
import com.example.desafioBTG.models.Conta;
import com.example.desafioBTG.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public Optional<Cliente> listarClienteId(String cpf){
        return clienteRepository.findById(cpf);
    }

}
