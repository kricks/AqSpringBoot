package App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

	static final String BASE_URI = "http://localhost:4200/AquariumBuilder";
	public WebDriver driver;
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

	@Test
	public void getHomePage() {
		driver.get(BASE_URI);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("getStarted")));
	}

	@Test
	public void directToAquariumList() {
		driver.get(BASE_URI);
		driver.findElement(By.id("getStarted")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nameField")));
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
