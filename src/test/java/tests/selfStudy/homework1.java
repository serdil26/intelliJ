package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class homework1 extends TestBase {
    /*odev
soru :ingilizce
 //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
 //maximize the window
//click on action dialog button
 //if need use explicitly wait
//click on the ok button
//accept the iframe message
     */
    @Test
    public void test(){
        //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        //click on action dialog button
        driver.findElement(By.xpath("//button[@id='action']")).click();
        //click on the ok button
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-mycodemyway-action"))).click();

        //accept the iframe message
        driver.switchTo().alert().accept();

    }
}
