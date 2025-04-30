package Day_47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_object_loginpage1
{
    WebDriver driver;

    //constructor
    public Page_object_loginpage1(WebDriver driver)
    {
        this.driver=driver;
    }


    //locator

    By btn_login_loc= By.xpath("//a[@class='clickable'][normalize-space()='Login']");
    By txt_username_loc=By.xpath("//div[@id='myModalNorm']//input[@id='email']");
    By txt_password_loc =By.xpath("//div[@id='myModalNorm']//input[@id='password']");
    By btn_submit_login_loc =By.xpath("//div[@id='myModalNorm']//button[@type='submit'][normalize-space()='Login']");


    //Actions

    public void login_btn()
    {
       driver.findElement(btn_login_loc).click();
    }

    public  void setUsername(String user)
    {
        driver.findElement(txt_username_loc).sendKeys(user);
    }

    public  void setPassword(String pass)
    {
        driver.findElement(txt_password_loc).sendKeys(pass);
    }

    public  void submitLoginBtn()
    {
        driver.findElement(btn_submit_login_loc).click();
    }


}
