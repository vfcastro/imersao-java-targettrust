package br.com.tt.petshop.repository;

import br.com.tt.petshop.dto.UnidadeDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnidadeRepository {

    private JdbcTemplate jdbcTemplate;

    public UnidadeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UnidadeDto> listarUnidades(){

        return jdbcTemplate
                //.queryForList("select nome from unidade", String.class);
                .query("select id,nome,endereco from UNIDADE",
                        (rs, rowNum) -> new UnidadeDto(
                                            rs.getInt("id"),
                                            rs.getString("nome"),
                                            rs.getString("endereco")));

        //List<String> unidades = Arrays.asList("ZN", "ZS");
        //return unidades;
    }

    public void criarUnidade(UnidadeDto unidadeDto){

        String nome = unidadeDto.getNome();
        String endereco = unidadeDto.getEndereco();

        jdbcTemplate.update(
                "insert into UNIDADE (nome, endereco) values (?, ?)",
                nome, endereco);
    }

    public UnidadeDto buscarPorId(Long idUnidade) {

        return jdbcTemplate
                //.queryForList("select nome from unidade", String.class);
                .queryForObject("select id,nome,endereco from UNIDADE where id = ?",
                        new Object[]{idUnidade},
                        (rs, rowNum) -> new UnidadeDto(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("endereco")));
    }

    public void salvar(UnidadeDto unidade) {
        jdbcTemplate.update("update UNIDADE set nome = ?, endereco = ? where id = ?",
                unidade.getNome(), unidade.getEndereco(), unidade.getId());
    }

//    .query("select id,nome,endereco from unidade", this::converteResultSetEmUnidadeDto);
//    private UnidadeDto converteResultSetEmUnidadeDto(ResultSet rs, int rowNum) throws SQLException {
//        return new UnidadeDto(
//                rs.getInt("id"),
//                rs.getString("nome"),
//                rs.getString("endereco"));
//    }
}
