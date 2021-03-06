package no.teigmeland.eplan.dao.oppgaveliste;

import no.teigmeland.eplan.domene.oppgaveliste.Oppgave;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class OppgaveDAO {

    private JdbcTemplate jdbcTemplate;

    public OppgaveDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Oppgave> hentAlleOppgaver() {
        String query = "SELECT * FROM oppgave";

        List<Oppgave> oppgaver = jdbcTemplate.query(query, new RowMapper<Oppgave>() {
            @Override
            public Oppgave mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Oppgave(rs.getInt("id"), rs.getString("kort_beskrivelse"), rs.getString("lang_beskrivelse"));
            }
        });

        return oppgaver;
    }

    public void leggTilOppgave(Oppgave oppgave) {
        String query = "INSERT INTO oppgave(id, kort_beskrivelse, lang_beskrivelse) values (?,?,?)";

        jdbcTemplate.update(query, oppgave.getId(), oppgave.getKortBeskrivelse(), oppgave.getLangBeskrivelse());

    }
}