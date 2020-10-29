package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LandingPage extends TestBase {

    @FindBy(xpath="//ul[contains(@class,'dropdown')]//li//a")
     List<WebElement> menuOptions;

    @FindBy(xpath= "//ul[@class='rd-navbar-nav']/li[3]")
    WebElement appMenu;

    public LandingPage(){
        super();
    }


    public String getTitle1 ()
    {
        return driver.getTitle();
    }
    public void hoverMenu(String menu){

        String xpath = "//li[contains(@class,'dropdown')]/a[text()='"+menu+"']";
        waitForElementDisplay(By.xpath(xpath));

        WebElement element = driver.findElement(By.xpath(xpath));

        Actions action= new Actions(driver);
        action.moveToElement(element).perform();


    }


    public void verifyDropdownContainsOptionByName(String menuItem) {
     //   System.out.println(menuOptions);
        ArrayList<String> arrayList= new ArrayList<String>();
        for (WebElement e: menuOptions
             ) {
            if(e.isDisplayed()){
                arrayList.add(e.getText());
            }

        }
        Assert.assertTrue(arrayList.contains(menuItem),"Passed "+menuItem);


    }
}
