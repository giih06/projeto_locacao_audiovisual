package com.springcloudsql.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Serializeble trabnsforma os objetos em cadeias de bites para que o obj trafegue na rede, possa ser gravado em arquivos, etc
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="enderecos")
public class Endereco implements Serializable{
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private int numero;
    private String cidade;
    private String cep;
    private String complemento;

    // associações
    @OneToMany(mappedBy = "endereco")
    private List<Cliente> clientes;

}