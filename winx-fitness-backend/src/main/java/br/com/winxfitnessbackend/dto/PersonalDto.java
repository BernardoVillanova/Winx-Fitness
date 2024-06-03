package br.com.winxfitnessbackend.dto;

import java.math.BigDecimal;

public record PersonalDto(
        String nome,
        String especialidade,
        BigDecimal valorAula
){}