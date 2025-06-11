package br.com.fiap.appativa.Controller;

import br.com.fiap.appativa.DTO.ColaboradorRequestDTO;
import br.com.fiap.appativa.DTO.ColaboradorResponseDTO;
import br.com.fiap.appativa.ENUM.Risco;
import br.com.fiap.appativa.Model.ColaboradorModel;
import br.com.fiap.appativa.Service.ColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService service;

    // GET com filtros
    @GetMapping()
    public ResponseEntity<List<ColaboradorResponseDTO>> listarColaboradoresRegistrados(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "senha", required = false) String senha,
            @RequestParam(name = "riscoEmocional", required = false) Risco riscoEmocional,
            @RequestParam(name = "dataNascimento", required = false) LocalDate dataNascimento
    ) {
        var colaborador = ColaboradorModel.builder()
                .nome(nome)
                .email(email)
                .senha(senha)
                .riscoEmocional(riscoEmocional)
                .dataNascimento(dataNascimento)
                .build();

        var matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<ColaboradorModel> exemplo = Example.of(colaborador, matcher);

        List<ColaboradorModel> usuarios = service.findAll(exemplo);
        List<ColaboradorResponseDTO> response = usuarios.stream()
                .map(ColaboradorModel::toDTO)
                .toList();

        return ResponseEntity.ok(response);
    }

    // POST de um único colaborador
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ColaboradorResponseDTO> salvar(@Valid @RequestBody ColaboradorRequestDTO p) {
        var entity = service.toEntity(p);
        var salvo = service.salvar(entity);
        return ResponseEntity.ok(salvo.toDTO());
    }

    // POST de múltiplos colaboradores
    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<ColaboradorResponseDTO>> salvarEmLote(
            @Valid @RequestBody List<ColaboradorRequestDTO> colaboradores) {

        List<ColaboradorResponseDTO> salvos = colaboradores.stream()
                .map(service::toEntity)
                .map(service::salvar)
                .map(ColaboradorModel::toDTO)
                .toList();

        return ResponseEntity.ok(salvos);
    }

    // GET por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ColaboradorResponseDTO> buscaPorId(@PathVariable Long id) {
        var entity = service.findById(id);
        return ResponseEntity.ok(entity.toDTO());
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarColaborador(@PathVariable Long id) {
        service.excluir(id);
    }

    // PUT (atualizar)
    @PutMapping("/{id}")
    public ResponseEntity<ColaboradorResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ColaboradorRequestDTO p) {

        var entity = service.toEntity(p);
        entity.setId(id); // Define o ID vindo da URL antes de atualizar

        var atualizado = service.atualizar(entity);

        return ResponseEntity.ok(atualizado.toDTO());
    }
}

