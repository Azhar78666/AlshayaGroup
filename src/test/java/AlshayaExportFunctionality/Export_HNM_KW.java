package AlshayaExportFunctionality;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import com.AlshayaGroup.TestSetup.TestSetup;
import com.AlshayaGroup.TestUtils.Data;


public class Export_HNM_KW extends TestSetup
{
	
	@Parameters({"URL_HNM_KW"})
	@BeforeClass
	public static void URLLink(String URL) {

		
		currentURL(URL);
		System.out.println("******Export_HNM_KW*******");
	}

	

	@Test(priority = 1, enabled = true)
	public static void HandleThePopUpBox() throws InterruptedException {

		
		waitClick(configProperty.getClosePopUp());
		Boolean check = isElementPresent(configProperty.getClosePopUp());
		Assert.assertTrue(check);

	}

	@Test(priority = 2, enabled = true, dependsOnMethods = "HandleThePopUpBox")
	public static void SignInClick() {

		click(configProperty.getSignIn());

	}
	
	@Test(priority = 3, enabled = true, dependsOnMethods = "SignInClick", dataProviderClass = Data.class, dataProvider = "getDataSimple")
	public static void LoginPage(String Username, String Password) {

		type(configProperty.getUsername(), Username);
		type(configProperty.getPassword(), Password);
		click(configProperty.getSignInBtn());
		
		//driver.findElement(By.xpath("//*[@id='recaptcha-anchor']")).click();
		
	}

	@Test(priority = 4, enabled = true, dependsOnMethods = "LoginPage")
	public static void HomePage() throws IOException {

		click(configProperty.getCommerceLink());
		click(configProperty.getExportLink1());
		click(configProperty.getExportLink2());

	}


	
}
