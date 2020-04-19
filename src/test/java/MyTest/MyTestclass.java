package MyTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTestclass {
	WebDriver driver;
	public File Folder;
	@BeforeMethod
	public void before() {
		Folder = new File(UUID.randomUUID().toString());
		Folder.mkdir();
		System.out.println(Folder.getAbsolutePath());
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lalitha\\Desktop\\PanduAutomation\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String,Object> prefs = new HashMap<String,Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", Folder.getAbsolutePath());
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		 driver = new ChromeDriver(cap);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/download");
	}
	
	@AfterMethod
	public void After() {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.partialLinkText("gund")).click();
		Thread.sleep(5000);
		File ListofFiles[]= Folder.listFiles();
		for(File file: ListofFiles) {
			System.out.println(file.getName());
		}
	}
}
