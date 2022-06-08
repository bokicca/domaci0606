import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SummaryPage extends AppointmentPage {
    private By facility = By.id("facility");
    private By readmission = By.id("hospital_readmission");
    private By program = By.id("program");
    private By date = By.id("visit_date");
    private By comment = By.id("comment");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFacility() {
        return facility;
    }

    public By getReadmission() {
        return readmission;
    }

    public By getProgram() {
        return program;
    }

    public By getDate() {
        return date;
    }

    @Override
    public By getComment() {
        return comment;
    }

    public String appointmentSummary(){
        WebElement summaryDetails = getDriver().findElement(By.id("summary"));
        List<String> elementsList = new ArrayList<>();
        return String.valueOf(elementsList.add(summaryDetails.getText()));
    }
}