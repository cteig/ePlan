package no.teigmeland.eplan.wicket;

import no.teigmeland.eplan.tjeneste.oppgaveliste.OppgavelisteTjeneste;
import no.teigmeland.eplan.tjeneste.pakkeliste.PakkelisteTjeneste;
import no.teigmeland.eplan.wicket.page.oppgaveliste.HomePage;
import no.teigmeland.eplan.wicket.page.oppgaveliste.LeggTilOppgavePage;
import no.teigmeland.eplan.wicket.page.oppgaveliste.OppgavelistePage;
import no.teigmeland.eplan.wicket.page.pakkeliste.PakkelistePage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 */
public class WicketApplication extends WebApplication {

    private OppgavelisteTjeneste oppgavelisteTjeneste;
    private PakkelisteTjeneste pakkelisteTjeneste;

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        // add your configuration here

        mountPage("oppgaveliste/vis", OppgavelistePage.class);
        mountPage("oppgaveliste/leggtil", LeggTilOppgavePage.class);
        mountPage("oppgaveliste/pakkeliste", PakkelistePage.class);

        oppgavelisteTjeneste = new OppgavelisteTjeneste();
        pakkelisteTjeneste = new PakkelisteTjeneste();
    }

    public static WicketApplication get() {
        return (WicketApplication) WebApplication.get();
    }

    public OppgavelisteTjeneste getOppgavelisteTjeneste() {
        return oppgavelisteTjeneste;
   }

    public PakkelisteTjeneste getPakkelisteTjeneste() {
        return pakkelisteTjeneste;
    }
}

