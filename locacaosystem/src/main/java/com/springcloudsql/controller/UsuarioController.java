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

import com.springcloudsql.model.Usuario;
import com.springcloudsql.repository.UsuarioRepository;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
    
    private UsuarioRepository repository;

    UsuarioController(UsuarioRepository UsuarioRepository) {
        this.repository = UsuarioRepository;
    }

    // (select * from Usuario)
    @GetMapping
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    // (select * from Usuario where id = ?)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Usuario> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }
    
    // cria uma nova Usuario
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    // update por id
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return repository.findById(id)
                .map(record -> {
                    // atualiza os atributos
                    record.setNome(usuario.getNome());
                    record.setEmail(usuario.getEmail());
                    record.setSenha(usuario.getSenha());

                    // Atualiza as associações com Cliente 
                    record.setCliente(usuario.getCliente());

                    Usuario updated = repository.save(usuario);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // remove a usuario por id
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
            .map(record -> {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}

