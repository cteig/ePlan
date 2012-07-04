package no.teigmeland.familiehub.wicket;

import no.teigmeland.familiehub.tjeneste.oppgaveliste.TodoTjeneste;
import no.teigmeland.familiehub.wicket.page.oppgaveliste.HomePage;
import no.teigmeland.familiehub.wicket.page.oppgaveliste.LeggTilTodoPage;
import no.teigmeland.familiehub.wicket.page.oppgaveliste.ListTodoPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 */
public class WicketApplication extends WebApplication {

    private TodoTjeneste todoTjeneste;

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

        mountPage("todo/list", ListTodoPage.class);
        mountPage("todo/leggtil", LeggTilTodoPage.class);

        todoTjeneste = new TodoTjeneste();
    }

    public static WicketApplication get() {
        return (WicketApplication) WebApplication.get();
    }

    public TodoTjeneste getTodoTjeneste() {
        return todoTjeneste;
    }
}
