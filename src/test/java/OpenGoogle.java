import com.vehicles.Airplane;
import com.vehicles.Bike;
import com.vehicles.Car;
import com.vehicles.Scooter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {

    private static WebDriver driver;
    private static Tests tests = new Tests();
    private static Airplane airplane = new Airplane();
    private static Bike bike = new Bike();
    private static Car car = new Car();
    private static Scooter scooter = new Scooter();

    public static void main(String[] args) {
        System.out.println("Calling init method for opening www.google.com and searching for Bike....");
        OpenGoogle.init();
        tests.searchForVehicle(airplane);
        tests.searchForVehicle(bike);
        tests.searchForVehicle(car);
        tests.searchForVehicle(scooter);
    }

    public static WebDriver init() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C://Users//dilsingh3//Downloads//chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}