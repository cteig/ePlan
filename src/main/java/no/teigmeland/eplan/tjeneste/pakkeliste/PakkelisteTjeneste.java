package no.teigmeland.eplan.tjeneste.pakkeliste;

import no.teigmeland.eplan.dao.pakkeliste.PakkelisteDAO;
import no.teigmeland.eplan.dao.pakkeliste.PakkelisteDAOMock;
import no.teigmeland.eplan.domene.pakkeliste.PakkelisteItem;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.util.List;

/**
 * Christine Teig
 */
public class PakkelisteTjeneste {

    DataSource source = new SingleConnectionDataSource(
            "org.postgresql.Driver",
            "jdbc:postgresql://localhost/familiehub",
            "familiehub", "hemmelig", true);
    PakkelisteDAO pakkelisteDAO= new PakkelisteDAO(source);

    public List<PakkelisteItem> hentPakkeliste() {
        PakkelisteDAOMock pakkelisteDAOMock = new PakkelisteDAOMock();
        return pakkelisteDAOMock.hentAllePakkeItem();
    }
    public List<PakkelisteItem> hentAllePakkelisteItem() {
        return pakkelisteDAO.hentAllePakkelisteItem();
    }


}
