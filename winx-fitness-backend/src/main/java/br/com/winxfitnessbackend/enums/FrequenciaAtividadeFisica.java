package br.com.winxfitnessbackend.enums;

import java.util.Arrays;

public enum FrequenciaAtividadeFisica {
    SEDENTARIO(1, "SEDENTARIO"),
    MODERADO(2, "MODERADO"),
    INTENSO(3, "INTENSO");

    int id;
    String descricao;

    FrequenciaAtividadeFisica(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static FrequenciaAtividadeFisica getEnumById(int id) {
        for (FrequenciaAtividadeFisica frequenciaAtividadeFisica : values()) {
            if (frequenciaAtividadeFisica.id == id) {
                return frequenciaAtividadeFisica;
            }
        }

        return null;
    }

    public static String getDescricaoById(int id) {
        for (FrequenciaAtividadeFisica frequenciaAtividadeFisica : values()) {
            if (frequenciaAtividadeFisica.id == id) {
                return frequenciaAtividadeFisica.descricao;
            }
        }

        return "";
    }
}
