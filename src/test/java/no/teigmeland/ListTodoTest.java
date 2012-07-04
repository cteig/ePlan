package no.teigmeland;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ListTodoTest {

    @Test
    public void listTodo() throws Exception {
        WebDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get("http://localhost:8080/oppgaveliste/vis");

        // Find the text input element by its name
        List<WebElement> elements = driver.findElements(By.tagName("li"));

        assertEquals(1, elements.size());
    }
}
