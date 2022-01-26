package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class GununSorusu06 {

WebDriver driver;
 @BeforeMethod
    public void setup(){
     WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

 }
 @Test
    public void test01() {
  //● https://the-internet.herokuapp.com/windows adresine gidin.
  driver.get("https://the-internet.herokuapp.com/windows");
  //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
  String actualText = driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText();
  String expectedText = "Opening a new window";
  Assert.assertEquals(actualText, expectedText);
  //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
  String actualTitle = driver.getTitle();
  String expectedTitle = "The Internet";
  Assert.assertEquals(actualTitle, expectedTitle);
  String firstWindow = driver.getWindowHandle();
  Set<String> allWindows = driver.getWindowHandles();
  for (String newWindow : allWindows
  ) {
   driver.switchTo().window(newWindow);

  }
  //● Click Here butonuna basın.
  driver.findElement(By.xpath("//a[text()='Click Here']")).click();
  //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
  String actualTitle1 = driver.getTitle();
  String expectedTitle1 = "New Window";
  Assert.assertEquals(actualTitle1, expectedTitle1);



  //● Sayfadaki textin “New Window” olduğunu doğrulayın.
  String newText = driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText();
  String expectedNewText = "New Window";
  Assert.assertEquals(newText, expectedNewText);
  driver.close();
driver.switchTo().window(firstWindow);

     //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

     String actualTitle2=driver.getTitle();
     String expectedTitle2="The Internet";
     Assert.assertEquals(actualTitle2,expectedTitle2);

 }


}
