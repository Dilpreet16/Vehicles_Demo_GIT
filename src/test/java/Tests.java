import com.objectRepo.GoogleHomePageRepo;
import com.vehicles.Vehicle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Tests {
    private WebDriver driver;
    private String URL = "https://www.google.com";

    public void searchForVehicle(Vehicle myVehicle) {
        driver = OpenGoogle.init();
        driver.get(URL);
        System.out.println("Searching for: " + myVehicle.showName());
        myVehicle.showName();
        driver.findElement(GoogleHomePageRepo.searchBox).sendKeys(myVehicle.showName());
//        driver.findElement(GoogleHomePageRepo.googleSearchBtn).click();

// Using JavaScriptExecutor for performing 'click' operation as the button was not interactable via java/selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", driver.findElement(GoogleHomePageRepo.googleSearchBtn));
        Assert.assertTrue(driver.findElement(By.partialLinkText(myVehicle.showName())).isDisplayed(), "Vehicle '" + myVehicle.showName() + "' not found!!!!");
    }
}