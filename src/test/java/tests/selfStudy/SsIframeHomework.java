package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class SsIframeHomework extends TestBase {

    @Test
    public void iFrameTest() throws InterruptedException {
        //    1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
//            2. “Our Products” butonuna basin
       WebElement frame= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
WebElement products= driver.findElement(By.xpath("//a[text()='Our Products']"));
products.click();

//3. “Cameras product”i tiklayin
        driver.findElement(By.id("camera-img")).click();
        Thread.sleep(3000);

//4. Popup mesajini yazdirin
        WebElement mesaj= driver.findElement(By.className("modal-content"));
        System.out.println(mesaj.getText());

//5. “close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();

//6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();
        driver.findElement(By.tagName("a")).click();

//7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
       String currentUrl= driver.getCurrentUrl();
       String expectedUrl= "http://webdriveruniversity.com/index.html";
        Assert.assertEquals(currentUrl,expectedUrl);

    }

}
