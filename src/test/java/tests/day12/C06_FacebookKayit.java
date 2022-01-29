package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookKayit  extends TestBase {
//   1- https://www.facebook.com adresine gidelim
//           2- Yeni hesap olustur butonuna basalim
// 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
// 4- Kaydol tusuna basalim

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");
        Actions actions=new Actions(driver);
        WebElement cookies= driver.findElement(By.xpath("//button[@data-testid='cookie-policy-dialog-accept-button']"));
        cookies.click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();



        WebElement ad= driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
        actions.click(ad).sendKeys("sezer").sendKeys(Keys.TAB).
                sendKeys("er").sendKeys(Keys.TAB).
                sendKeys("sezercik@hotmail.com").sendKeys(Keys.TAB).
                sendKeys("sezercik@hotmail.com").sendKeys(Keys.TAB).
                sendKeys("Sez12345").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("24").sendKeys(Keys.TAB).
                sendKeys("Mar").sendKeys(Keys.TAB).
                sendKeys("2000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
    }
}
