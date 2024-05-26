package br.com.winxfitnessbackend.dto;

import br.com.winxfitnessbackend.enums.TipoUsuario;

public record LoginDto(
        String usuario,
        String senha,
        TipoUsuario tipoUsuario
) {
}
