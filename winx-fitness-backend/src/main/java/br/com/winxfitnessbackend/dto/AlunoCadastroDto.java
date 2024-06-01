package br.com.winxfitnessbackend.dto;

import br.com.winxfitnessbackend.enums.FrequenciaAtividadeFisica;

import java.math.BigDecimal;

public record AlunoCadastroDto(
        String nome,
        String email,
        String password,
        BigDecimal peso,
        BigDecimal altura,
        FrequenciaAtividadeFisica frequenciaAtividadeFisica
){}