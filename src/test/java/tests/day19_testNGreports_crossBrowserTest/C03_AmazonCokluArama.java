package tests.day19_testNGreports_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_AmazonCokluArama {

    @Test
    public void amazonTopluArama(){
        // amamzoin anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // verlien llistedeki her bir urun icin arama yaptirin
        String[] aranacakUrunler = {"Nutella","Java","Armut","elma","Erik","Malatya"};
        String aramaSonucu;
        String[] aramaSonucKelimeleri;
        String aramasonucSayisiStr;
        int aramaonucSayisiInt;

        AmazonPage amazonPage = new AmazonPage();

        for (int i = 0; i <aranacakUrunler.length ; i++) {
            amazonPage.searchBox.clear();
            amazonPage.searchBox.sendKeys(aranacakUrunler[i] + Keys.ENTER);

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

        }

        // hern ururn icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edin
    }
}
