import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;

public abstract class Base {

    private WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    protected void loginWeb() {
        driver.get("https://www.google.com");
    }

    @BeforeClass //The annotated method will be run before the first test method in the current class is invoked.
    protected void before() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod // The annotated method will be run before each test method.
    protected void beforeTest() {
        driver = new ChromeDriver();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginWeb();
        getDriver().manage().window().maximize();
    }

    @AfterMethod //The annotated method will be run after each test method.
    protected  void afterTest() {
        getDriver().quit();
    }

}

