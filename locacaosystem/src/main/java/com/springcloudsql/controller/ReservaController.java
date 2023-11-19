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

import com.springcloudsql.model.Reserva;
import com.springcloudsql.repository.ReservaRepository;

@RestController
@RequestMapping({"/reservas"})
public class ReservaController {
    
    private ReservaRepository repository;

    ReservaController(ReservaRepository reservaRepository) {
        this.repository = reservaRepository;
    }

    // (select * from Reserva)
    @GetMapping
    public List<Reserva> findAll() {
        return repository.findAll();
    }

    // (select * from Reserva where id = ?)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Reserva> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }
    
    // cria uma nova Reserva
    @PostMapping
    public Reserva create(@RequestBody Reserva reserva) {
        return repository.save(reserva);
    }

    // update por id
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable("id") Long id, @RequestBody Reserva reserva) {
        return repository.findById(id)
                .map(record -> {
                    // atualiza os atributos
                    record.setData_inicio(reserva.getData_inicio());
                    record.setData_fim(reserva.getData_fim());
                    record.setStatus(reserva.getStatus());
                    
                    // Atualiza as associações com Cliente e Equipamento
                    record.setCliente(reserva.getCliente());
                    record.setEquipamento(reserva.getEquipamento());

                    Reserva updated = repository.save(reserva);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // remove a Reserva por id
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
            .map(record -> {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}

