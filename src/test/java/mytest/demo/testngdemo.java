package mytest.demo;

import java.io.File;
import java.io.IOException;

import org.apache.http.util.Asserts;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import static org.testng.AssertJUnit.assertEquals;
public class testngdemo {
	private static WebDriver driver = null;
	private static FirefoxProfile firefoxprofile = null;

	@Test
	public void startFirefox() throws Exception {
		System.out.println("this is a test begin~~~~");
		System.setProperty("webdriver.firefox.bin", "E:/Program Files/firefox/firefox.exe");
		File firebug = new File("E:/toolkit/selenium/firebug-2.0.7-fx.xpi");
		File firepath = new File("E:/toolkit/selenium/firepath-0.9.7-fx.xpi");
		firefoxprofile = new FirefoxProfile();
		try {
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firepath);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", true);
			firefoxprofile.setPreference("extensions.firebug.currentversion", "2.0.7");
			firefoxprofile.setPreference("extensions.firebug.allPagesActivation", "on");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = new FirefoxDriver(firefoxprofile);
		if (driver != null) {
			System.out.println("driver is not null");

		}
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		assertEquals("百度一下，你就知道",driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
		// add by bingo 2016-06-28
	}
}
