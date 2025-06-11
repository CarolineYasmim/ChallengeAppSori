package br.com.fiap.appativa.DTO;

import br.com.fiap.appativa.ENUM.Risco;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ColaboradorResponseDTO(
        Long id,
        Risco riscoEmocional
) {
}
