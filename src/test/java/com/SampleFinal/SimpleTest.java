package com.SampleFinal;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class SimpleTest {
	
	WebDriver driver;
	
	@Severity(SeverityLevel.NORMAL)
	@Description("THis is a very basic test to understand Allure")
	@Step("Step should go into page class along with each method but adding it here just to see {0}")
	@Parameters({"webSite"})
	@Test
	public void doAll(String website) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(website);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, website);
		driver.quit();
	}

}
