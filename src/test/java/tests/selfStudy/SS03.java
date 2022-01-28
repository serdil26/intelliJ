package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SS03 {
    //https://demoqa.com/alerts adresine gidin
    //birinci "click me" butonuna tiklayin
    //cikan mesaji alin ve tamam'i tiklayin

    //ucuncu "click me" butonuna tiklayin ve cikan mesajda iptale basin

    //dorduncu "click me" butonuna tiklayin ve cikan yere adinizi yazip tamami tiklayin

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/alerts");
    }
 @Test (priority = 1)
    public void test01(){


        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
     System.out.println(driver.switchTo().alert().getText());
     driver.switchTo().alert().accept();


    }

    @Test (priority = 2)
    public void test02(){
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
        driver.switchTo().alert().dismiss();

    }
    @Test (priority = 3)
    public void test03(){
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        driver.switchTo().alert().sendKeys("sez");
        driver.switchTo().alert().accept();

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }



}
