package tests.day16_testNG_framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_QualitydemyNegativeTest {

    QualitydemyPage qualitydemyPage ;

    @Test(groups = {"smoke","regression"})
    public void invalidPasswordTest(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage = new QualitydemyPage();

        qualitydemyPage.firstLoginLink.click();

        qualitydemyPage.emailLoginBox.sendKeys("anevzatcelik@gmail.com");

        qualitydemyPage.passwordLoginBox.sendKeys("1234qwer");

        qualitydemyPage.secondLoginLink.click();

        Assert.assertTrue(qualitydemyPage.emailLoginBox.isDisplayed());

        Driver.closeDriver();
    }

    @Test(groups = {"smoke","e2e1"})
    public void invalidEmailTest(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage = new QualitydemyPage();

        qualitydemyPage.firstLoginLink.click();

        qualitydemyPage.emailLoginBox.sendKeys("anevzatcelik234@gmail.com");

        qualitydemyPage.passwordLoginBox.sendKeys("Nevzat152032");

        qualitydemyPage.secondLoginLink.click();

        Assert.assertTrue(qualitydemyPage.emailLoginBox.isDisplayed());

        Driver.closeDriver();
    }


    @Test(groups = {"e2e1","regression"})
    public void invalidEmailInvalidPasswordTest(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage = new QualitydemyPage();

        qualitydemyPage.firstLoginLink.click();

        qualitydemyPage.emailLoginBox.sendKeys("anevzatcelik234@gmail.com");

        qualitydemyPage.passwordLoginBox.sendKeys("1234qwer");

        qualitydemyPage.secondLoginLink.click();

        Assert.assertTrue(qualitydemyPage.emailLoginBox.isDisplayed());

        Driver.closeDriver();
    }
}
