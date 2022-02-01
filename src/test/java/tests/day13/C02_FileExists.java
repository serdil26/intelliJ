package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home"));

      //   masaustundeki github klasorunun pathini istersek
      //  C:\Users\Toto\Desktop\git github\selenium.xlsx


     //yani dinamik olarak masaustundeki klasoru yazdirmak icin
        String path= System.getProperty("user.home")+"\\Desktop\\git github\\";
        System.out.println(path); //C:\Users\Toto\Desktop\git github\
        System.out.println("user.dir :" + System.getProperty("user.dir"));

        //masaustunde git github klasoru icinde selenium.xlsx isminde bir dosya oldugunu test edin

        //1-once bu dosyaya ulasmak icin gerekli dinamik path olusturun

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\git github\\selenium.xlsx\\";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        //projemizde pom.xml oldugunu test edin
        //C:\Users\Toto\IdeaProjects\com.TestNGbatch44\pom.xml

        System.out.println(System.getProperty("user.dir")); // projemin yolunu verir

        String pomPath=System.getProperty("user.dir") + "\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pomPath)));




    }
}
