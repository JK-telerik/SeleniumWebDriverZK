import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class bingsearch
{
    @Test
    public void bingSearchTitle() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.bing.com");
        driver.manage().window().maximize();
//
        try {
            WebElement cookieButton = driver.findElement(By.id("bnp_btn_accept"));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Cookie consent not found or already accepted.");
        }
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys("Telerik Academy Alpha" + Keys.ENTER);
        WebElement searchResultsBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b_results")));
        List<WebElement> resultLinks = driver.findElements(By.xpath("//h2"));
        WebElement firstResult = resultLinks.get(0);
        String expectedTitle = "IT Career Start in 6 Months - Telerik Academy Alpha";
        String actualTitle = firstResult.getText();
        Assertions.assertEquals(expectedTitle, actualTitle, "The first search result title did not match the expected title.");
//
        driver.close();
    }
}
