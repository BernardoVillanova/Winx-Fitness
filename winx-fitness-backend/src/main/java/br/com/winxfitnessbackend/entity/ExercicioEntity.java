package br.com.winxfitnessbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "exercicio")
public class ExercicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_exercicio")
    private String nomeExercicio;

    @Column
    private String descricao;

    @Column
    private String image;
}
