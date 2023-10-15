package tests.day16_testNG_framework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_FacebookTest {

    @Test(groups = {"regression"})
    public void facebookTest(){

        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        ReusableMethods.wait(1);

        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker = new Faker();
        FacebookPage facebookPage = new FacebookPage();

        facebookPage.cookiesAllow.click();


        facebookPage.emaiLoginBox.sendKeys(faker.internet().emailAddress());

        facebookPage.passwordLoginBox.sendKeys(faker.internet().password());

        facebookPage.loginButton.click();



        //4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.loginFailedTextElement.isDisplayed());

        ReusableMethods.takeScreenshotOfPage("facebookLoginFailed");

        Driver.closeDriver();

    }
}
