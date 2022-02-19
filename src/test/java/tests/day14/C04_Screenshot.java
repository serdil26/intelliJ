package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {
    @Test
    public void test(){
        driver.get("https://google.com");
        driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();
        //1.ADIM=screenshot almak icin obje olustruyoruz ve deger olarak driveri atiyoruz
        //deger olarak driver'i kabul etmesi icin CASTING yapmak gerekir
        TakesScreenshot tss=(TakesScreenshot)driver;
        //2.ADIM=tum sayfanin SCREENSHOT'ini almak icin bir FILE olusturalim ve
        //dosya yolunu belirtelim
        File tumSayfaSs= new File("src/tumSayfa.png");

        //3.ADIM=olusturdugumuz file ile takescreenshot objesini iliskilendirelim
        tumSayfaSs= tss.getScreenshotAs(OutputType.FILE);

        //eger spesifik bir elemntin screenshot'ini almak istersek
        WebElement logoElm= driver.findElement(By.xpath("(//img[@alt='Google'])[1]"));
        File logoResmi= new File("src/logo.png");
        logoResmi=logoElm.getScreenshotAs(OutputType.FILE);



    }
}
