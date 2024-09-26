import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class googlechrome
{
    @Test
    public void googleSearchTitle(){
//
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://google.com");
        driver.manage().window().maximize();
        WebElement cookieButton = driver.findElement(By.id("L2AGLb"));
        cookieButton.click();
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys( "Telerik Academy Alpha"+ Keys.ENTER);
        WebElement searchResultsBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        List<WebElement> resultLinks = driver.findElements(By.xpath("//h3"));var firstResult = resultLinks.get(0);
        Assertions.assertEquals("IT Career Start in 6 Months - Telerik Academy Alpha", firstResult.getText());
//
        driver.close();
    }
}
