package tests.day19_testNGreports_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProviderIleAmazonCokluArama {

    @DataProvider
    public static Object[][] urunListesi() {

        String[][] aranacakUrunler = {{"Nutella"}, {"Java"}, {"Armut"}, {"elma"}, {"Erik"}, {"Malatya"}};

        return aranacakUrunler;

    }



    @Test(dataProvider = "urunListesi")
    public void amazonTopluArama(String urun){
        // amamzoin anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // verlien llistedeki her bir urun icin arama yaptirin
        // hern ururn icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edin

        String aramaSonucu;
        String[] aramaSonucKelimeleri;
        String aramasonucSayisiStr;
        int aramaonucSayisiInt;

        AmazonPage amazonPage = new AmazonPage();


        amazonPage.searchBox.clear();
        amazonPage.searchBox.sendKeys(urun + Keys.ENTER);

        aramaSonucu = amazonPage.resultTextElement.getText();

        aramaSonucKelimeleri = aramaSonucu.split(" ");

        if (aramaSonucKelimeleri[2].equals("over")){
            aramasonucSayisiStr = aramaSonucKelimeleri[3];
        } else {
            aramasonucSayisiStr = aramaSonucKelimeleri[2];
        }

        aramasonucSayisiStr = aramasonucSayisiStr.replaceAll("\\D","");
        aramaonucSayisiInt = Integer.parseInt(aramasonucSayisiStr);

        Assert.assertTrue(aramaonucSayisiInt>100);





        Driver.closeDriver();
    }
}
