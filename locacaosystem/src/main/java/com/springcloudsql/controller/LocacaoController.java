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

import com.springcloudsql.model.Locacao;
import com.springcloudsql.repository.LocacaoRepository;

@RestController
@RequestMapping({"/locacoes"})
public class LocacaoController {
    
    private LocacaoRepository repository;

    LocacaoController(LocacaoRepository locacaoRepository) {
        this.repository = locacaoRepository;
    }

    // (select * from locacao)
    @GetMapping
    public List<Locacao> findAll() {
        return repository.findAll();
    }

    // (select * from locacao where id = ?)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Locacao> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }
    
    // cria uma nova locacao
    @PostMapping
    public Locacao create(@RequestBody Locacao locacao) {
        return repository.save(locacao);
    }

    // update por id
    @PutMapping(value="/{id}")
    public ResponseEntity<Locacao> update(@PathVariable("id") long id, @RequestBody Locacao locacao) {
        return repository.findById(id)
        .map(record -> {
            record.setData_locacao(locacao.getData_locacao());
            record.setData_devolucao_prevista(locacao.getData_devolucao_prevista());
            record.setValorTotal(locacao.getValorTotal());
            Locacao updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // remove a locacao por id
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
            .map(record -> {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}

