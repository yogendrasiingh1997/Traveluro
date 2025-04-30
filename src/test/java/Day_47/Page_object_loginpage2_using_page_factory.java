package Day_47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_object_loginpage2_using_page_factory
{
    WebDriver driver;

    //constructor
    public Page_object_loginpage2_using_page_factory(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this); //mandatory
    }


    //locator

    @FindBy (xpath = "//a[@class='clickable'][normalize-space()='Login']")
    WebElement login_btn;

    @FindBy (xpath = "//div[@id='myModalNorm']//input[@id='email']")
    WebElement email_txt;

    @FindBy (xpath = "//div[@id='myModalNorm']//input[@id='password']")
    WebElement pwd_txt;

    @FindBy (xpath = "//div[@id='myModalNorm']//button[@type='submit'][normalize-space()='Login']")
    WebElement submit_btn;


    //Actions

    public void login_btn()
    {
        login_btn.click();
    }

    public  void setUsername(String user)
    {
        email_txt.sendKeys(user);
    }

    public  void setPassword(String pass)
    {
        pwd_txt.sendKeys(pass);
    }

    public  void submitLoginBtn()
    {
        submit_btn.click();
    }
}
