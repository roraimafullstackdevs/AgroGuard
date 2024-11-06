package com.agroguard.hackaton.model.enums;

public enum Status {
    LIVRE("Livre"),ATENCAO("Atenção"),ALERTA("Alerta");

    private final String descricao;

    // Construtor da enumeração
    Status(String descricao) {
        this.descricao = descricao;
    }

    // Método para obter a descrição do status
    public String getDescricao() {
        return descricao;
    }
}
