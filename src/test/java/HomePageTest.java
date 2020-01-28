import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

	static final String BASE_URI = "http://localhost:4200/AquariumBuilder";
	public WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\k.ricks-pennington\\Desktop\\chromedriver.exe");
	}

	@Test
	public void getHomePage() {
		driver.get(BASE_URI);
	}

	@Test
	public void directToAquariumList() {
		driver.get(BASE_URI);
		// Assert.assertTrue(driver.findElement(By.id("getStarted")).click(), BASE_URI);
		driver.findElement(By.id("getStarted")).click();
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
