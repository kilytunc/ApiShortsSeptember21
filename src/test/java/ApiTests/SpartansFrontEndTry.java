package ApiTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpartansFrontEndTry {

    @Test
    public void deleteDuplicateSpartanTry () throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://54.205.239.177:8000/spartans");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(32, TimeUnit.SECONDS);     // when you set it up one time this method will work next all location action
        // this method keeps trying until the time ends which i gave than if couldnt find than throws NSE (FINDELEMENT METHODS CHECKS THAT IS THERE ANY IMPLICIT WAIT OR N


        String deleteName = "Mikee";   // give the instance name to delete HARDCODED or !!! read all the table and detect all duplicates to alist than make a loop for deleting function

        List<WebElement> duplicates = driver.findElements(By.xpath("//*[.='"+deleteName+"']/../td/a[contains(@id,'delete_spartan_')]"));
        System.out.println("elements.size() = " + duplicates.size());
        int loopTimes = duplicates.size();



        // i had stale element exception thats wyh the page is refreshing each time after delete button clicked
        // so im trying to make my loop as the duplicate size
        for (int i = 0; i < loopTimes - 1; i++) {
            Thread.sleep(2000);
             driver.findElement(By.xpath("//*[.='"+deleteName+"']/../td/a[contains(@id,'delete_spartan_')]")).click();

        }


        List<WebElement> checkOutList = driver.findElements(By.xpath("//*[.='" + deleteName + "']/../td/a[contains(@id,'delete_spartan_')]"));
        Assert.assertEquals(checkOutList.size(),1, "verify that there is only one -- which is probably the last created one is left ... ");
        driver.quit();

    }

}
