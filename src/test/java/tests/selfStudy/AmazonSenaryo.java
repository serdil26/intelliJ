package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class AmazonSenaryo extends TestBase {
    @Test
    public void test1() {
        // https://www.amazon.com.tr sitesine gidelim
        driver.get("https://www.amazon.com");
        // Ana sayfanın açıldıgı kontrol edin

        // String expectedTitle="Amazon";
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        // çerez tercihlerinden Çerezleri kabul et seçilir
        // siteye login olun
        WebElement signInPart = driver.findElement(By.xpath("//a[@class='nav-a nav-a-2   nav-progressive-attribute']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(signInPart).perform();
        WebElement signInButton = driver.findElement(By.xpath("//span[@class='nav-action-inner']"));
        signInButton.click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sezginerdil@hotmail.com");
        actions.sendKeys(Keys.TAB).click(driver.findElement(By.xpath("//input[@id='continue']"))).perform();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Serdil26");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).click(driver.findElement(By.xpath("//input[@id='signInSubmit']"))).perform();
        // login işlemi kontrol edin
        driver.close();
    }
        @Test
        public void test2(){
        driver.get("https://www.amazon.com");
            //arama butonunun yanındaki kategörüler tabından bilgisayar secilir
            WebElement dropdownElementi= driver.findElement(By.xpath("//select[@name='url']"));
            Select select=new Select(dropdownElementi);
            select.selectByVisibleText("Computers");
            // bilgisayar kategorisi seçildigi kontrol edilir
            // arama aranına msi yaz ve arama yapın
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("msi"+Keys.ENTER);
            // aramanın yapıldıgını kontrol et
            WebElement sonucYazisiEl= driver.findElement(By.xpath("//span[text()='1-24 of 519 results for']"));
            WebElement msi=driver.findElement(By.xpath("//span[text()='\"msi\"']"));
            String sonucYazisi=(sonucYazisiEl.getText()+msi.getText());
            Assert.assertTrue(sonucYazisi.contains("msi"));
            // arama sonucları sayfasından 2. sayfa açılır

            WebElement page2= driver.findElement(By.xpath("(//a[@class='s-pagination-item s-pagination-button'])[1]"));
            JavascriptExecutor jse=(JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);",page2);
            page2.click();
            // 2. sayfanın açıldıgı kontrol edilir
           String actualUrl= driver.getCurrentUrl();
           String expectedUrl="https://www.amazon.com/s?k=msi&i=computers-intl-ship&page=2&qid=1643880640&ref=sr_pg_2";
            Assert.assertEquals(actualUrl, expectedUrl,"sayfa acilmadi");
           //sayfadaki 2. ürün favorilere eklenire

            // 2. ürünün favorilere eklendigi kontrol edilir
            // hesabım->  favori listem sayfasına gidilir
            // favori Listem sayfası açıldıgı kontrol edilir
            // eklenen ürün favorilerden silinir
            // silme işleminin gerçekleştigi kontrol edilir.
            // üye çıkış işlemi yapılır
            //çıkış işleminin yapıldıgı kontrol edilir.
        }

    }



