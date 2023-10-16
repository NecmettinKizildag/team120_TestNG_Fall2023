package tests.day19_testNGreports_crossBrowserTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_QualitydemyCokluNegatifLoginTesti {

    @DataProvider
    public static Object[][] gecersizKullaniciListesi() {
        String[][]  gecersizKullaniciBilgileri = new String[10][2];
        Faker faker = new Faker();

        for (int i = 0; i < gecersizKullaniciBilgileri.length ; i++) {
            gecersizKullaniciBilgileri[i][0] = faker.internet().emailAddress();
            gecersizKullaniciBilgileri[i][1] = faker.internet().password();
        }

        return gecersizKullaniciBilgileri;
    }

    @Test(dataProvider = "gecersizKullaniciListesi")
    public void cokluNegatifTest(String username, String password){
        //qualitydemy anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // ilk login linkine tiklkayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.firstLoginLink.click();

        // verilen gecersiz kullanici adi ve sifreleri listesindeki 5 isim ve sifre icin giris yapilmadigini test edin
        qualitydemyPage.emailLoginBox.sendKeys(username);
        qualitydemyPage.passwordLoginBox.sendKeys(password);

        qualitydemyPage.secondLoginLink.click();

        Assert.assertTrue(qualitydemyPage.emailLoginBox.isDisplayed());

        // sayfayi kapatin
        Driver.closeDriver();
    }
}
