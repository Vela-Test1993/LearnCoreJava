package testNgPractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FacebookTestNgAssertion {
	@Test
	public void logIn() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("email")).sendKeys("rvelu0304@gmail.com");	
		String actualValue = "rvelu0304@gmail.com";
		String expectedValue = driver.findElement(By.id("email")).getAttribute("value");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualValue, expectedValue, "Email");
		driver.findElement(By.id("pass")).sendKeys("velu@123");
		String actualPassword = "velu@123";
				String expectedPassword = driver.findElement(By.id("pass")).getAttribute("value");
		softAssert.assertEquals(actualPassword, expectedPassword, "Password");
		driver.findElement(By.name("login")).click();
		softAssert.assertTrue(driver.findElement(By.name("login")).isDisplayed(), "Login unsuccessful!");
		driver.quit();
		softAssert.assertAll();
	}
}
