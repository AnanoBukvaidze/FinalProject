package ge.aversiclinic.pages;

import ge.aversiclinic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

//LoginPage წარმოადგენს BasePage-ს შვილ კლასს
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private By usernameField = By.id("username");
    private By passwordField = By.id("current-password");
    private By loginButton = By.cssSelector(".login-form__submit.button");

    //მეთოდი ასრულებს დალოგინების ფუნქციონალს
    public void login(String username, String password) {

        //ელოდება usernameField-ის ხილვადობას username-ს გადასცემს
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        enterText(usernameField, username);

        //ელოდება passwordField-ის ხილვადობას და გადასცემს ინფუთს
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        enterText(passwordField, password);

        //აკლიკებს ღილაკს
        clickElement(loginButton);
    }
}


