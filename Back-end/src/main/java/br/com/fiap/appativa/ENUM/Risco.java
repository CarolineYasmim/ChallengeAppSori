package br.com.fiap.appativa.ENUM;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Risco {
    NEUTRO(1L, "NEUTRO"),
    LEVE(2L, "LEVE"),
    MODERADO(3L, "MODERADO"),
    AGUDO(4L, "AGUDO");

    private Long id;
    private String nomeRisco;

}
