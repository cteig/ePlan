package no.teigmeland;

import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

public class TodoTjeneste {

    DataSource source = new SingleConnectionDataSource(
            "jdbc:postgresql://localhost/familiehub",
            "familiehub", "hemmelig", true);
    OppgaveDAO oppgaveDAO = new OppgaveDAO(source);
    List<Oppgave> hentTodoListe() {
        return oppgaveDAO.hentAlleOppgaver();
    }
}
