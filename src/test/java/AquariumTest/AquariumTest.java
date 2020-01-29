package AquariumTest;

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

public class AquariumTest {
	// TODO: take out all threads. and add assertions

	static final String BASE_URI = "http://localhost:4200/AquariumBuilder";
	static final String aquariumList = "/aquarium-list";
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
	public void getAquariumListPage() {
		driver.get(BASE_URI + "/aquarium-list");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aquariumList")));
		Assert.assertTrue(driver.getCurrentUrl().equals(BASE_URI + "/aquarium-list"));
	}

	@Test(priority = 2, dependsOnMethods = "getAquariumListPage")
	public void clearForm() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameField")));
		driver.findElement(By.id("nameField")).sendKeys("TESTING");
		Select types = new Select(driver.findElement(By.id("typeField")));
		types.selectByVisibleText("Salt Water");
		driver.findElement(By.id("gallonField")).sendKeys("75");
		driver.findElement(By.id("notesField")).sendKeys("TESTING");
		driver.findElement(By.id("dateField")).sendKeys("01/23/2020");

		driver.findElement(By.id("clearForm")).click();

		List<WebElement> inputFields = driver.findElements(By.className("form-control"));
		for (WebElement web : inputFields) {
			String element = web.getAttribute("value").toString();
			Assert.assertEquals(element, "", "Clear form failed. Expecting empty string.");
		}
	}

	@Test(priority = 3, dependsOnMethods = "clearForm")
	public void isFormInputFieldRequired() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameField")));
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

	// TODO DATE validation with mm/dd/yyyy format

	@Test(priority = 4, dependsOnMethods = "clearForm")
	public void formSubmission() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameField")));

		driver.findElement(By.id("nameField")).sendKeys("TESTING");
		Select types = new Select(driver.findElement(By.id("typeField")));
		types.selectByVisibleText("Brackish Water");
		driver.findElement(By.id("gallonField")).sendKeys("75");
		driver.findElement(By.id("notesField")).sendKeys("TESTING");
		driver.findElement(By.id("dateField")).sendKeys("01/23/2020");

		driver.findElement(By.id("submitButton")).submit();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameConf")));

		Assert.assertEquals(driver.findElement(By.id("nameConf")).getText(), "TESTING");
		Assert.assertEquals(driver.findElement(By.id("typeConf")).getText(), "Brackish Water");
		Assert.assertEquals(driver.findElement(By.id("gallonConf")).getText(), "75");
		Assert.assertEquals(driver.findElement(By.id("notesConf")).getText(), "TESTING");
		Assert.assertEquals(driver.findElement(By.id("dateConf")).getText(), "01/23/2020");

	}

	@Test(priority = 5, dependsOnMethods = "formSubmission")
	public void redirectToAquariumList() {
		driver.findElement(By.id("backToAqList")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameField")));
	}

	@Test(priority = 6, dependsOnMethods = "redirectToAquariumList")
	public void aquariumEdit() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameField")));
		driver.findElement(By.id("aquariumEdit-TESTING")).click();
		List<WebElement> currentValues = driver.findElements(By.id("aquariumName-TESTING"));
		driver.findElement(By.id("nameField")).clear();
		driver.findElement(By.id("nameField")).sendKeys("SELENIUM");
		Select types = new Select(driver.findElement(By.id("typeField")));
		types.selectByVisibleText("Salt Water");
		driver.findElement(By.id("gallonField")).clear();
		driver.findElement(By.id("gallonField")).sendKeys("400");
		driver.findElement(By.id("notesField")).clear();
		driver.findElement(By.id("notesField")).sendKeys("SELENIUM");
		driver.findElement(By.id("dateField")).clear();
		driver.findElement(By.id("dateField")).sendKeys("01/23/2020");
		driver.findElement(By.id("updateButton")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cardName-SELENIUM")));
		List<WebElement> updatedValues = driver.findElements(By.id("aquariumName-SELENIUM"));
		Assert.assertNotEquals(currentValues, updatedValues);
	}

	@Test(priority = 7, dependsOnMethods = "aquariumEdit")
	public void aquariumDelete() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aquariumDelete-SELENIUM")));
		driver.findElement(By.id("aquariumDelete-SELENIUM")).click();
	}

	@Test(priority = 8, dependsOnMethods = "getAquariumListPage")
	public void directPageToLivestock() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("view-295"))));
		driver.findElement(By.id("view-295")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameFieldLS")));

	}

	@Test(priority = 9, dependsOnMethods = "getAquariumListPage")
	public void directToHomePage() {
		driver.findElement(By.id("aquariumBuilder")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("getStarted")));
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
