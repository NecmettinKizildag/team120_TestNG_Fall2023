package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualitydemyPage {

    public QualitydemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement firstLoginLink;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailLoginBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordLoginBox;

    @FindBy(xpath = "//button[@class='btn red radius-5 mt-4 w-100']")
    public WebElement secondLoginLink;

    @FindBy(linkText = "My courses")
    public WebElement myCoursesButton;
}
