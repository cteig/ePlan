package no.teigmeland.familiehub.dao.pakkeliste;

import no.teigmeland.familiehub.domene.pakkeliste.PakkelisteItem;
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

    public List<PakkelisteItem> hentAllePakkelisteItem() {
        String query = "SELECT * FROM pakkelistelinje";

        List<PakkelisteItem> pakkelisteItemList = jdbcTemplate.query(query, new RowMapper<PakkelisteItem>() {
            @Override
            public PakkelisteItem mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new PakkelisteItem(rs.getInt("id"), rs.getString("kort_beskrivelse"), rs.getString("lang_beskrivelse"));
            }
        });

        return pakkelisteItemList;
    }

    public void leggTilPakkelisteItem(PakkelisteItem pakkelisteItem) {
        String query = "INSERT INTO pakkelistelinje(id, kort_beskrivelse, lang_beskrivelse) values (?,?,?)";

        jdbcTemplate.update(query, pakkelisteItem.getId(), pakkelisteItem.getKortBeskrivelse(), pakkelisteItem.getLangBeskrivelse());

    }
}
