package no.teigmeland.eplan.dao.pakkeliste;

import no.teigmeland.eplan.domene.pakkeliste.Pakkeliste;
import no.teigmeland.eplan.domene.pakkeliste.PakkelisteLinje;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Christine Teig
 */
public class PakkelisteDAO {
    private JdbcTemplate jdbcTemplate;

    public PakkelisteDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PakkelisteLinje> hentAllePakkelisteLinjer() {
        String query = "SELECT * FROM pakkelistelinje";

        List<PakkelisteLinje> pakkelisteLinjer = jdbcTemplate.query(query, new RowMapper<PakkelisteLinje>() {
            @Override
            public PakkelisteLinje mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new PakkelisteLinje(rs.getInt("id"), rs.getString("kort_beskrivelse"), rs.getString("lang_beskrivelse"));
            }
        });

        return pakkelisteLinjer;
    }

    public List<Pakkeliste> hentAllePakkelister() {
        String query = "SELECT * FROM pakkeliste";

        List<Pakkeliste> pakkelister = jdbcTemplate.query(query, new RowMapper<Pakkeliste>() {
            @Override
            public Pakkeliste mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Pakkeliste(rs.getString("pakkelistenavn"));
            }
        });

        return pakkelister;
    }

    public void leggTilPakkelisteLinje(PakkelisteLinje pakkelisteLinje) {
        String query = "INSERT INTO pakkelistelinje(id, kort_beskrivelse, lang_beskrivelse) values (?,?,?)";

        jdbcTemplate.update(query, pakkelisteLinje.getId(), pakkelisteLinje.getKortBeskrivelse(), pakkelisteLinje.getLangBeskrivelse());

    }
}
