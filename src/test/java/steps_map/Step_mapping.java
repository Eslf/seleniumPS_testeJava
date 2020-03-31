package steps_map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import models.Pedido;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Step_mapping {
	
	private static WebDriver driver;
	
	Pedido pedido = new Pedido();
	
	
	 // Steps for f01_selectItemToCart.feature

   @Given ("Acessada a pagina da loja")
   public void lojahomePage_open() {
   	System.setProperty("webdriver.firefox.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
	    driver.get("http://automationpractice.com/");
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
   }
   
   @Given ("E acessado os detalhes do item")
   public void click_itemPage_button() {
	   driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[1]/div/a[1]/img")).click();
   }
   
   @When ("Ao clicar no botao de adicionar ao carrinho")
   public void addToCart_itemPage_button() {
	   driver.findElement(By.cssSelector("#add_to_cart")).click();
   }
   
   @When ("E clicar no botao para o resumo da compra")
   public void checkout_itemPage_button() {
	   try {
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   }
   
   @Then ("O site abre a pagina do carrinho de compras")
   public void checkoutPage_validation() {
	   assertThat(driver.findElement(By.cssSelector("#cart_title")).getText(), is ("SHOPPING-CART SUMMARY\nYour shopping cart contains: 1 Product"));
	   driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
   }

}
