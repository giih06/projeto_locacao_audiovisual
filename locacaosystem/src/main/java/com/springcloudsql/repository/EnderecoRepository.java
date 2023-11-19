package com.springcloudsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcloudsql.model.Endereco;

// Função de instanciar um obj repository que terão varias operações para trabalhar com o equipamento
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}