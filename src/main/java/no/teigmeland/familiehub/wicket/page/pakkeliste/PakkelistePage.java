package no.teigmeland.familiehub.wicket.page.pakkeliste;

import no.teigmeland.familiehub.domene.pakkeliste.PakkelisteItem;
import no.teigmeland.familiehub.tjeneste.pakkeliste.PakkelisteTjeneste;
import no.teigmeland.familiehub.wicket.WicketApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Arrays;
import java.util.List;

/**
 * Christine Teig,
 */
public class PakkelistePage extends WebPage{

    public PakkelisteTjeneste pakkelisteTjeneste;

    public PakkelistePage(PageParameters parameters) {
        super(parameters);

        pakkelisteTjeneste = WicketApplication.get().getPakkelisteTjeneste();

        add(createPakkelisteView(pakkelisteTjeneste.hentPakkeliste()));
    }

    private ListView createPakkelisteView(final List<PakkelisteItem> pakkeliste) {
        return new ListView("pakkelisteView", pakkeliste) {
            @Override
            protected void populateItem(ListItem listItem) {
                PakkelisteItem pakkelsiteTekst = (PakkelisteItem) listItem.getModelObject();

                listItem.add(new Label("pakkelisteItem", pakkelsiteTekst.getKortBeskrivelse()));
            }
        };
    }
}

//TODO test pakkelistepage

