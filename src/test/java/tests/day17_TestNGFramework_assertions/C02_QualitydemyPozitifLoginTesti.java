package tests.day17_TestNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_QualitydemyPozitifLoginTesti {

    @Test(groups = {"smoke","regression"})
    public void pozitifLoginTesti(){
        //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //2- login linkine basin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

        qualitydemyPage.firstLoginLink.click();

        //3- Kullanici email'i olarak valid email girin
        qualitydemyPage.emailLoginBox.sendKeys(ConfigReader.getProperty("qdValidEmail"));

        //4- Kullanici sifresi olarak valid sifre girin
        qualitydemyPage.passwordLoginBox.sendKeys(ConfigReader.getProperty("qdValidPassword"));

        //5- Login butonuna basarak login olun
        qualitydemyPage.secondLoginLink.click();

        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qualitydemyPage.myCoursesButton.isDisplayed());

        ReusableMethods.takeScreenshotOfPage("qdPozitiveLogin");

        Driver.closeDriver();

    }
}
