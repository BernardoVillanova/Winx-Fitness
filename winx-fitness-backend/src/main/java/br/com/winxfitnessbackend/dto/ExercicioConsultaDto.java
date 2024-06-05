package br.com.winxfitnessbackend.dto;

public record ExercicioConsultaDto(
        Long id,
        String nome,
        String descricao,
        String image
) {
}
