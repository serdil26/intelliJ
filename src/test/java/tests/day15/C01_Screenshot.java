package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_Screenshot extends TestBase {
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
        //testin calistiginin ispati icin tum sayfanin screenshot'unu alin

        //tumsayfa screenshot icin 4 adim gerekli
        //1.ADIM= takescreenshot objesi olusturalim
        TakesScreenshot tss=(TakesScreenshot) driver;

        //2.ADIM= kaydedecigimiz dosyay olusturalim
        File tumSayfa=new File("target/screenShot/tumsayfa.png");

        //3.ADIM= bir dosya daha olusturup screenshot objesi ile screenshot'i alalim
        File geciciResim= tss.getScreenshotAs(OutputType.FILE);

        //4.ADIM=gecici resmi kaydetmek istedigimz asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciResim, tumSayfa);



    }
}
