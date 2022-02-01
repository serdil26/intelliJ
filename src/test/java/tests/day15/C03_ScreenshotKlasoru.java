package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenshotKlasoru extends TestBase {
    //amazona git
    //3 farkli test metodu ile java, nutella, elma aratip sonuc sayfasinin screenshot'unu kaydedin
    WebElement searchBox;
    @Test(priority = 1)
    public void javaTesti() throws IOException {
        driver.get("https://www.amazon.com");
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        tumSayfaScreenshot();
    }

    @Test(priority = 2)
    public void nutellaTesti() throws IOException {

       searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("Elma" + Keys.ENTER);
        tumSayfaScreenshot();
    }

    @Test(priority = 3)
    public void elmaTesti() throws IOException {

       searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("Java" + Keys.ENTER);
        tumSayfaScreenshot();
    }
}