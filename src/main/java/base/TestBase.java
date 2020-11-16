package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {
    private static Properties pro;
    protected static  WebDriver driver;
    public TestBase(){

        readProperty();
        System.setProperty("webdriver.chrome.driver","./driver.info/chromedriver.exe");
        driver= new ChromeDriver();
        PageFactory.initElements(driver,this);
        driver.get(pro.getProperty("url"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    // Read file property
    public void readProperty (){
        pro = new Properties();
        InputStream input=null;
        try {
            input = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
            pro.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e){
                e.printStackTrace();

            }
        }

    }

    public void waitForElementDisplay(By xpath){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

    }


}
