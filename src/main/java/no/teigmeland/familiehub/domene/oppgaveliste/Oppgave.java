package no.teigmeland.familiehub.domene.oppgaveliste;

public class Oppgave {
    private int id;

    private String kortBeskrivelse;
    private String langBeskrivelse;

    public Oppgave(int id, String kortBeskrivelse, String langBeskrivelse) {


        this.id = id;
        this.kortBeskrivelse = kortBeskrivelse;
        this.langBeskrivelse = langBeskrivelse;
    }

    public String getKortBeskrivelse() {
        return kortBeskrivelse;
    }

}
