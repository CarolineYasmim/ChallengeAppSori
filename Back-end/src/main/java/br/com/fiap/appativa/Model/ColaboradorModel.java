package br.com.fiap.appativa.Model;

import br.com.fiap.appativa.DTO.ColaboradorResponseDTO;
import br.com.fiap.appativa.ENUM.Risco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TBL_COLABORADOR")
public class ColaboradorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLABORADORES_SEQ")
    @SequenceGenerator(name = "COLABORADORES_SEQ", sequenceName = "COLABORADORES_SEQ", allocationSize = 1)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @Column(name = "risco_emocional", nullable = false)
    private Risco riscoEmocional;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    public ColaboradorResponseDTO toDTO() {
        return ColaboradorResponseDTO.builder()
                .id(id)
                .riscoEmocional(riscoEmocional)
                .build();

    }

}
