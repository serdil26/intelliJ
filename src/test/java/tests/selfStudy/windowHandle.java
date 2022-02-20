package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class windowHandle extends TestBase {
    @Test
    public void newTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        String firstWindow= driver.getWindowHandle();
        String secondWindow="";
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Set<String> handleDegerleri=driver.getWindowHandles();
        for (String each: handleDegerleri
             ) {
            if(!each.equals(firstWindow)){
                secondWindow=each;
            }

        }
        driver.switchTo().window(secondWindow);
        Thread.sleep(3000);
        String actualText= driver.findElement(By.tagName("h1")).getText();
        String expectedText="This is a sample page";
        Assert.assertEquals(actualText, expectedText);

    }
    @Test
    public void newWindowTest() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        String firstWindow= driver.getWindowHandle();
        String secondWindow="";
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();
        Set<String> windowsValues=driver.getWindowHandles();
        for (String each: windowsValues
             ) {
            if(!each.equals(firstWindow)){
                secondWindow=each;
            }

        }
        driver.switchTo().window(secondWindow);
        Thread.sleep(3000);
        String actualText=driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        String expectedText="This is a sample page";
        Assert.assertEquals(actualText, expectedText,"textler ayni degil");

    }
    @Test
    public void newWindowMessage() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        String firstWindow= driver.getWindowHandle();
        String secondWindow="";
        driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
        Set<String> windowsValues=driver.getWindowHandles();
        for (String each: windowsValues
        ) {
            if(!each.equals(firstWindow)){
                secondWindow=each;
            }

        }
        driver.switchTo().window(secondWindow);
        Thread.sleep(3000);
        String actualText= driver.findElement(By.xpath("/html/body/text()")).getText();
        System.out.println(actualText);

    }
}
