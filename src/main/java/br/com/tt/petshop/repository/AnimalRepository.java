package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//Interface extends interface (contrato)
//Classe implements interface
//Classe extends outraClasse
@Repository
public interface AnimalRepository extends
        CrudRepository<Animal, Long> {
//        , JpaRepository<Animal, Long>,
//        PagingAndSortingRepository<Animal, Long>

    List<Animal> findByNomeAndDataNascimentoOrderByNome(String nome, LocalDate dataNascimento);

    List<Animal> findByNomeAndDataNascimentoIsNotNull(String nome);

    List<Animal> findByNomeAndDataNascimentoBetween(String nome,
                                                    LocalDate dataNascimentoInicio,
                                                    LocalDate dataNascimentoFim);

    //Query Methods
    Optional<Animal> findByNomeAndCliente(String nome, Cliente cliente);

    //Query JPQL
    @Query("select a from Animal a where a.dataNascimento = :dataNascimento")
    List<Animal> buscarPorDataDeNascimento(@Param("dataNascimento") LocalDate dataNascimento);

    @Query("select a from Animal a join a.cliente c where c.cpf = :cpf ")
    List<Animal> buscaAnimaisDoClientePorCpf(@Param("cpf") String cpf);

    @Query("select a from Animal a join a.cliente c where c.id = :id ")
    List<Animal> buscaAnimaisDoClientePorId(@Param("id") Integer id);

    //Native query?
    @Query(value = "select A.NOME FROM TB_ANIMAL A order limit 1 by A.ID desc", nativeQuery = true)
    String buscarUltimoNomeAnimalCadastrado();
}
