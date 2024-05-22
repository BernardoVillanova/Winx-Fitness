package br.com.winxfitnessbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "personal")
public class PersonalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String senha;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column
    private String email;

    @Column
    private Long telefone;

    @Column
    private String endereco;

    @Column
    private String cidade;

    @Column
    private String estado;

    @Column
    private Long cep;

    @Column
    private Integer especialidade;

    @Column(name = "valor_aula")
    private Float valorAula;

}
