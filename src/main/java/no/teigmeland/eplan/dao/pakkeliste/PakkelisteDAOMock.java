package no.teigmeland.eplan.dao.pakkeliste;

import no.teigmeland.eplan.domene.pakkeliste.PakkelisteItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Christine Teig
 */
public class PakkelisteDAOMock {
    public List<PakkelisteItem> hentAllePakkeItem() {

        List<PakkelisteItem> pakkeliste = new ArrayList<PakkelisteItem>();

        PakkelisteItem pakkelisteItem1 = new PakkelisteItem(1, "sokker", "sokker");
        PakkelisteItem pakkelisteItem2 = new PakkelisteItem(1, "bukser", "bukser");
        PakkelisteItem pakkelisteItem3 = new PakkelisteItem(1, "genser", "genser");
        PakkelisteItem pakkelisteItem4 = new PakkelisteItem(1, "jakke", "jakke");
        PakkelisteItem pakkelisteItem5 = new PakkelisteItem(1, "lue", "lue");
        pakkeliste.add(pakkelisteItem1);
        pakkeliste.add(pakkelisteItem2);
        pakkeliste.add(pakkelisteItem3);
        pakkeliste.add(pakkelisteItem4);
        pakkeliste.add(pakkelisteItem5);

        return pakkeliste;
    }
}
