package br.com.winxfitnessbackend.enums;

import java.util.Arrays;

public enum FrequenciaAtividadeFisica {
    SEDENTARIO(0, "SEDENTARIO"),
    MODERADO(1, "MODERADO"),
    INTENSO(2, "INTENSO");

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

    public static int getIdByDescricao(String descricao) {
        for (FrequenciaAtividadeFisica frequenciaAtividadeFisica : values()) {
            if (frequenciaAtividadeFisica.descricao.equals(descricao)) {
                return frequenciaAtividadeFisica.id;
            }
        }

        return 0;
    }
}
