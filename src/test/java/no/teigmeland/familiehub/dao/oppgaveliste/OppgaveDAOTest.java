package no.teigmeland.familiehub.dao.oppgaveliste;

import no.teigmeland.familiehub.domene.oppgaveliste.Oppgave;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class OppgaveDAOTest {

    private JdbcDatabaseTester databaseTester;

    @Before
    public void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("org.postgresql.Driver",
                "jdbc:postgresql://localhost/familiehub", "familiehub", "hemmelig");

        // initialize your dataset here
        DataFileLoader loader = new FlatXmlDataFileLoader();

        String dataSetFilename = "/" + this.getClass().getCanonicalName().replaceAll("\\.", "/") + ".xml";

        IDataSet dataSet = loader.load(dataSetFilename);

        databaseTester.setDataSet(dataSet);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);

        databaseTester.onSetup();
    }

    @After
    public void tearDown() throws Exception {
        databaseTester.setTearDownOperation(DatabaseOperation.NONE);
        databaseTester.onTearDown();
    }

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

    @Test
    public void leggTilOppgave() throws Exception {
        // arrange
        DataSource source = new SingleConnectionDataSource(
                "jdbc:postgresql://localhost/familiehub",
                "familiehub", "hemmelig", true);
        OppgaveDAO oppgaveDAO = new OppgaveDAO(source);
        List<Oppgave> oppgaveList = oppgaveDAO.hentAlleOppgaver();
        int oppgavelistLengdeFør = oppgaveList.size();

        // act
        oppgaveDAO.leggTilOppgave(new Oppgave(2, "fisk", "laks"));
        List<Oppgave> oppgaveListEtter = oppgaveDAO.hentAlleOppgaver();
        int oppgavelistLengdeEtter = oppgaveListEtter.size();

        // assert
        assertEquals(oppgavelistLengdeFør + 1, oppgavelistLengdeEtter);

    }
}
