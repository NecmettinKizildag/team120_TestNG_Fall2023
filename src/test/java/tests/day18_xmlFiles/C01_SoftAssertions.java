package tests.day18_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppSecurityPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_SoftAssertions {

    @Test
    public void zeroAppTest(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroAppUrl"));

        //2. Sign in butonuna basin
        ZeroWebAppSecurityPage zwasPage = new ZeroWebAppSecurityPage();

        zwasPage.signInButton.click();

        //3. Login kutusuna “username” yazin
        zwasPage.loginBox.sendKeys(ConfigReader.getProperty("zeroUsername"));

        //4. Password kutusuna “password” yazin
        zwasPage.passwordBox.sendKeys(ConfigReader.getProperty("zeroPassword"));

        //5. Sign in tusuna basin
        zwasPage.signInButton2.click();

        Driver.getDriver().navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        zwasPage.onlineBankingMenuButton.click();

        zwasPage.payBillsLink.click();

        //7. “Purchase Foreign Currency” tusuna basin
        zwasPage.purchaseForeignCurrencyButton.click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        Select select = new Select(zwasPage.currencyDropDownMenu);

        select.selectByValue("EUR");

        //9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();

        String actualSecim = select.getFirstSelectedOption().getText();
        String expectedSecim = "Eurozone (euro)";

        softAssert.assertEquals(expectedSecim,actualSecim,"secilen opsiyon Eurozone degil");

        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
        //(yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
        //(dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
        //(dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        String[] dropdownElementleriArr = {"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)"
                ,"Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)"
                ,"Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};

        List<String> expectedDropdownElementList = Arrays.asList(dropdownElementleriArr);

        List<WebElement> dropdownElementleriList = select.getOptions();

        List<String> actualDropdownOpsiyonlariList = new ArrayList<>();

        for (WebElement each:dropdownElementleriList
             ) {
            actualDropdownOpsiyonlariList.add(each.getText());
        }

        softAssert.assertEquals(actualDropdownOpsiyonlariList,expectedDropdownElementList,"dropdown opsiyonlari istenen sekilde degil");


        softAssert.assertAll();

        Driver.closeDriver();
    }
}
