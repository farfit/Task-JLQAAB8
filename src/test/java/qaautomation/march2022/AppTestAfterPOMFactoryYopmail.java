package qaautomation.march2022;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.march2022.pages.CommonPage;
import qaautomation.march2022.pages.InboxPageFactoryYopmail;
import qaautomation.march2022.pages.LoginPage;
import qaautomation.march2022.pages.LoginPageFactory;
import qaautomation.march2022.pages.LoginPageFactoryYopmail;
import qaautomation.march2022.pages.ProfilePage;
import qaautomation.march2022.pages.ProfilePageFactory;

/**
 * Unit test for simple App.
 */
public class AppTestAfterPOMFactoryYopmail extends BaseWebYopmail {

//	LoginPage loginPage = new LoginPage(driver, explicitWait);
//	ProfilePage profilePage = new ProfilePage(driver, explicitWait);
	

	// karena semua extends dari BaseWebTest maka semua driver mesti menggunakan
	// driver.get()
	@Test
	public void getFirstMessage() {
		LoginPageFactoryYopmail loginPageYopmail = new LoginPageFactoryYopmail(driver, explicitWait);
		InboxPageFactoryYopmail inboxPageYopmail = new InboxPageFactoryYopmail(driver, explicitWait);
		CommonPage commonPage = new CommonPage(driver, explicitWait);
		
		String username = "automationtest";
		
		loginPageYopmail.inputUsername(username);
		loginPageYopmail.clickLoginButton();
		inboxPageYopmail.clickListFirstMsg();
//		commonPage.switchIFrame("//iframe[@id='ifinbox'");
		

//		String actualText = inboxPageYopmail.getFirstMessage();	
//		String expectedText = "Looking Forward";
//		Assert.assertTrue(actualText.contains(expectedText));
	}

}
