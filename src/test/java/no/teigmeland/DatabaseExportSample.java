package no.teigmeland;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatDtdDataSet;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseExportSample
{
    public static void main(String[] args) throws Exception
    {
        // database connection
        Class driverClass = Class.forName("org.postgresql.Driver");
        Connection jdbcConnection = DriverManager.getConnection("jdbc:postgresql://localhost/familiehub", "familiehub", "hemmelig");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        // write DTD file
        FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("src/test/resources/oppgaveliste.dtd"));
    }
}