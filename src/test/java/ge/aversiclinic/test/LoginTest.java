package ge.aversiclinic.test;

import ge.aversiclinic.BaseTest;
import ge.aversiclinic.pages.AversiPage;
import ge.aversiclinic.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest extends BaseTest{

    @Test
    //ტესტ ქეისი ამოწმებს ვალიდური მონაცემებით თუ ლოგინდება იუზერი და სწორ გვერდზე თუა გადამისამართებული დალოგინების შემდეგ
    public void validLogin(){

        //შეგვყავს ვალიდური მონაცემები
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("bukvaidzeanano@gmail.com","Anano2025");

        //ვიცდით დალოგინების შემდეგ რომ ელემენტი რომლითაც გვერდის სისწორეს ვამოწმებთ ჩაიტვირთოს
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("pr-sidebar-link__text")));

        //დალოგინების შემდეგ ვამოწმებთ URL-ს, თუ რამდენად სწორად ვართ გადამისამართებული გვერდზე
        String expectedURL = "https://aversiclinic.ge/pr-visit-doctor/current";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectedURL));
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "არასწორი ვებ-მისამართი");

        //შიდა გვერდზე ვამოწმებთ კონკრეტულ ელემენტს რომელიც ასევე ადასტურებს რომ სწორ გვერდზე ვართ გადამისამართებული
        AversiPage aversiPage = new AversiPage(driver);
        String expectedText = "ექიმთან ვიზიტი";
        String actualText = aversiPage.getAversiPageText();
        Assert.assertEquals(actualText, expectedText, "არასწორი ტექსტი");
    }

    @Test
    //ტესტქეისი ამოწმებს არასწორი ელ-ფოსტით და სწორი პაროლით დალოგინებისას სწორი ერორ-მესიჯი გამოდის თუ არა
    public void invalidEmailLogin(){

        //შეგვყავს არასწორი ელ-ფოსტა და სწორი პაროლი
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("abukva@gmail.com","Anano2025");

        //ველოდებით ერორ-მესიჯის გამოსვლას
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text-input-error-message")));

        //ვამოწმებთ სწორი ერორ მესიჯი გამოვიდა თუ არა
        String expectedErrorMessage = "ელ-ფოსტა ან პაროლი არასწორია";
        String actualErrorMessage = driver.findElement(By.className("text-input-error-message")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "ერორ მესიჯი არასწორია");
    }

    @Test
    //ტესტქეისი ამოწმებს სწორი ელ-ფსტით და არასწორი პაროლით დალოგინების შემთხვევაში სწორად გამოდის თუარა ერორ-მესიჯი
    public void invalidPasswordLogin(){

        //შეგვყავს სწორი ელ-ფოსტა და არასწორი პაროლი
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("bukvaidzeanano@gmail.com","AnanoAnano");

        //ველოდებით ერორ-მესიჯის გამოსვლას
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text-input-error-message")));

        //ვამოწმებთ სწორი ერორ მესიჯი გამოვიდა თუ არა
        String expectedErrorMessage = "ელ-ფოსტა ან პაროლი არასწორია";
        String actualErrorMessage = driver.findElement(By.className("text-input-error-message")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "ერორ მესიჯი არასწორია");
    }

    @Test
// ტესტქეისი ამოწმებს ცარიელი ველებით დალოგინების ფუნქციონალს, სწორად გამოდის თუარა ვალიდაციის შეტყობინება
    public void emptyLoginFields() {

        //ელ-ფოსტის და პაროლის ველს ვტოვებთ ცარიელს
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");

        //ველოდებით ვალიდაციის შეტყობინების გამოსვლას
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".text-input-error-message.mb-40")));

        //ვამოწმებთ ვალიდაციის შეტყობინების სისწორეს
        String expectedEmailErrorMessage = "გთხოვთ მიუთითოთ ვალიდური მეილი";
        String actualEmailErrorMessage = driver.findElement(By.cssSelector(".text-input-error-message.mb-40")).getText();
        Assert.assertEquals(actualEmailErrorMessage, expectedEmailErrorMessage, "ვალიდაციის შეტყობინება არასწორია");

    }

    @Test
    //ტესტქეისი ამოწმებს ცარიელი ელ-ფოსტის ველით და სწორი პაროლით დალოგინებისას გამოსულ ერორ-მესიჯს
    public void emptyEmailField() {

        //ელ-ფოსტის ველს ვტოვებთ ცარიელს და პაროლის ველში შეგვყავს სწორი პაროლი
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "Anano2025");

        //ველოდებით ერორ-მესიჯის გამოსვლას
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".text-input-error-message.mb-40")));

        //ვამოწმებთ შეტყობინების სისწორეს
        String expectedEmailErrorMessage = "გთხოვთ მიუთითოთ ვალიდური მეილი";
        String actualEmailErrorMessage = driver.findElement(By.cssSelector(".text-input-error-message.mb-40")).getText();
        Assert.assertEquals(actualEmailErrorMessage, expectedEmailErrorMessage, "ვალიდაციის შეტყობინება არასწორია");
    }

}
