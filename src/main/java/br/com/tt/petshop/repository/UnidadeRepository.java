package br.com.tt.petshop.repository;

import br.com.tt.petshop.dto.UnidadeEntradaDto;
import br.com.tt.petshop.dto.UnidadeDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class UnidadeRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    public UnidadeRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public List<UnidadeDto> listarUnidades() {

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

    public int criarUnidade(UnidadeEntradaDto unidadeDto) {

        SqlParameterSource sql = new MapSqlParameterSource()
                .addValue("nome", unidadeDto.getNome())
                .addValue("endereco", unidadeDto.getEndereco());

        return new SimpleJdbcInsert(dataSource)
                .withTableName("Unidade")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKey(sql).intValue();
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

    public void remover(Long id) {
        jdbcTemplate.update("delete from UNIDADE where id = ?", id);
    }

//    .query("select id,nome,endereco from unidade", this::converteResultSetEmUnidadeDto);
//    private UnidadeDto converteResultSetEmUnidadeDto(ResultSet rs, int rowNum) throws SQLException {
//        return new UnidadeDto(
//                rs.getInt("id"),
//                rs.getString("nome"),
//                rs.getString("endereco"));
//    }
}
