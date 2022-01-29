package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GununSorusu {

    WebDriver driver;
    @BeforeClass
    public void setup(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){
        // 1) "https://www.facebook.com/" SAYFASINA GiDiN
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement daysElement= driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select select1=new Select(daysElement);
        List<WebElement> days=select1.getOptions();
        System.out.println("Gunler= ");
        for (WebElement each:days) {
            System.out.print(each.getText() + " ");
        }
        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
        WebElement monthsElement=driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select select2=new Select(monthsElement);
        List<WebElement> months=select2.getOptions();
        System.out.println("Aylar= ");
        for (WebElement each1:months
             ) {
            System.out.print(each1.getText()+" ");

        }
        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
        WebElement yearsElement=driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select select3=new Select(yearsElement);
        List<WebElement> years= select3.getOptions();
        System.out.println("Yillar= ");
        for (WebElement each2: years
             ) {
            System.out.print(each2.getText()+" ");

        }

    }
@AfterClass
    public void tearDown(){
       driver.close();
}







}

