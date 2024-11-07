package com.agroguard.hackaton.model.enums;

public enum Status {
    LIVRE("Livre"),ATENCAO("Atenção"),ALERTA("Alerta"),EM_PROCESSAMENTO("Em Processamento");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
