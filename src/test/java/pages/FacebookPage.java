package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emaiLoginBox;

    @FindBy(id = "pass")
    public WebElement passwordLoginBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@class='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")
    public WebElement cookiesAllow;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement loginFailedTextElement;
}
