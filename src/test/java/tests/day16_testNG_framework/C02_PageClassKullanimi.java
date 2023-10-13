package tests.day16_testNG_framework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test
    public void nutellaTesti(){

        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");

        // nutella icin arama yapalim
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.searchBox.sendKeys("Nutella"+ Keys.ENTER);

        // arama sonuclarinin nutella icerdigini test edelim
        String expectedResultContent = "Nutella";
        String actualResultText = amazonPage.resultTextElement.getText();

        Assert.assertTrue(actualResultText.contains(expectedResultContent));

        // driver i kapatalim
        Driver.closeDriver();

    }
}
