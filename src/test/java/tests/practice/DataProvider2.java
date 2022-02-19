package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class DataProvider2 extends TestBase {
    // Siteyi açınız. http://opencart.abstracta.us/index.php?route=account/login ,
// login yapiniz Email: batch44@gmail.com   password : 123456789
// Search fonksiyonunu kullanarak
// Mac,ipod ve samsung icin Dataprovider ile yapınız.

    @Test (dataProvider = "urunBul")
    public void aramaTesti(String aranacakKelime){
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("batch44@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

       WebElement searchBox= driver.findElement(By.xpath("//input[@name='search']"));
       searchBox.sendKeys(aranacakKelime+ Keys.ENTER);

    }

    @DataProvider
    public Object[][] urunBul(){
        Object[][] urunler= {{"Mac"},{"ipod"},{"samsung"}};
        return urunler;

    }
}
