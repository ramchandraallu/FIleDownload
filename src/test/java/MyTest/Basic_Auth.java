package MyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Basic_Auth {

	@Test
	public void testAuth() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lalitha\\Desktop\\PanduAutomation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	
	}
	
}
