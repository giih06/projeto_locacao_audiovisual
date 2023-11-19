package com.springcloudsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcloudsql.model.Reserva;

// Função de instanciar um obj repository que terão varias operações para trabalhar com a reserva
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}