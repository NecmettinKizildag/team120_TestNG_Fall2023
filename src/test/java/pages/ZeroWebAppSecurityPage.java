package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebAppSecurityPage {

    public ZeroWebAppSecurityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement loginBox;

    @FindBy(id = "user_password")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    public WebElement signInButton2;

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankingMenuButton;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsLink;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrencyButton;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropDownMenu;


}
