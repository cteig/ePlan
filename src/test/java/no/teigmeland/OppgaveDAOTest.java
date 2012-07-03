package no.teigmeland;

import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class OppgaveDAOTest {

    @Test
    public void hentAlleOppgaver() throws Exception {
        // arrange
        DataSource source = new SingleConnectionDataSource(
                "jdbc:postgresql://localhost/familiehub",
                "familiehub", "hemmelig", true);
        OppgaveDAO oppgaveDAO = new OppgaveDAO(source);

        // act
        List<Oppgave> oppgaveList = oppgaveDAO.hentAlleOppgaver();

        // assert
        assertEquals(1, oppgaveList.size());

    }
}
