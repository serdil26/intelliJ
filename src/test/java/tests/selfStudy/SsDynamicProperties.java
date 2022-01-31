package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class SsDynamicProperties extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement ilkText= driver.findElement(By.xpath("//div/p"));
        System.out.println("ilk text metin=" + ilkText.getText());

        WebElement ilkButton= driver.findElement(By.id("enableAfter"));
        Thread.sleep(5000);
        ilkButton.click();
        System.out.println(ilkButton.getText());

        WebElement ikinciButton= driver.findElement(By.id("colorChange"));
        String expectedColorText="Color Change";
        Assert.assertTrue(ikinciButton.getText().equals(expectedColorText));

        WebElement ucuncuButton= driver.findElement(By.id("visibleAfter"));
        String expectedText= "Visible After 5 Seconds";
        Assert.assertTrue(ucuncuButton.getText().equals(expectedText));
    }
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("downloadButton")).click();
        Thread.sleep(3000);

        String path= System.getProperty("user.home") + "\\İndirilenler\\sampleFile.jpeg";
       if(path.contains("sampleFile.jpeg")){
           System.out.println("download test PASSED");
       }
    }
}
