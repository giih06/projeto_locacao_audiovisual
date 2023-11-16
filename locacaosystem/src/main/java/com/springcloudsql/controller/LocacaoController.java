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
import com.springcloudsql.model.Locacao;
import com.springcloudsql.repository.EquipamentoRepository;

@RestController
@RequestMapping({"/locacoes"})
public class LocacaoController {
    
    private EquipamentoRepository repository;

    LocacaoController(EquipamentoRepository equipamentoRepository) {
        this.repository = equipamentoRepository;
    }

    // (select * from locacao)
    @GetMapping
    public List<Equipamento> findAll() {
        return repository.findAll();
    }

    // (select * from locacao where id = ?)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Locacao> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }
    
    // cria uma nova locacao
    @PostMapping
    public Equipamento create(@RequestBody Equipamento equipamento) {
        return repository.save(equipamento);
    }

    // update por id
    @PutMapping(value="/{id}")
    public ResponseEntity<Locacao> update(@PathVariable("id") long id, @RequestBody Equipamento equipamento) {
        return repository.findById(id)
        .map(record -> {
            record.setNome(equipamento.getNome());
            record.setDescricao(equipamento.getDescricao());
            record.setPrecoDiario(equipamento.getPrecoDiario());
            record.setDisponivel(equipamento.isDisponivel());
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

