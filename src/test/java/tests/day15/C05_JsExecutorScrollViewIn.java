package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_JsExecutorScrollViewIn extends TestBase {
 //   1- Yeni bir class olusturun : ScroolInto
 //  2- hotelmycamp anasayfasina gidin
 // 3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin
 // 4- istediginiz oda inceleme sayfasi acildigini test edin

    @Test
    public void scrollAction(){
        driver.get("https://www.hotelmycamp.com/");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("(//a[@class='btn-custom'])[4]")).click();

    }

    @Test
    public void scrollJsExecutor() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com/");

        //1.ADIM jsexecutor olustur ve driver'a cast edelim
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        //2.ADIM calisacagimiz webelemnti locate edelim
        WebElement odaIncele= driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));

        //3.ADIM ilgili scrip ve argument ile jse.executeScript() metodunu calistir
        jse.executeScript("arguments[0].scrollIntoView(true);", odaIncele);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click();",odaIncele);
        Thread.sleep(3000);
    }
}
