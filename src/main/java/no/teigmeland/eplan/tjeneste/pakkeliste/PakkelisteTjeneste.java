package no.teigmeland.eplan.tjeneste.pakkeliste;

import no.teigmeland.eplan.dao.pakkeliste.PakkelisteDAO;
import no.teigmeland.eplan.dao.pakkeliste.PakkelisteDAOMock;
import no.teigmeland.eplan.domene.pakkeliste.Pakkeliste;
import no.teigmeland.eplan.domene.pakkeliste.PakkelisteLinje;
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

    public List<PakkelisteLinje> hentPakkeliste() {
        PakkelisteDAOMock pakkelisteDAOMock = new PakkelisteDAOMock();
        return pakkelisteDAOMock.hentAllePakkeItem();
    }
    public List<PakkelisteLinje> hentAllePakkelisteLinjer() {
        return pakkelisteDAO.hentAllePakkelisteLinjer();
    }

    public List<Pakkeliste> hentAllePakkelister() {
        return pakkelisteDAO.hentAllePakkelister();
    }


}
