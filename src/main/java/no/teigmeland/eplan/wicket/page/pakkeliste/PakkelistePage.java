package no.teigmeland.eplan.wicket.page.pakkeliste;

import no.teigmeland.eplan.domene.pakkeliste.PakkelisteLinje;
import no.teigmeland.eplan.tjeneste.pakkeliste.PakkelisteTjeneste;
import no.teigmeland.eplan.wicket.WicketApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.List;

/**
 * Christine Teig,
 */
public class PakkelistePage extends WebPage{

    public PakkelisteTjeneste pakkelisteTjeneste;

    public PakkelistePage(PageParameters parameters) {
        super(parameters);

        pakkelisteTjeneste = WicketApplication.get().getPakkelisteTjeneste();

        add(createPakkelisteView(pakkelisteTjeneste.hentAllePakkelisteItem()));
    }

    private ListView createPakkelisteView(final List<PakkelisteLinje> pakkeliste) {
        return new ListView("pakkelisteView", pakkeliste) {
            @Override
            protected void populateItem(ListItem listItem) {
                PakkelisteLinje pakkelsiteTekst = (PakkelisteLinje) listItem.getModelObject();

                listItem.add(new Label("pakkelisteLinje", pakkelsiteTekst.getKortBeskrivelse()));
            }
        };
    }
}

//TODO test pakkelistepage

