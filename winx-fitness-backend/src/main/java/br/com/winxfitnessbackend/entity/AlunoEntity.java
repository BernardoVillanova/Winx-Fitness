package br.com.winxfitnessbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "aluno")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String senha;

    @Column
    private String email;

    @Column
    private Long telefone;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column
    private Float peso;

    @Column
    private Float altura;

    @Column
    private String objetivo;

    @Column(name = "nivel_fumante")
    private Integer fumante;

    @Column(name = "nivel_sedentario")
    private Integer sedentario;

    @ManyToOne
    @JoinColumn(name = "id_personal")
    private PersonalEntity personal;

}
