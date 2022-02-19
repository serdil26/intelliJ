package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
//    1. Bir class olusturun : WaitTest
//2. Iki tane metod olusturun : implicitWait() , explicitWait()
//    Iki metod icin de asagidaki adimlari test edin.
//            3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
//            4. Remove butonuna basin.
//5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
//6. Add buttonuna basin
//7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //            4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']")).click();
//5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGone= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGone.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBack= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBack.isDisplayed());
    }
    @Test
    public void explicitlyWait(){
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //explicitlyWait kullanabilmek icin oncelikle WAIT OBJESI olusturmaliyiz
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        //            4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
      /*  WebElement itsGone= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGone));
        her ne kadar kodun anlasilabilir olmasi icin once locate edelim, bekleyelim yaklasimi guzel gorunse de
        webelement zaten gorunur olmadigindan locate etmemiz de mumkun olmayacaktir
        bu durumda locate ve bekleme islemini beraber yapmak gerektir

       */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        WebElement itsGone= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGone.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]"))) ;
        WebElement itsBack= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBack.isDisplayed());

    }



}
