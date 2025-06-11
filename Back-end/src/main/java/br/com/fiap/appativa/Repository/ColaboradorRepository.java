package br.com.fiap.appativa.Repository;

import br.com.fiap.appativa.Model.ColaboradorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorModel, Long> {

}
