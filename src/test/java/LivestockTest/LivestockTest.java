package LivestockTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LivestockTest {

	// TODO: take out threads and maybe assert something?

	static final String BASE_URI = "http://localhost:4200/AquariumBuilder";
	static final String livestockList = "/livestock-list/295";
	public WebDriver driver;

	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\k.ricks-pennington\\Desktop\\chromedriver.exe");
	}

	@Test(priority = 1)
	public void getLivestockPage() {
		String uri = String.join("", BASE_URI + livestockList);
		driver.get(uri);
	}

	@Test(priority = 2)
	public void clearForm() throws InterruptedException {
		String uri = String.join("", BASE_URI + livestockList);
		driver.get(uri);
		driver.findElement(By.id("nameField")).sendKeys("TESTING");
		driver.findElement(By.id("speciesField")).sendKeys("TESTING FISH");
		driver.findElement(By.id("genderField")).sendKeys("N/A");
		driver.findElement(By.id("notesField")).sendKeys("TESTING");
		Thread.sleep(3000);
		driver.findElement(By.id("clearForm")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void submitForm() throws InterruptedException {
		String uri = String.join("", BASE_URI + livestockList);
		driver.get(uri);
		driver.findElement(By.id("nameField")).sendKeys("TESTING");
		driver.findElement(By.id("speciesField")).sendKeys("TESTING FISH");
		driver.findElement(By.id("genderField")).sendKeys("N/A");
		driver.findElement(By.id("notesField")).sendKeys("TESTING");
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void editLivestock() throws InterruptedException {
		String uri = String.join("", BASE_URI + livestockList);
		driver.get(uri);
		Thread.sleep(3000);
		driver.findElement(By.id("livestockEdit-TESTING")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nameField")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "SELENIUM");
		driver.findElement(By.id("speciesField")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "SELENIUM FISH");
		driver.findElement(By.id("notesField")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "SELENIUM");
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 5)
	public void deleteLivestock() throws InterruptedException {
		String uri = String.join("", BASE_URI + livestockList);
		driver.get(uri);
		Thread.sleep(2000);
		driver.findElement(By.id("livestockDelete-SELENIUM")).click();
	}

	@Test(priority = 6)
	public void directToAquariumListPage() {
		String uri = String.join("", BASE_URI + livestockList);
		driver.get(uri);
		driver.findElement(By.id("aquariumList")).click();
	}

	@Test(priority = 7)
	public void directToHomePage() {
		String uri = String.join("", BASE_URI + livestockList);
		driver.get(uri);
		driver.findElement(By.id("aquariumBuilder")).click();
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
