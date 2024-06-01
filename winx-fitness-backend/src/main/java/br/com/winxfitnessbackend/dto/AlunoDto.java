package br.com.winxfitnessbackend.dto;

import br.com.winxfitnessbackend.enums.FrequenciaAtividadeFisica;

import java.math.BigDecimal;

public record AlunoDto (
        String nome,
        String email,
        BigDecimal peso,
        BigDecimal altura,
        FrequenciaAtividadeFisica frequenciaAtividadeFisica
){}