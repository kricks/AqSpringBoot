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
import org.testng.asserts.SoftAssert;

public class LivestockSeleniumTest {
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
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("nameFieldLS"))));
		WebElement name = driver.findElement(By.id("nameFieldLS"));
		name.sendKeys("TESTING");
		driver.findElement(By.id("speciesFieldLS")).sendKeys("TESTING FISH");
		Select gender = new Select(driver.findElement(By.id("genderFieldLS")));
		gender.selectByVisibleText("N/A");
		driver.findElement(By.id("notesFieldLS")).sendKeys("TESTING");
		wait.until(ExpectedConditions.elementToBeClickable((By.id("clearForm"))));
		driver.findElement(By.id("clearForm")).click();
		List<WebElement> inputFields = driver.findElements(By.className("form-control"));
		for (WebElement web : inputFields) {
			String element = web.getAttribute("value").toString();
			Assert.assertEquals(element, "", "Clear form failed. Expecting empty string.");
		}
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBeNotEmpty(name, "nameFieldLS")));
	}

	@Test(priority = 3, dependsOnMethods = "clearForm")
	public void isFormInputFieldRequired() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameFieldLS")));
		SoftAssert softAssert = new SoftAssert();

		List<WebElement> inputFields = driver.findElements(By.className("form-control"));
		for (WebElement web : inputFields) {
			String element = web.getAttribute("required");
			String fieldName = web.getAttribute("id").toString();
			if (element != null) {
				System.out.println("This field, " + fieldName + ", is required : " + element);
				softAssert.assertEquals(element, true);
			}
		}
	}

	@Test(priority = 4, dependsOnMethods = "clearForm")
	public void submitForm() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("notesFieldLS"))));
		List<WebElement> originalArray = driver.findElements(By.id("livestockName-TESTING"));
		driver.findElement(By.id("nameFieldLS")).sendKeys("TESTING");
		driver.findElement(By.id("speciesFieldLS")).sendKeys("TESTING FISH");
		Select gender = new Select(driver.findElement(By.id("genderFieldLS")));
		gender.selectByVisibleText("N/A");
		driver.findElement(By.id("notesFieldLS")).sendKeys("TESTING");
		wait.until(ExpectedConditions.elementToBeClickable((By.id("submitButton"))));
		driver.findElement(By.id("submitButton")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("livestockName-TESTING"))));
		List<WebElement> addedLivestock = driver.findElements(By.id("livestockName-TESTING"));

		for (WebElement web : addedLivestock) {
			Assert.assertEquals(web.findElement(By.id("nameValue")).getText(), "TESTING");
			Assert.assertEquals(web.findElement(By.id("speciesValue")).getText(), "TESTING FISH");
			Assert.assertEquals(web.findElement(By.id("genderValue")).getText(), "N/A");
			Assert.assertEquals(web.findElement(By.id("notesValue")).getText(), "TESTING");
		}
		Assert.assertTrue(addedLivestock.size() == originalArray.size() + 1);
	}

	@Test(priority = 5, dependsOnMethods = "submitForm")
	public void editLivestock() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("livestockEdit-TESTING"))));
		driver.findElement(By.id("livestockEdit-TESTING")).click();
		List<WebElement> currentValues = driver.findElements(By.id("livestockName-TESTING"));
		driver.findElement(By.id("nameFieldLS")).clear();
		driver.findElement(By.id("nameFieldLS")).sendKeys("SELENIUM");
		driver.findElement(By.id("speciesFieldLS")).clear();
		driver.findElement(By.id("speciesFieldLS")).sendKeys("SELENIUM FISH");
		Select gender = new Select(driver.findElement(By.id("genderFieldLS")));
		gender.selectByVisibleText("N/A");
		driver.findElement(By.id("notesFieldLS")).clear();
		driver.findElement(By.id("notesFieldLS")).sendKeys("SELENIUM");
		wait.until(ExpectedConditions.elementToBeClickable((By.id("submitButton"))));
		driver.findElement(By.id("submitButton")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("livestockName-SELENIUM"))));
		List<WebElement> updatedValues = driver.findElements(By.id("livestockName-SELENIUM"));
		Assert.assertNotEquals(currentValues, updatedValues);
	}

	@Test(priority = 6, dependsOnMethods = "editLivestock")
	public void deleteLivestock() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("livestockDelete-SELENIUM"))));
		List<WebElement> originalArray = driver.findElements(By.name("repeat"));
		driver.findElement(By.id("livestockDelete-SELENIUM")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.name("repeat"))));
		List<WebElement> updatedArray = driver.findElements(By.name("repeat"));
		Integer size = originalArray.size() - updatedArray.size();
		Assert.assertTrue(size == 1);
	}

	@Test(priority = 7, dependsOnMethods = "getLivestockPage")
	public void directToAquariumListPage() {
		wait.until(ExpectedConditions.elementToBeClickable((By.id("aquariumList"))));
		driver.findElement(By.id("aquariumList")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("nameField"))));
	}

	@Test(priority = 8, dependsOnMethods = "getLivestockPage")
	public void directToHomePage() {
		wait.until(ExpectedConditions.elementToBeClickable((By.id("aquariumBuilder"))));
		driver.findElement(By.id("aquariumBuilder")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("getStarted"))));
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
