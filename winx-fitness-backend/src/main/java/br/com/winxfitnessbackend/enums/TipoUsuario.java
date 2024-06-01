package br.com.winxfitnessbackend.enums;

import lombok.Getter;

public enum TipoUsuario {

    ALUNO(1, "Aluno"),
    PERSONAL(2, "Personal/Nutricionista");

    @Getter
    int id;

    @Getter
    String descricao;

    TipoUsuario(final int id, final String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

}
