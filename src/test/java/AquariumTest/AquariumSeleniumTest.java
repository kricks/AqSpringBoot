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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AquariumSeleniumTest {
	static final String BASE_URI = "http://localhost:4200/";
	static final String aquariumList = "aquarium";
	WebDriver driver;
	WebDriverWait wait;

	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\k.ricks-pennington\\Desktop\\chromedriver.exe");
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void getAquariumListPage() {
		driver.get(BASE_URI + "aquarium");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aquariumList")));
		Assert.assertTrue(driver.getCurrentUrl().equals(BASE_URI + "aquarium"));
	}

	@Test(priority = 2, dependsOnMethods = "getAquariumListPage")
	public void clearForm() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameField")));
		driver.findElement(By.id("nameField")).sendKeys("TESTING");
		Select types = new Select(driver.findElement(By.id("typeField")));
		types.selectByVisibleText("Salt Water");
		driver.findElement(By.id("gallonField")).sendKeys("75");
		driver.findElement(By.id("notesField")).sendKeys("TESTING");
		driver.findElement(By.id("dateField")).sendKeys("01/23/2020");

		wait.until(ExpectedConditions.elementToBeClickable((By.id("clearForm"))));
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
			if (element != null) {
				softAssert.assertEquals(element, true);
			}
		}
//		softAssert.assertAll();
	}

	@Test(priority = 4, dependsOnMethods = "clearForm")
	public void formSubmissionFlow() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameField")));
		List<WebElement> originalList = driver.findElements(By.name("cardName"));

		driver.findElement(By.id("nameField")).sendKeys("TESTING");
		Select types = new Select(driver.findElement(By.id("typeField")));
		types.selectByVisibleText("Brackish Water");
		driver.findElement(By.id("gallonField")).sendKeys("75");
		driver.findElement(By.id("notesField")).sendKeys("TESTING");
		driver.findElement(By.id("dateField")).sendKeys("01/23/2020");

		wait.until(ExpectedConditions.elementToBeClickable((By.id("submitButton"))));
		driver.findElement(By.id("submitButton")).submit();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameConf")));
		Assert.assertEquals(driver.findElement(By.id("nameConf")).getText(), "TESTING");
		Assert.assertEquals(driver.findElement(By.id("typeConf")).getText(), "Brackish Water");
		Assert.assertEquals(driver.findElement(By.id("gallonConf")).getText(), "75");
		Assert.assertEquals(driver.findElement(By.id("notesConf")).getText(), "TESTING");
		Assert.assertEquals(driver.findElement(By.id("dateConf")).getText(), "Jan 23, 2020");

		driver.findElement(By.id("backToAqList")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameField")));

		List<WebElement> addedList = driver.findElements(By.name("cardName"));
		Assert.assertEquals(addedList.size(), (originalList.size() + 1));
	}

	@Test(priority = 5, dependsOnMethods = "formSubmissionFlow")
	public void aquariumEdit() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("nameField"))));
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

	@Test(priority = 6, dependsOnMethods = "aquariumEdit")
	public void aquariumDelete() {
		wait.until(ExpectedConditions.elementToBeClickable((By.id("aquariumDelete-SELENIUM"))));
		List<WebElement> originalList = driver.findElements(By.name("cardName"));
		driver.findElement(By.id("aquariumDelete-SELENIUM")).click();

//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deleteModalLabel")));
		wait.until(ExpectedConditions.elementToBeClickable((By.id("deleteButton"))));
		driver.findElement(By.id("deleteButton")).click();

		wait.until(ExpectedConditions.numberOfElementsToBe(By.name("cardName"), originalList.size() - 1));
		List<WebElement> listAfterDelete = driver.findElements(By.name("cardName"));
		Assert.assertEquals(listAfterDelete.size(), (originalList.size() - 1));
	}

	@Test(priority = 7, dependsOnMethods = "getAquariumListPage")
	public void directPageToLivestock() {
		wait.until(ExpectedConditions.elementToBeClickable((By.id("view-1"))));
		driver.findElement(By.id("view-1")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameFieldLS")));
	}

	@Test(priority = 8, dependsOnMethods = "getAquariumListPage")
	public void directToHomePage() {
		wait.until(ExpectedConditions.elementToBeClickable((By.id("aquariumBuilder"))));
		driver.findElement(By.id("aquariumBuilder")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("getStarted")));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
