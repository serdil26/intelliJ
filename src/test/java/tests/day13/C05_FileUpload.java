package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {


   // chooseFile butonuna basalim
   // Yuklemek istediginiz dosyayi secelim.



    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //1_file secme butonunu locate edelim
        WebElement dosyaSec= driver.findElement(By.id("file-upload"));
        //2_yukleyecegimiz dosyanin dinamik pathini hazirlayalim
        String dosyaYolu= System.getProperty("user.home")+"\\Desktop\\git github\\selenium.xlsx";

        //3_sendkeys() ile dinamik pathi dosya sec butonuna yollayalim
        dosyaSec.sendKeys(dosyaYolu);
        // Upload butonuna basalim.
        WebElement upload= driver.findElement(By.id("file-submit"));
        upload.click();

        // “File Uploaded!” textinin goruntulendigini test edelim
        WebElement sonucYaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());



        Thread.sleep(5000);
    }


}
