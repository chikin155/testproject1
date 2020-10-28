package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {
    public static Properties pro;
    public static WebDriver driver;


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

    public void initalization ()  {
        readProperty();
        System.setProperty("webdriver.chrome.driver","./driver.info/chromedriver");
        driver= new ChromeDriver();
        driver.get(pro.getProperty("url"));
        try{
            Thread.sleep(2000);

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();





    }

}
