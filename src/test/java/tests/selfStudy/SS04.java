package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class SS04 extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.amazon.fr");
        WebElement cookies= driver.findElement(By.id("sp-cc-accept"));
        cookies.click();
        driver.findElement(By.id("twotabsearchtextbox")).click();
        Actions actions=new Actions(driver);
        actions.sendKeys("java"+ Keys.ENTER).perform();
        WebElement sonucElementi= driver.findElement(By.xpath("//span[text()='1-48 sur plus de 50 000 résultats pour']"));
        System.out.println(sonucElementi.getText());



    }
}
