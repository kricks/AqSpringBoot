package AquariumTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
	public void getAquariumListPage() throws InterruptedException {
		driver.get(BASE_URI + "/aquarium-list");
		Thread.sleep(1000);
	}

	@Test(priority = 2, dependsOnMethods = "getAquariumListPage")
	public void getAllAquariums() {
		List<WebElement> elements = driver.findElements(By.id("cardName"));

		System.out.println("Size of array: " + elements.size());

		for (WebElement web : elements) {
			System.out.println("Aquarium : " + web.getText());
		}
	}

	@Test(priority = 3, dependsOnMethods = "getAquariumListPage")
	public void clearForm() throws InterruptedException {
		driver.findElement(By.id("nameField")).sendKeys("TESTING");

		Select types = new Select(driver.findElement(By.id("typeField")));
		types.selectByVisibleText("Salt Water");

		driver.findElement(By.id("gallonField")).sendKeys("75");
		driver.findElement(By.id("notesField")).sendKeys("TESTING");
		driver.findElement(By.id("dateField")).sendKeys("01/23/2020");
		Thread.sleep(3000);
		driver.findElement(By.id("clearForm")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 4, dependsOnMethods = "clearForm")
	public void formSubmission() throws InterruptedException {
		driver.findElement(By.id("nameField")).sendKeys("TESTING");
		Select types = new Select(driver.findElement(By.id("typeField")));
		types.selectByVisibleText("Brackish Water");
		driver.findElement(By.id("gallonField")).sendKeys("75");
		driver.findElement(By.id("notesField")).sendKeys("TESTING");
		driver.findElement(By.id("dateField")).sendKeys("01/23/2020");
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).submit();
		Thread.sleep(3000);
	}

	@Test(priority = 5, dependsOnMethods = "formSubmission")
	public void redirectAqConfToAqList() {
		driver.findElement(By.id("backToAqList")).click();
	}

	@Test(priority = 6, dependsOnMethods = "redirectAqConfToAqList")
	public void aquariumEdit() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("aquariumEdit-TESTING")).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("nameField"))).clear();
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("gallonField"))).clear();
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("notesField"))).clear();
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("dateField"))).clear();
		driver.findElement(By.id("nameField")).clear();
		driver.findElement(By.id("gallonField")).clear();
		driver.findElement(By.id("notesField")).clear();
		driver.findElement(By.id("dateField")).clear();

		driver.findElement(By.id("nameField")).sendKeys("SELENIUM");
		Select types = new Select(driver.findElement(By.id("typeField")));
		types.selectByVisibleText("Salt Water");
		driver.findElement(By.id("gallonField")).sendKeys("400");
		driver.findElement(By.id("notesField")).sendKeys("SELENIUM");
		driver.findElement(By.id("dateField")).sendKeys("01/27/2020");
		driver.findElement(By.id("updateButton")).click();
	}

	@Test(priority = 7, dependsOnMethods = "aquariumEdit")
	public void aquariumDelete() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("aquariumDelete-SELENIUM")).click();
	}

	@Test(priority = 8, dependsOnMethods = "getAquariumListPage")
	public void directPageToLivestock() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("view-295")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 9, dependsOnMethods = "getAquariumListPage")
	public void directToHomePage() {
		driver.findElement(By.id("aquariumBuilder")).click();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
