package tests;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class EjemploAppium {

    //instanciar nuestro appium driver
    AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setup () throws MalformedURLException {
        //Instanciamos las capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus 6 API 24");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        //inicializamos el driver, ip(localhost, puerto)
        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @Test
    public void primerTest(){
        String numero7 = "digit_7";
        MobileElement me_numero7 = driver.findElement(By.id(numero7));

        String mas = "op_add";
        MobileElement me_mas = driver.findElement(By.id(mas));

        String numero3 = "digit_3";
        MobileElement me_numero3 = driver.findElement(By.id(numero3));

        String igual = "eq";
        MobileElement me_igual = driver.findElement(By.id(igual));

        String resultado = "result";
        MobileElement me_resultado = driver.findElement(By.id(resultado));


        if(me_numero7.isDisplayed()){
            me_numero7.click();
        }else{
            Assert.fail("No se visualiza el numero 7");
        }

        me_mas.click();
        me_numero3.click();
        me_igual.click();

        Assert.assertEquals(me_resultado.getText(), "10");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
