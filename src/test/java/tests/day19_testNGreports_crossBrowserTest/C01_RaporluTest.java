package tests.day19_testNGreports_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {

    @Test
    public void nutellaTesti (){
        extentTest = extentReports.createTest("Amazon Testi","Kullanici amazon'da istenen kelimeyi aratip ilk urune gidebilmeli");

        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("kullanici anasayfaya gider");

        // url'in amazon icerdigini test edelim
        String expectedUrlContent = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlContent));
        extentTest.pass("url'in amazon icerdigini test eder");

        // aranacak kelimeyi aratalim
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.searchBox.click();

        amazonPage.searchBox.sendKeys(ConfigReader.getProperty("amazonSearchWord")+ Keys.ENTER);
        extentTest.info("test datasi olarak belirlenen kelimeyi aratir");

        // sonuclarin aranacak kelimeyi icerdigini test edelim
        String actualResultText = amazonPage.resultTextElement.getText();
        String expectedResultText = ConfigReader.getProperty("amazonSearchWord");

        Assert.assertTrue(actualResultText.contains(expectedResultText));
        extentTest.pass("Amazon arama sonuclarinin aranan kelimeyi icerdigini test eder");

        // ilk urune tiklayalim
        amazonPage.firstItem.click();
        extentTest.info("ilk urune tiklar");

        // ilk urun isminde aranacak kelime bulundugunu test edelim
        String expectedProductTitle = ConfigReader.getProperty("amazonSearchWord2");
        String actualProductTitle = amazonPage.productTitle.getText();
        Assert.assertTrue(actualProductTitle.contains(expectedProductTitle));
        extentTest.pass("ilk urun isminde arana kelinmenin bulundugunu test eder");

        // sayfayi kapatalim
        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");

    }
}
