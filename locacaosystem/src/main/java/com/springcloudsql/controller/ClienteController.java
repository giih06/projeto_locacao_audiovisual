package com.springcloudsql.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloudsql.model.Cliente;
import com.springcloudsql.repository.ClienteRepository;

@RestController
@RequestMapping({"/clientes"})
public class ClienteController {
    
    private ClienteRepository repository;

    ClienteController(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }

    // (select * from cliente)
    @GetMapping
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    // (select * from cliente where id = ?)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Cliente> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }
    
    // cria um novo cliente
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    // update por id
    @PutMapping(value="/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") long id, @RequestBody Cliente cliente) {
        return repository.findById(id)
        .map(record -> {
            record.setNome(cliente.getNome());
            record.setEmail(cliente.getEmail());
            record.setTelefone(cliente.getTelefone());

            // Atualiza as associações com Locações e endereço
            record.setLocacoes(cliente.getLocacoes());
            record.setUsuario(cliente.getUsuario());
            record.setEndereco(cliente.getEndereco());

            Cliente updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // remove o cliente por id
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
            .map(record -> {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
