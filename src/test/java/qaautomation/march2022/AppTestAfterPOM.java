package qaautomation.march2022;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.march2022.pages.LoginPage;
import qaautomation.march2022.pages.ProfilePage;

/**
 * Unit test for simple App.
 */
public class AppTestAfterPOM extends BaseWebTest {

	LoginPage loginPage = new LoginPage(driver, explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);

	// karena semua extends dari BaseWebTest maka semua driver mesti menggunakan
	// driver.get()
	@Test
	public void test() {
		String username = "tomsmith";
		String password = "SuperSecretPassword!";

		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();

		String actualText = profilePage.getProfileText();

		String expectedText = "You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
	}

	@Test
	public void test2() {
		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
				
//		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys(username);
//		driver.get().findElement(By.id("password")).sendKeys(password);
//		String actualText = driver.get().findElement(By.xpath("//h2[normalize-space()='Login Page']")).getText();
	
		String actualText = loginPage.getLoginBanner();
		String expectedText = "Login Page";
		Assert.assertTrue(actualText.contains(expectedText));
	}

	@Test
	public void test3() {
		String username = "tomsmith";
		String password = "SuperSecretPassword!!!!";
		
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		
//		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys(username);
//		driver.get().findElement(By.id("password")).sendKeys(password);
//		String actualText = driver.get().findElement(By.xpath("//h2[normalize-space()='Login Page']")).getText();
		
		String actualText = profilePage.getProfileText();
		String expectedText = "Your password is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));
	}
}
