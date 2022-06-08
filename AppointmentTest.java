import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Intel\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
        loginPage = new LoginPage(driver, driverWait);
        appointmentPage = new AppointmentPage(driver,driverWait);
        summaryPage = new SummaryPage(driver, driverWait);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }

    @Test(priority = 1)
    public void loginTest(){
        loginPage.makeAppointment();
        loginPage.login("John Doe","ThisIsNotAPassword");
        Assert.assertTrue(loginPage.isLoginButtonEnabled());
        loginPage.clickLoginButton();
    }

    @Test(priority = 2)
    public void loginCheckup(){
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    @Test(priority = 3)
    public void makeAppointment(){
        appointmentPage.setAppointment();
        Assert.assertEquals(summaryPage.appointmentSummary(), appointmentPage.appointmentDetails());

    }
}

