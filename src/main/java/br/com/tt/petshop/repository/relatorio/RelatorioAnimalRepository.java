package br.com.tt.petshop.repository.relatorio;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.projection.RelatorioAnimalProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatorioAnimalRepository
        extends JpaRepository<Animal, Long> {

    @Query(SQLs.JPQL_RELATORIO_ANIMAL)
    List<RelatorioAnimalProjection> listarAnimais();
}
