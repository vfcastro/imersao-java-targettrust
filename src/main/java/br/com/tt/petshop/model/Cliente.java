package br.com.tt.petshop.model;

import br.com.tt.petshop.dto.ClienteEntradaDto;

import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Geração automática pelo BD
    //@GeneratedValue(strategy = GenerationType.TABLE)//Tabela do Hibernate no Banco para controle
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minhaSeq")//BDs com SEQUENCE a parte
    //@SequenceGenerator(name = "minhaSeq", sequenceName = "MEUDB_RUN.seq_cliente")
    private Integer id;

    @Column(name = "txt_nome")
    //Propriedades de colum: insertable (não é considerado no insert) / updatable, não é considerado no update
    private String nome;

    @Column(name = "nro_cpf", columnDefinition = "VARCHAR(14)", nullable = false)
    private String cpf;

    //Construtor default para o Hibernate funcionar!!
    Cliente() {
    }

    public Cliente(ClienteEntradaDto clienteEntrada) {
        this.atualizarDadosCliente(clienteEntrada);
    }

    public void atualizarDadosCliente(ClienteEntradaDto dadosCliente) {
        this.nome = dadosCliente.getNome();
        this.cpf = dadosCliente.getCpf();
    }

    public String getDescricao(){
        return String.format("%s (%s)",this.nome, this.cpf);
    }

    public String getCpf() {
        return cpf;
    }
}
