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

import com.springcloudsql.model.Equipamento;
import com.springcloudsql.repository.EquipamentoRepository;

@RestController
@RequestMapping({"/equipamentos"})
public class EquipamentoController {
    
    private EquipamentoRepository repository;

    EquipamentoController(EquipamentoRepository equipamentoRepository) {
        this.repository = equipamentoRepository;
    }

    // (select * from equipamento)
    @GetMapping
    public List<Equipamento> findAll() {
        return repository.findAll();
    }

    // (select * from equipamento where id = ?)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Equipamento> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }
    
    // cria um novo equipamento
    @PostMapping
    public Equipamento create(@RequestBody Equipamento equipamento) {
        return repository.save(equipamento);
    }

    // update por id
    @PutMapping(value="/{id}")
    public ResponseEntity<Equipamento> update(@PathVariable("id") long id, @RequestBody Equipamento equipamento) {
        return repository.findById(id)
        .map(record -> {
            record.setNome(equipamento.getNome());
            record.setDescricao(equipamento.getDescricao());
            record.setPrecoDiario(equipamento.getPrecoDiario());
            record.setDisponivel(equipamento.isDisponivel());

            // Atualiza as associações com Locações
            record.setReseras(equipamento.getReseras());

            Equipamento updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // remove o equipamento por id
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
            .map(record -> {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}

