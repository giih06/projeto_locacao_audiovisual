package com.springcloudsql.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Serializeble trabnsforma os objetos em cadeias de bites para que o obj trafegue na rede, possa ser gravado em arquivos, etc
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Locacao implements Serializable{
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data_locacao;
    private LocalDate data_devolucao_prevista;
    private Double valorTotal;

    // associações

    // associação com Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // associaçao com Equipamentos
    @ManyToMany
    @JoinTable(name = "locacao_equipamento",
            joinColumns = @JoinColumn(name = "locacao_id"),
            inverseJoinColumns = @JoinColumn(name = "equipamento_id"))
    private List<Equipamento> equipamentos;


}
