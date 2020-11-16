import org.junit.Test;
import org.testng.Assert;
import pages.LandingPage;

public class main {


        String titleExpected="#1 Free CRM customer relationship management software cloud";
        String actualTitle;

        LandingPage landing = new LandingPage();


    @Test
    public void testTitle (){

        actualTitle =  landing.getTitle1();
        Assert.assertEquals(actualTitle,titleExpected,"Title unmatched");
        landing.hoverMenu("Apps");
        landing.verifyDropdownContainsOptionByName("Android");
        landing.verifyDropdownContainsOptionByName("iPhone");

    }

   @Test
    public void test(){
        Assert.assertEquals(1,1,"Test passed");

   }




}
