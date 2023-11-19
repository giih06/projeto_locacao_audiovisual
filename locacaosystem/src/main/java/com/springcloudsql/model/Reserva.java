package com.springcloudsql.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Serializeble trabnsforma os objetos em cadeias de bites para que o obj trafegue na rede, possa ser gravado em arquivos, etc
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reserva implements Serializable{
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data_inicio;
    private LocalDate data_fim;
    private String status;

    // associações

    // associação com cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // associação com equipamento
    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    @PrePersist
    public void prePersist() {
        // Define o status_reserva padrão como 'pendente' antes da persistência
        if (this.status == null) {
            this.status = "pendente";
        }
    }
    
}