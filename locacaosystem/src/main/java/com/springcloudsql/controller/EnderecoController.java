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

import com.springcloudsql.model.Endereco;
import com.springcloudsql.repository.EnderecoRepository;

@RestController
@RequestMapping({"/enderecos"})
public class EnderecoController {
    
    private EnderecoRepository repository;

    EnderecoController(EnderecoRepository enderecoRepository) {
        this.repository = enderecoRepository;
    }

    // (select * from Endereco)
    @GetMapping
    public List<Endereco> findAll() {
        return repository.findAll();
    }

    // (select * from Endereco where id = ?)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Endereco> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }
    
    // cria um novo Endereco
    @PostMapping
    public Endereco create(@RequestBody Endereco endereco) {
        return repository.save(endereco);
    }

    // update por id
    @PutMapping(value="/{id}")
    public ResponseEntity<Endereco> update(@PathVariable("id") long id, @RequestBody Endereco endereco) {
        return repository.findById(id)
        .map(record -> {
            record.setRua(endereco.getRua());
            record.setNumero(endereco.getNumero());
            record.setCidade(endereco.getCidade());
            record.setCep(endereco.getCep());
            record.setComplemento(endereco.getComplemento());

            // Atualiza as associações com cliente
            record.setCliente(endereco.getCliente());

            Endereco updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // remove o Endereco por id
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
            .map(record -> {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}

