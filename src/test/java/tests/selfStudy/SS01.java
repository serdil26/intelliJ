package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SS01 {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test (priority = 1)
    public void textBoxTest(){
        driver.get("https://demoqa.com/elements");
     driver.findElement(By.xpath("//span[text()='Text Box']")).click();
     WebElement nameBox= driver.findElement(By.xpath("//input[@id='userName']"));
nameBox.sendKeys("Ebu Harun"+ Keys.ENTER);
driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("ebuharun@hotmail.com"+Keys.ENTER);
    WebElement adress= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
adress.sendKeys("rue hopital no 45 4080 saint lamber"+Keys.ENTER);
driver.findElement(By.xpath("//button[@id='submit']")).submit();


    }

    @Test (priority = 3)
    public void checkBoxTest() throws InterruptedException {
      driver.get("https://demoqa.com/checkbox");
       driver.findElement(By.xpath("//button[@class='rct-option rct-option-expand-all']")).click();
        Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[1]/span/label/span[3]")).click();
   driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/label/span[3]")).click();

    }
    @Test (priority = 5)
    public void radioButtonTest(){
        driver.get("https://demoqa.com/radio-button");
        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();
    }
    @Test (priority = 7)
    public void webTablesTest() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Nuriye"+Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sutlu"+Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("sutlunuriye@gmail.com"+Keys.ENTER);
    driver.findElement(By.xpath("//input[@id='age']")).sendKeys("41"+Keys.ENTER);
driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("3000"+Keys.ENTER);
driver.findElement(By.xpath("//input[@id='department']")).sendKeys("kitchen"+Keys.ENTER);
WebElement save= driver.findElement(By.xpath("//button[@id='submit']"));
save.submit();
Thread.sleep(3000);
    }
    @AfterClass
    public void end() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();
    }







}
