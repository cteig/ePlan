package no.teigmeland.eplan.tjeneste.oppgaveliste;

import no.teigmeland.eplan.dao.oppgaveliste.OppgaveDAO;
import no.teigmeland.eplan.domene.oppgaveliste.Oppgave;
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
