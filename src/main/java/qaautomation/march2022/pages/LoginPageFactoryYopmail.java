package qaautomation.march2022.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageFactoryYopmail extends BasePage {
	@FindBy(xpath = "//input[@id='login']")
	private WebElement email;
	
		
	@FindBy(xpath = "//i[@class='material-icons-outlined f36']")
	private WebElement loginBtn;
	
		
	public LoginPageFactoryYopmail(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}
	
	public void inputUsername(String user) {
		email.sendKeys(user);
	}

	public void clickLoginButton() {
		loginBtn.click();
	}

	
	
}
