package tests.day17_TestNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_Assertions {

    @Test(groups = {"regression"})
    public void test01(){

        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // url'in amazon icerdigini test edelim
        String expectedUrlContent = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlContent));

        // aranacak kelimeyi aratalim
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.searchBox.click();

        amazonPage.searchBox.sendKeys(ConfigReader.getProperty("amazonSearchWord")+Keys.ENTER);

        // sonuclarin aranacak kelimeyi icerdigini test edelim
        String actualResultText = amazonPage.resultTextElement.getText();
        String expectedResultText = ConfigReader.getProperty("amazonSearchWord");

        Assert.assertTrue(actualResultText.contains(expectedResultText));

        // ilk urune tiklayalim
        amazonPage.firstItem.click();

        // ilk urun isminde aranacak kelime bulundugunu test edelim
        String expectedProductTitle = ConfigReader.getProperty("amazonSearchWord");
        String actualProductTitle = amazonPage.productTitle.getText();
        Assert.assertTrue(actualProductTitle.contains(expectedProductTitle));

        // sayfayi kapatalim
        Driver.closeDriver();
    }
}
