package tests.day19_testNGreports_crossBrowserTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluNegatifLoginTesti extends TestBaseRapor{

    private QualitydemyPage qualitydemyPage;

    @Test
    public void invalidPasswordTest(){
        extentTest=extentReports.createTest("invalidPasswordTest","kulanici gecersiz password ve gecerli kullanici adiyla giris yapamamali");
        extentTest.info("kullnaici qualitydemy anasayfasina gider");

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage = new QualitydemyPage();

        qualitydemyPage.firstLoginLink.click();
        extentTest.info("ilk sayfadaki login linkine tiklar");

        qualitydemyPage.emailLoginBox.sendKeys("anevzatcelik@gmail.com");
        extentTest.info("gecerli e mail yazilir");

        qualitydemyPage.passwordLoginBox.sendKeys("Nevzat152032");
        extentTest.info("password olarak gecersiz password yazar");

        qualitydemyPage.secondLoginLink.click();
        extentTest.info("login butonuna basar");

        Assert.assertTrue(qualitydemyPage.emailLoginBox.isDisplayed());
        extentTest.pass("giris yapilamadigini test eder");

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");
    }

    @Test
    public void invalidEmailTest(){
        extentTest=extentReports.createTest("invalidEmailTest","kulanici gecerli password ve gecersiz kullanici adiyla giris yapamamali");
        extentTest.info("kullnaici qualitydemy anasayfasina gider");

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage = new QualitydemyPage();

        qualitydemyPage.firstLoginLink.click();
        extentTest.info("ilk sayfadaki login linkine tiklar");

        qualitydemyPage.emailLoginBox.sendKeys("anevzatcelik234@gmail.com");
        extentTest.info("gecersiz e mail yazilir");

        qualitydemyPage.passwordLoginBox.sendKeys("Nevzat152032");
        extentTest.info("password olarak gecerli password yazar");

        qualitydemyPage.secondLoginLink.click();
        extentTest.info("login butonuna basar");

        Assert.assertTrue(qualitydemyPage.emailLoginBox.isDisplayed());
        extentTest.pass("giris yapilamadigini test eder");

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");
    }


    @Test
    public void invalidEmailInvalidPasswordTest(){
        extentTest=extentReports.createTest("invalidEmailInvalidPasswordTest","kulanici gecersiz password ve gecersiz kullanici adiyla giris yapamamali");
        extentTest.info("kullnaici qualitydemy anasayfasina gider");

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage = new QualitydemyPage();

        qualitydemyPage.firstLoginLink.click();
        extentTest.info("ilk sayfadaki login linkine tiklar");

        qualitydemyPage.emailLoginBox.sendKeys("anevzatcelik234@gmail.com");
        extentTest.info("gecersiz e mail yazilir");

        qualitydemyPage.passwordLoginBox.sendKeys("1234qwer");
        extentTest.info("password olarak gecersiz password yazar");

        qualitydemyPage.secondLoginLink.click();
        extentTest.info("login butonuna basar");

        Assert.assertTrue(qualitydemyPage.emailLoginBox.isDisplayed());
        extentTest.pass("giris yapilamadigini test eder");

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");
    }
    
}
