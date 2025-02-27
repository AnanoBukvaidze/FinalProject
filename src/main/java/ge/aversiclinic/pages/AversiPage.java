package ge.aversiclinic.pages;

import ge.aversiclinic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//AversiPage წარმოადგენს BasePage-ს შვილ კლასს
public class AversiPage extends BasePage {

    public AversiPage(WebDriver driver){
        super(driver);
    }

    private By aversiPageText= By.className("pr-sidebar-link__text");

    //მეთოდი აბრუნებს ელემენტის/ლოკატორის ტექსტს
    public String getAversiPageText(){
        return getElementText(aversiPageText);
    }
}
