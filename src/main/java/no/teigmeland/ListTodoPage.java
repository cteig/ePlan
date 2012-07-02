package no.teigmeland;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Arrays;
import java.util.List;

public class ListTodoPage extends WebPage {

    public ListTodoPage(PageParameters parameters) {
        super(parameters);

        add(createTodoListView(Arrays.asList("todo 1", "todo 2", "todo3")));
    }

    private ListView createTodoListView(final List<String> todoListe) {
        return new ListView("todoListView", todoListe) {
            @Override
            protected void populateItem(ListItem listItem) {
                String todoTekst = (String) listItem.getModelObject();

                listItem.add(new Label("todoListItem", todoTekst));
            }
        };
    }
}
