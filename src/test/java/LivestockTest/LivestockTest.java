package LivestockTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LivestockTest {

	// TODO: take out threads and maybe assert something?

	static final String BASE_URI = "http://localhost:4200/AquariumBuilder";
	static final String livestockList = "/livestock-list/295";
	WebDriver driver;
	WebDriverWait wait;

	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\k.ricks-pennington\\Desktop\\chromedriver.exe");
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void getLivestockPage() {
		String uri = String.join("", BASE_URI + livestockList);
		driver.get(uri);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("notesFieldLS"))));
	}

	@Test(priority = 2, dependsOnMethods = "getLivestockPage")
	public void clearForm() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("notesFieldLS"))));
		driver.findElement(By.id("nameFieldLS")).sendKeys("TESTING");
		driver.findElement(By.id("speciesFieldLS")).sendKeys("TESTING FISH");
		Select gender = new Select(driver.findElement(By.id("genderFieldLS")));
		gender.selectByVisibleText("N/A");
		driver.findElement(By.id("notesFieldLS")).sendKeys("TESTING");

		wait.until(ExpectedConditions.elementToBeClickable((By.id("clearForm"))));
		driver.findElement(By.id("clearForm")).click();
	}

	@Test(priority = 3, dependsOnMethods = "clearForm")
	public void submitForm() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("notesFieldLS"))));
		List<WebElement> original = driver.findElements(By.className("form-control"));

		driver.findElement(By.id("nameFieldLS")).sendKeys("TESTING");
		driver.findElement(By.id("speciesFieldLS")).sendKeys("TESTING FISH");
		Select gender = new Select(driver.findElement(By.id("genderFieldLS")));
		gender.selectByVisibleText("N/A");
		driver.findElement(By.id("notesFieldLS")).sendKeys("TESTING");

		wait.until(ExpectedConditions.elementToBeClickable((By.id("submitButton"))));
		driver.findElement(By.id("submitButton")).click();
		List<WebElement> added = driver.findElements(By.className("form-control"));

		Assert.assertEquals(driver.findElement(By.id("nameFieldLS")).getText(), "TESTING");
		Assert.assertEquals(driver.findElement(By.id("speciesFieldLS")).getText(), "TESTING FISH");
		Assert.assertEquals(driver.findElement(By.id("genderFieldLS")).getText(), "N/A");
		Assert.assertEquals(driver.findElement(By.id("notesFieldLS")).getText(), "TESTING");
		// assert that it was added to aarray
	}

	@Test(priority = 4, dependsOnMethods = "submitForm")
	public void editLivestock() {
		wait.until(ExpectedConditions.elementToBeClickable((By.id("livestockEdit-TESTING"))));
		driver.findElement(By.id("livestockEdit-TESTING")).click();
		List<WebElement> currentValues = driver.findElements(By.id("livestockName-TESTING"));

		driver.findElement(By.id("nameFieldLS")).sendKeys("SELENIUM");
		driver.findElement(By.id("speciesFieldLS")).sendKeys("SELENIUM FISH");
		Select gender = new Select(driver.findElement(By.id("genderFieldLS")));
		gender.selectByVisibleText("N/A");
		driver.findElement(By.id("notesFieldLS")).sendKeys("SELENIUM");

		wait.until(ExpectedConditions.elementToBeClickable((By.id("submitButton"))));
		driver.findElement(By.id("submitButton")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cardName-SELENIUM")));
		List<WebElement> updatedValues = driver.findElements(By.id("aquariumName-SELENIUM"));
		Assert.assertNotEquals(currentValues, updatedValues);
	}

	@Test(priority = 5, dependsOnMethods = "editLivestock")
	public void deleteLivestock() {
		wait.until(ExpectedConditions.elementToBeClickable((By.id("livestockDelete-SELENIUM"))));
		driver.findElement(By.id("livestockDelete-SELENIUM")).click();
		// assert that it was deleted
	}

	@Test(priority = 6, dependsOnMethods = "getLivestockPage")
	public void directToAquariumListPage() {
		wait.until(ExpectedConditions.elementToBeClickable((By.id("aquariumList"))));
		driver.findElement(By.id("aquariumList")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("notesField"))));
	}

	@Test(priority = 7, dependsOnMethods = "getLivestockPage")
	public void directToHomePage() {
		wait.until(ExpectedConditions.elementToBeClickable((By.id("aquariumBuilder"))));
		driver.findElement(By.id("aquariumBuilder")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("getStarted"))));
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
