package AquariumTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AquariumTest {
	// TODO: take out all threads. and add assertions

	static final String BASE_URI = "http://localhost:4200/AquariumBuilder";
	static final String aquariumList = "/aquarium-list";
	public WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\k.ricks-pennington\\Desktop\\chromedriver.exe");
	}

	@Test(priority = 1)
	public void getAquariumListPage() {
		driver.get(BASE_URI + "/aquarium-list");
	}

	@Test(priority = 2)
	public void getAllAquariums() {
		String uri = String.join("", BASE_URI + aquariumList);
		driver.get(uri);
		List<WebElement> elements = driver.findElements(By.id("cardName"));

		System.out.println("Size of array: " + elements.size());

		for (WebElement web : elements) {
			System.out.println("Aquarium : " + web.getText());
		}

	}

	@Test(priority = 3)
	public void clearForm() throws InterruptedException {
		String uri = String.join("", BASE_URI + aquariumList);
		driver.get(uri);
		driver.findElement(By.id("nameField")).sendKeys("TESTING");
		driver.findElement(By.id("typeField")).sendKeys("Fresh Water");
		driver.findElement(By.id("gallonField")).sendKeys("75");
		driver.findElement(By.id("notesField")).sendKeys("TESTING");
		driver.findElement(By.id("dateField")).sendKeys("01/23/2020");
		Thread.sleep(3000);
		driver.findElement(By.id("clearForm")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void formSubmission() throws InterruptedException {
		String uri = String.join("", BASE_URI + aquariumList);
		driver.get(uri);
		driver.findElement(By.id("nameField")).sendKeys("TESTING");
		driver.findElement(By.id("typeField")).sendKeys("Fresh Water");
		driver.findElement(By.id("gallonField")).sendKeys("75");
		driver.findElement(By.id("notesField")).sendKeys("TESTING");
		driver.findElement(By.id("dateField")).sendKeys("01/23/2020");
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).submit();
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void aquariumEdit() throws InterruptedException {
		String uri = String.join("", BASE_URI + aquariumList);
		driver.get(uri);
		Thread.sleep(3000);
		driver.findElement(By.id("aquariumEdit-TESTING")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nameField")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "SELENIUM");
		driver.findElement(By.id("typeField")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "Salt Water");
		driver.findElement(By.id("gallonField")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "400");
		driver.findElement(By.id("notesField")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "SELENIUM");
		driver.findElement(By.id("dateField")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "01/27/2020");
		Thread.sleep(3000);
		driver.findElement(By.id("updateButton")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 6)
	public void aquariumDelete() throws InterruptedException {
		String uri = String.join("", BASE_URI + aquariumList);
		driver.get(uri);
		Thread.sleep(2000);
		driver.findElement(By.id("aquariumDelete-SELENIUM")).click();
	}

	@Test(priority = 7)
	public void directPageToLivestock() throws InterruptedException {
		String uri = String.join("", BASE_URI + aquariumList);
		driver.get(uri);
		Thread.sleep(2000);
		driver.findElement(By.id("view-295")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 8)
	public void directToHomePage() {
		String uri = String.join("", BASE_URI + aquariumList);
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
