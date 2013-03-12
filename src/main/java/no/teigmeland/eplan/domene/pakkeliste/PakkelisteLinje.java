package no.teigmeland.eplan.domene.pakkeliste;

/**
 * Christine Teig
 */
public class PakkelisteLinje {

    private int id;

    private String kortBeskrivelse;
    private String langBeskrivelse;


    public PakkelisteLinje(int id, String kortBeskrivelse, String langBeskrivelse) {


        this.id = id;
        this.kortBeskrivelse = kortBeskrivelse;
        this.langBeskrivelse = langBeskrivelse;
    }

    public int getId() {
        return id;
    }

    public String getKortBeskrivelse() {
        return kortBeskrivelse;
    }

    public String getLangBeskrivelse() {
        return langBeskrivelse;
    }

}


