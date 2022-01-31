package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class SsActionClass extends TestBase {


    @Test
    public void actionsTest(){
        //    1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        Actions action=new Actions(driver);
        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hover= driver.findElement(By.xpath("//button[@class='dropbtn']"));
        action.moveToElement(hover).perform();
        //3. "Link 1" e tiklayin
        WebElement link1= driver.findElement(By.xpath("//a[text()='Link 1']"));
        action.click(link1).perform();
        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //            6. "Click and hold" kutusuna basili tutun
        WebElement clickHold= driver.findElement(By.xpath("//div[@id='click-box']"));
        action.clickAndHold(clickHold).perform();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHold.getText());
        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.xpath("//div[@id='double-click']"));
        action.doubleClick(doubleClick).perform();
    }

}
