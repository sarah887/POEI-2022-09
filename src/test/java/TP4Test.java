import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TP4Test {

    WebDriver driver;

    @Test
    public void testIphone(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        WebElement cookies = driver.findElement(By.xpath( "//input[@class='a-button-input celwidget']"));
        cookies.click();
        WebElement searchbar = driver.findElement(By.xpath( "//input[@aria-label=\"Rechercher\"]"));
        searchbar.sendKeys("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");
        WebElement loupe = driver.findElement(By.xpath( "//div[@class='nav-search-submit nav-sprite']"));
        loupe.click();
        List<WebElement> menuList = driver.findElements(By.cssSelector("//div[@data-component-type=s-search-result]"));
        menuList.get(0).click();
        WebElement produit = driver.findElement(By.xpath( "//div[@class='s-image']"));
        produit.click();
        WebElement ajoutPanier = driver.findElement(By.xpath( "//div[@class='a-button-input']"));
        ajoutPanier.click();
        WebElement panier = driver.findElement(By.xpath( "//div[@class='nav-line-2']"));
        panier.click();
        /*WebElement panier = driver.findElement(By.xpath( "//div[@class='nav-line-2']"));
        panier.click();

        Assert.assertTrue(logo.isDisplayed(), "The Amazon Logo is not displayed");
        Assert.assertTrue(barreRecherche.isDisplayed());
        Assert.assertEquals(toutesMenu.getText(), expectedToutes);

        Assert.assertTrue(meilleuresVentes.isDisplayed());
        Assert.assertEquals(meilleuresVentes.getText(), expectedMeilleuresVentes, "The button Meilleures Ventes is not correct");

        Assert.assertTrue(amazonBasics.isDisplayed());
        Assert.assertEquals(amazonBasics.getText(), expectedAmazonBasics);

        Assert.assertTrue(meilleuresVentesLivres.isDisplayed());
        Assert.assertEquals(meilleuresVentesLivres.getText(), expectedVentesLivres);*/





        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void testSelect() {
        WebElement dropdown = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByIndex(4);
    }

    @Test
    public void testAmazon() {
        //******************************* Arrange******************************//
        final String expectedTaille  = "256Go";
        final String expectedCouleur  = "Vert alpin";
        final String expectedConfiguration  = "Sans AppleCare+";
        final String expectedTotale  = "Sous-total (2 articles):";


        // ************************************Act****************************//
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();


        List<WebElement> resultatList = driver.findElements(By.cssSelector("img.s-image"));
        resultatList.get(0).click();


        WebElement ajouterAuPanierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']")));
        ajouterAuPanierButton.click();

        WebElement nonmerci = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']")));
        nonmerci.click();

        // driver.getCurrentUrl('https://www.amazon.fr/gp/cart/view.html');

        WebElement panierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#attach-sidesheet-view-cart-button")));
        panierButton.click();

        WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByIndex(2);


        List<WebElement> informations = driver.findElements(By.cssSelector(".sc-product-variation .a-text-bold + span"));
        WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sc-subtotal-label-activecart")));

        // ***********************************Asserts*********************//
        Assert.assertEquals(informations.get(0).getText(),expectedTaille,"Taille pas bon");
        Assert.assertEquals(informations.get(1).getText(),expectedCouleur ,"couleur pas bon");
        Assert.assertEquals(informations.get(2).getText(),expectedConfiguration ,"config pas bon");
        Assert.assertEquals(soustotale.getText(),expectedTotale,"sous total pa bon");



    }
}
