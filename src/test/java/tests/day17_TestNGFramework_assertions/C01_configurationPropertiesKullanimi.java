package tests.day17_TestNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_configurationPropertiesKullanimi {

    @Test
    public void test01(){

        // amazon anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //parantezi icine configuration.properties sayfasindan amazonUrl'i
        // bana getirecek bir seyler yazmam lazim

        // arama kutusuna aranacak kelimeyi yazdirin ve aratin
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.searchBox.sendKeys(ConfigReader.getProperty("amazonSearchWord")+ Keys.ENTER);

        // arama sonuclarinin aranan kelimeyi icerdigini test edin
        Assert.assertTrue(amazonPage.resultTextElement.getText().contains(ConfigReader.getProperty("amazonSearchWord")));

        // sayfayi kapatin
        Driver.closeDriver();
    }
}
