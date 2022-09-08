import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TP3 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }
    @Test
    public void testMeilleuresVentes() {
        WebElement cookies = driver.findElement(By.xpath("//input[@class='a-button-input celwidget']"));
        cookies.click();
        WebElement tousLesElements = driver.findElement(By.xpath("//span[@class='hmenu-item']"));
        tousLesElements.click();
        WebElement meilleuresVentes = driver.findElement(By.xpath("//a[@class=hmenu-item']"));
        meilleuresVentes.click();
        List<WebElement> menuList = driver.findElements(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item"));
        menuList.get(2).click();

        /*WebElement troisiemeProduit = driver.findElement(By.xpath("//alt[@class='HP 302 Cartouche d'Encre Noire Authentique (F6U66AE)']"));
        troisiemeProduit.click();*/
    }

        @Test
        public void testAsserts() {


        }


    @AfterMethod
    public void teardown () {
        driver.quit();
    }

}
