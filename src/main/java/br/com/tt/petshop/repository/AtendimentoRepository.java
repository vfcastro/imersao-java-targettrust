package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends
        JpaRepository<Atendimento, Long>,
        PagingAndSortingRepository<Atendimento, Long> {
}
