package ge.aversiclinic;

import ge.aversiclinic.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//მშობელი კლასი AversiPage და LoginPage-თვის
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //მეთოდი უზრუნველყოფს ტექსტის შეყვანას კონკრეტულ ინფუთ ველში
    public void enterText(By locator, String text){
        driver.findElement(locator).sendKeys(text);

        //ლოგავს ინფორმაციას თუ რომელ ელემენტს რა გადავეცით
        Utils.log("მოვძებნე ელემენტი: [ " + locator + " ] გადავეცი: " + text);
    }

    //მეთოდი უზრუნველყოფს დაკლიკვას კონკრეტულ ელემენტზე
    public void clickElement(By locator){
        driver.findElement(locator).click();

        //ლოგავს ინფორმაციას თუ რომელ ელემენტს დავაკლიკეთ
        Utils.log("დავაკლიკე ელემენტს: [ " + locator + " ] ");
    }

    //მეთოდი პოულობს კონკრეტული ემენტის ტექსტს
    public String getElementText(By locator){

        //ლოგავს ინფორმაციას თუ რომელ ელემენტს აბრუნებს ფუნქცია
        Utils.log("ვეძებ ელემენტის ტექსტს: [ " + locator + " ] ");

        return driver.findElement(locator).getText();
    }
}
