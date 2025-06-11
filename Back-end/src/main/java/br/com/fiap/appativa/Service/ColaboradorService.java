package br.com.fiap.appativa.Service;

import br.com.fiap.appativa.DTO.ColaboradorRequestDTO;
import br.com.fiap.appativa.Model.ColaboradorModel;
import br.com.fiap.appativa.Repository.ColaboradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repo;

    // Converte DTO em Entity
    public ColaboradorModel toEntity(ColaboradorRequestDTO user) {
        return ColaboradorModel.builder()
                .nome(user.nome())
                .email(user.email())
                .senha(user.senha())
                .riscoEmocional(user.riscoEmocional())
                .dataNascimento(user.dataNascimento())
                .build();
    }

    // Salva colaborador
    public ColaboradorModel salvar(ColaboradorModel p) {
        return repo.save(p);
    }


    public List<ColaboradorModel> findAll(Example example) {
        return repo.findAll(example);
    }

    public ColaboradorModel findById(Long id) {
        Optional<ColaboradorModel> ColaboradorModelOptional = repo.findById(id);

        if (ColaboradorModelOptional.isPresent()){
            return ColaboradorModelOptional.get();
        } else {
            throw new RuntimeException("Consulta não pode ser concluída: Pessoa não identificada");
        }
    }

    public void excluir(Long id) {
        Optional<ColaboradorModel> ColaboradorModelOptional = repo.findById(id);

        if (ColaboradorModelOptional.isPresent()){
            repo.delete(ColaboradorModelOptional.get());
        } else {
            throw new RuntimeException("Delete não pode ser concluído: Pessoa não identificada");
        }
    }

    public ColaboradorModel atualizar(ColaboradorModel p){
        Optional<ColaboradorModel> ColaboradorModelOptional = repo.findById(p.getId());

        if(ColaboradorModelOptional.isPresent()){
            return repo.save(p);
        } else {
            throw new RuntimeException("Atualização não pode ser concluída: Pessoa não identificada");
        }
    }

}

