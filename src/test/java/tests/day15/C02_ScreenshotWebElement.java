package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenshotWebElement extends TestBase {

    @Test
    public void nutellaTesti() throws IOException {
        //amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        //nutella aramasi yapin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin nutella icerdigini test edin
        WebElement sonucYazElm= driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucSayisi= sonucYazElm.getText();
        Assert.assertTrue(sonucSayisi.contains("Nutella"));
        //testin calistiginin ispati icin sonuc yazisi webelementi'nin screenshot'unu alin
        //1.adim screen shot cekecegimiz webelement'i locate edelim

        //2.screenshotu kaydedecegimz bir file olusturalim
        File webElementiSs= new File("target/screenShot/webElement.jpeg");

        //3.adim=
        File geciciResim=sonucYazElm.getScreenshotAs(OutputType.FILE);

        //4;Adim= gecici resmi kayit yapacagimiz asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciResim, webElementiSs);




    }
}
