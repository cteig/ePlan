package no.teigmeland.eplan.dao.pakkeliste;

import no.teigmeland.eplan.domene.pakkeliste.PakkelisteLinje;

import java.util.ArrayList;
import java.util.List;

/**
 * Christine Teig
 */
public class PakkelisteDAOMock {
    public List<PakkelisteLinje> hentAllePakkeItem() {

        List<PakkelisteLinje> pakkeliste = new ArrayList<PakkelisteLinje>();

        PakkelisteLinje pakkelisteLinje1 = new PakkelisteLinje(1, "sokker", "sokker");
        PakkelisteLinje pakkelisteLinje2 = new PakkelisteLinje(1, "bukser", "bukser");
        PakkelisteLinje pakkelisteLinje3 = new PakkelisteLinje(1, "genser", "genser");
        PakkelisteLinje pakkelisteLinje4 = new PakkelisteLinje(1, "jakke", "jakke");
        PakkelisteLinje pakkelisteLinje5 = new PakkelisteLinje(1, "lue", "lue");
        pakkeliste.add(pakkelisteLinje1);
        pakkeliste.add(pakkelisteLinje2);
        pakkeliste.add(pakkelisteLinje3);
        pakkeliste.add(pakkelisteLinje4);
        pakkeliste.add(pakkelisteLinje5);

        return pakkeliste;
    }
}
