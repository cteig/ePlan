package no.teigmeland;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ListTodoPage extends WebPage {

    public ListTodoPage(PageParameters parameters) {
        super(parameters);

        add(new Label("en_todo", "En ny TODO!"));
    }
}
