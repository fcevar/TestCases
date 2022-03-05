import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseActions{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By creditCalcPage = By.xpath("//a[@id='ctl00_ucFooterMenu_rptMain_ctl02_rptChild_ctl00_linkChild']");

    public void OpenCreditCalculation() {
        click(creditCalcPage);
    }
}
