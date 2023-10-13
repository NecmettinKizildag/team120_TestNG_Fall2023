package tests.day15_testNG_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C02_dependsOnMethods {

    // uc tane test method'u olusturun

    // 1- amazonTest : amazon anasayfaya gidip url'in amazon icerdigini test edelim

    // 2- nutellaTest : Nutella icin arama yapip arama sonuclarinin Nutella icerdigini test edelim

    // 3- ilkUrunTesti : ilk urunu click yapip, urun isminin Nutella icerdigini test edin

    /*
        DependsOnMethods priority'den farklidir

        DependsOnMethods hangi method'un once calisacagina karar vermez
        Sadece yazildigi test calismadan once, baglandigi testin
        calistigindan ve PASSED oldugundan emin olmak ister.

        bagli oldugu test calismaz veya calisir ama PASSED olmazsa
        DependsOnMethods'un yazildigi test IGNORE olur

        DependsOnMethods yazildigi method tek basina calistirilmak istenirse
        once bagli oldugu testin calismasi ve Passed olmasi gerektiginden
        kendinden once bagli oldugu method'un calismasini saglar

        Ama bu baglanti birden fazla method'u calistirmaz.

        priority kullanilarak bir method'un once calismasi istense de
        o method onceligi bagli oldugu method'a devreder
        bagli olunan method da baska method'a bagliysa once onu calistirir.
     */

    @Test
    public void amazonTest(){
        Driver.getDriver().get("https://www.amazon.com/");

        String expectedUrlContent = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlContent));


    }

    @Test (dependsOnMethods = "amazonTest")
    public void nutellaTest(){
        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        WebElement resultElement = Driver.getDriver().findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expeectedContent = "Nutella";
        String actualContent = resultElement.getText();

        Assert.assertTrue(actualContent.contains(expeectedContent));
    }

    @Test (dependsOnMethods = "nutellaTest")
    public void ilkUrunTest(){

        WebElement firstItem = Driver.getDriver().findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]"));
        firstItem.click();

        WebElement title = Driver.getDriver().findElement(By.xpath("//span[@id='productTitle']"));

        String expectedTitle = "Nutella";
        String actualTitle = title.getText();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Driver.closeDriver();

    }
}
