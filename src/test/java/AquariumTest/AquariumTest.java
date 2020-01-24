package AquariumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AquariumTest {

	static final String BASE_URI = "http://localhost:4200/AquariumBuilder";
	public WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\k.ricks-pennington\\Desktop\\chromedriver.exe");
	}

	@Test(enabled = false)
	public void getHomePage() {
		driver.get(BASE_URI);
	}

	@Test
	public void formSubmission() throws InterruptedException {
		String uri = String.join("", BASE_URI + "/aquarium-list");
		driver.get(uri);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#name")));

		driver.findElement(By.id("name")).sendKeys("TESTING");
		driver.findElement(By.id("type")).sendKeys("Fresh Water");
		driver.findElement(By.id("gallon")).sendKeys("100");
		driver.findElement(By.id("notes")).sendKeys("TESTING");
		driver.findElement(By.id("date")).sendKeys("01/23/2020");
		driver.findElement(By.id("submitButton")).submit();
	}

	@Test(enabled = false)
	public void clearForm() throws InterruptedException {
		String uri = String.join("", BASE_URI + "/aquarium-list");
		driver.get(uri);
		driver.findElement(By.id("name")).sendKeys("TESTING");
		driver.findElement(By.id("type")).sendKeys("Fresh Water");
		driver.findElement(By.id("gallon")).sendKeys("100");
		driver.findElement(By.id("notes")).sendKeys("TESTING");
		driver.findElement(By.id("date")).sendKeys("01/23/2020");
		Thread.sleep(5000);
		driver.findElement(By.id("clearForm")).click();
		Thread.sleep(5000);
	}

	@Test(enabled = false)
	public void aquariumEdit() {

	}

	@Test(enabled = false)
	public void aquariumDelete() throws InterruptedException {
		String uri = String.join("", BASE_URI + "/aquarium-list");
		driver.get(uri);
		Thread.sleep(5000);
		driver.findElement(By.id("aquarium-TESTING")).click();
		Thread.sleep(5000);
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
