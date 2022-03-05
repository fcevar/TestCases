import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseActions {

    WebDriver driver;

    public BaseActions(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void clear(By locator){
        find(locator).clear();
    }

    public void waitElement(By locator){
        WebDriverWait w = new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void type (By locator, String text){
        find(locator).sendKeys(text);
    }

    public boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public void sliderMove(By locator, int x){
        WebElement slider = find(locator);
        int width=slider.getSize().getWidth();
        Actions move = new Actions(driver);
        move.moveToElement(slider, (x), 0).click();
        move.build().perform();
    }

    public void scrollByElement(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = find(locator);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }



}
