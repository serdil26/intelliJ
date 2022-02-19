package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class DataProvider1 extends TestBase {
    // http://amazon.com adresine gidiniz
// araba, ev, anahtarlik, ayakkabi, gomlek  kelimelerini arayiniz

    @Test(dataProvider = "aranacakUrun")
    public void amazonTest(String kelime){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(kelime+ Keys.ENTER);
    }
    @DataProvider
    public Object[][] aranacakUrun(){
        Object[][] urunler={{"araba"}, {"ev"},{"ayakkabi"},{"anahtarlik"},{"gomlek"}};
        //String [][] urunler={{"araba"}, {"ev"},{"ayakkabi"},{"anahtarlik"},{"gomlek"}}; string turunde de olabilir
        return urunler;
    }

    // https://www.gittigidiyor.com/ adresine gidiniz
// java, javascript ve python kelimelerini arayiniz
    @Test (dataProvider = "aranacakKelimeler")
    public void gittiGidiyorTest(String aranacakKelime){
        driver.get("https://www.gittigidiyor.com");
        driver.findElement(By.xpath("//input[@data-cy='header-search-input']")).sendKeys(aranacakKelime+Keys.ENTER);

    }
    @DataProvider
    public static Object[][] aranacakKelimeler(){
       Object[][] data={{"java"}, {"javascript"},{"python"}};
        return data;
    }

}
