package com.springcloudsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcloudsql.model.Cliente;

// Função de instanciar um obj repository que terão varias operações para trabalhar com o user
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
