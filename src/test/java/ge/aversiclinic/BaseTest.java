package ge.aversiclinic;

import ge.aversiclinic.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//BaseTest მშობელი კლასია LoginTest-ის
public class BaseTest {
    protected WebDriver driver;

@BeforeMethod
//BeforeMethod ეშვება ყველა მეთოდის წინ, მაქსიმალურად ვაფართოებთ ბრაუზერის ფანჯარას და შევდივართ მოცემულ URL-ზე
    public void setUp(){
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://aversiclinic.ge/login");
    }

@AfterMethod
//ყოველი მეთოდის შესრულების შემდეგ ვხურავთ ვებდრაივერს
    public void teaDown(){
        DriverManager.quit();
    }
}
