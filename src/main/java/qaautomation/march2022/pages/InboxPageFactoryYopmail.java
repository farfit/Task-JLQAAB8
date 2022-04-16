package qaautomation.march2022.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPageFactoryYopmail extends BasePage {
	@FindBy(xpath = "(//iframe[@id='ifmail'])[1]")
	private WebElement firstMessage;
	
	@FindBy(xpath = "(//div[@class='bname'])[1]")
	private WebElement userEmail;
	
	@FindBy(xpath = "(//span[@class='lmf'][normalize-space()='Zenfolio'])[1]")
	private WebElement listFirstMessage;

	

	public InboxPageFactoryYopmail(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	
	public String getUserEmail() {
		return userEmail.getText();
	}
	
	public String getFirstMessage() {
		return firstMessage.getText();
	}
	
	public void clickListFirstMsg() {
		listFirstMessage.click();
	}
}
