package br.com.fiap.appativa.DTO;

import br.com.fiap.appativa.ENUM.Risco;

import java.time.LocalDate;

public record ColaboradorRequestDTO(
        String nome,
        String email,
        String senha,
        LocalDate dataNascimento,
        Risco riscoEmocional
) {
}
