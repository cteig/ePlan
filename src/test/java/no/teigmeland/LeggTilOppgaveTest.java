package no.teigmeland;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class LeggTilOppgaveTest {

    @Test
    public void leggTilOppgave() throws Exception {
        WebDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get("http://localhost:8080/oppgaveliste/leggtil");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.id("todo"));

        element.sendKeys("Husk!");

        element.submit();

        Assert.assertEquals("http://localhost:8080/oppgaveliste/vis",driver.getCurrentUrl());

    }
}
