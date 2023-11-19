package com.springcloudsql.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Serializeble trabnsforma os objetos em cadeias de bites para que o obj trafegue na rede, possa ser gravado em arquivos, etc
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cliente implements Serializable{
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    // associações

    // associação com o a locação  
    @OneToMany(mappedBy = "cliente")
    private List<Locacao> locacoes;

    // associação com usuário
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // associação com o endereço
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
