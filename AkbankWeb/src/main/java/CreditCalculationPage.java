import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CreditCalculationPage extends BaseActions {

    By calculateArea = By.xpath("//div[@class='content']");
    By loanAmount = By.xpath("//input[@id='t-credit-price']");
    By uninsuredChoice = By.xpath("//a[@objname='radio-rdinsured3']//label[@for='insuredType2']");
    By slider = By.xpath("//div[@id='t-credit-vade']");
    By detailCalc = By.xpath("//a[@data-function='calculate']");
    By controlCostandCostRatios = By.xpath("//a[@id='accordion1']");
    By paymentPlanLocator = By.xpath("//a[@id='accordion2']");
    By paymentPlan = By.xpath("//*[@id='content-2']/div/div[1]/table/thead/tr/th[1]");
    By lastPayment = By.xpath("//*[@id='content-2']/div/div[1]/table/tbody/tr[15]/td[1]");


    public CreditCalculationPage(WebDriver driver) {
        super(driver);
    }

    public void calculator(String amount, String insuredType, int loanTerm) throws InterruptedException {
        Thread.sleep(5000);
        scrollByElement(calculateArea);
        clear(loanAmount);
        type(loanAmount, amount);
        //if (insuredType == "uninsured"){  !!! sigortasız kredi hesaplama işlemi yapılamadığından kapatılmıştır.!!!
          //  click(uninsuredChoice);
        //}
        sliderMove(slider, 10);
        click(detailCalc);
        Thread.sleep(3000);

    }
    public String  checkCostArea(){
        waitElement(controlCostandCostRatios);
        String message = find(controlCostandCostRatios).getText();
        return message;
    }


    public void showPaymentPlan() throws InterruptedException {
        click(paymentPlanLocator);
        Thread.sleep(2000);
        Asserts.check(isDisplayed(paymentPlan), "Payment plan not opened");
        scrollByElement(lastPayment);
        scrollByElement(calculateArea);
        Thread.sleep(5000);
    }
}
