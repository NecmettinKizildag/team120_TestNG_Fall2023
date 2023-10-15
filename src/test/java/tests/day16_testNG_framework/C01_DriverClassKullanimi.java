package tests.day16_testNG_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverClassKullanimi {

    @Test(groups = "smoke")
    public void amazonTest(){
        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");

        // nutella icinm arama yapalim
        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        // sayfayi kapat
        Driver.closeDriver();
    }

    @Test(groups = {"smoke","regression"})
    public void youtubeTesti(){

        Driver.getDriver().get("https://www.youtube.com");

        Driver.closeDriver();
    }
}
