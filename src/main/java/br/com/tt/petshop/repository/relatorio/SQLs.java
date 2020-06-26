package br.com.tt.petshop.repository.relatorio;

public class SQLs {

    public static final String JPQL_RELATORIO_ANIMAL =
            "select a.nome as nome, a.dataNascimento as dataNascimento, a.tipo as tipo," +
            "c.nome as nomeCliente, c.cpf as cpfCliente from Animal a join a.cliente c";

}
