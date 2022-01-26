package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GununSorusu07 {
    // 4 TEST METODU OLUSTURUN,oncelik vererek sirasiyla
    // https://www.n11.com/ SAYFASINA GiDİN.
    // https://www.gittigidiyor.com/ SAYFASINA GiDiN
    // https://getir.com/ SAYFASINA GiDiN
    // https://www.sahibinden.com/ SAYFASINA GiDiN
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test (priority = 1)
    public void n11test(){
        driver.get("https://www.n11.com/");

    }
    @Test (priority = 3)
    public void gittigidiyorTest(){
driver.get("https://www.gittigidiyor.com/");
    }
    @Test (priority = 5)
    public void getirTest(){
driver.get("https://getir.com/");
    }
    @Test (priority = 7)
    public void sahibindenTest(){
driver.get("https://www.sahibinden.com/");
    }
    @AfterClass
    public void end(){
        driver.quit();
    }












}
