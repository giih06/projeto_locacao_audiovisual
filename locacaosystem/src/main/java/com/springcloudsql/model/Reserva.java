package com.springcloudsql.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Serializeble trabnsforma os objetos em cadeias de bites para que o obj trafegue na rede, possa ser gravado em arquivos, etc
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="reservas")
public class Reserva implements Serializable{
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data_inicio;
    private LocalDate data_fim;
    private String status;

    // associações
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = false)
    private Equipamento equipamento;


    
}