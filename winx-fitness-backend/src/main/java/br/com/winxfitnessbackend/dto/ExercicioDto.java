package br.com.winxfitnessbackend.dto;

public record ExercicioDto(
        Long id,
        String nome,
        String descricao,
        String image
) {
}
