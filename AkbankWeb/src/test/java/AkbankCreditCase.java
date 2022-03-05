import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AkbankCreditCase extends BaseTest {

    HomePage homePage;
    CreditCalculationPage creditCalculationPage;


    @Test
    public void calculationCredit() throws InterruptedException {
        homePage = new HomePage(driver);
        creditCalculationPage = new CreditCalculationPage(driver);
        homePage.OpenCreditCalculation();
        creditCalculationPage.calculator("50000", "uninsured", 20);
        Assertions.assertEquals(creditCalculationPage.checkCostArea(), "Masraf ve Maliyet Oranları");
        creditCalculationPage.showPaymentPlan();

    }

}
