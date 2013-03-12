package no.teigmeland.familiehub.tjeneste.oppgaveliste;

import no.teigmeland.familiehub.dao.oppgaveliste.OppgaveDAO;
import no.teigmeland.familiehub.domene.oppgaveliste.Oppgave;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.util.List;

public class OppgavelisteTjeneste {

    DataSource source = new SingleConnectionDataSource(
            "jdbc:postgresql://localhost/familiehub",
            "familiehub", "hemmelig", true);
    OppgaveDAO oppgaveDAO = new OppgaveDAO(source);

    public List<Oppgave> hentOppgaveliste() {
        return oppgaveDAO.hentAlleOppgaver();
    }
}
