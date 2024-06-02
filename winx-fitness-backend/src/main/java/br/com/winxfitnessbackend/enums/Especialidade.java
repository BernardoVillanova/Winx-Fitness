package br.com.winxfitnessbackend.enums;

public enum Especialidade {
    PERSONAL(1, "Personal"),
    NUTRICIONISTA(2, "Nutricionista"),
    AMBOS(3, "Personal e Nutricionista");

    int id;
    String descricao;

    Especialidade(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static String getDecricaoByID(int id) {
        for (Especialidade especialidade : Especialidade.values()) {
            if (especialidade.id == id) {
                return especialidade.descricao;
            }
        }

        return "";
    }
}
