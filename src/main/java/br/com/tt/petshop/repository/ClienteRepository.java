package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClienteRepository {

    private EntityManager em;

    public ClienteRepository(EntityManager em) {
        this.em = em;
    }

    public List<Cliente> listarClientes(){
        // HQL - Hibernate Query Language - Linguagem de consulta do Hibernate
        // JPQL - JPA Query Language
        String jpql = "select c from Cliente c";
        return em.createQuery(jpql).getResultList();
    }

    public Cliente buscarPorId(Integer id){
        return em.find(Cliente.class, id);
    }

    //@Transactional // Liga uma transação
    //@Modifying   // Somente no Spring data - notificação que aqui ocorre alteração de objetos!!
    public Cliente criarCliente(Cliente cliente){
        em.persist(cliente);
        return cliente;
    }

    public Cliente atualizar(Cliente cliente){
        return em.merge(cliente);
    }
}
