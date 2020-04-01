package steps_map;

import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.WebElement;
import java.util.Random;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import models.Pedido;

public class Step_mapping {
	
	private static WebDriver driver;
	private static String nome_completo = "";
	private static String info_endereco = "";
	private static String valorDoPedido = "";
	Random random = new Random();
	private int aleatorio_email = random.nextInt(1001);
	
	// Secao dedicada a gerar/inserir os dados a serem utilizados pelo pedido
	
	static Pedido pedido = new Pedido();
	
	public void insereDadosPedido() {
		pedido.setNome("Nome");
		pedido.setSobrenome("Sobrenome do Cliente");
		pedido.setEmail("emaildo.cliente_"+aleatorio_email+"@email.com");
		pedido.setSenha("S3nh@");
		pedido.setTelefone("12125558737");
		pedido.setRua("711 11th Ave");
		pedido.setCidade("New York");
		pedido.setCep("10019");
		pedido.setEstado("New York");
		pedido.setAliasEndereco("Commercial Address");
		nome_completo = pedido.getNome()+" "+pedido.getSobrenome();
		info_endereco = pedido.getCidade()+", "+pedido.getEstado()+" "+pedido.getCep();
	}
	
//	  Steps for f01_selectItemToCart.feature

   @Given ("Acessada a pagina da loja")
   public void lojahomePage_open() {
   	System.setProperty("webdriver.firefox.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
	    driver.get("http://automationpractice.com/");
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    insereDadosPedido();
   }
   
   @And ("E acessado os detalhes do item")
   public void click_itemPage_button() {
	   driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[1]/div/a[1]/img")).click();
   }
   
   @When ("Ao clicar no botao de adicionar ao carrinho")
   public void addToCart_itemPage_button() {
	   String valorProd = driver.findElement(By.cssSelector("#our_price_display")).getText();
	   valorProd = valorProd.substring(1);
	   double valorProdD = Double.parseDouble(valorProd);
	   pedido.setValorProduto(valorProdD);
	   driver.findElement(By.cssSelector("#add_to_cart")).click();
   }
   
   @And ("E clicar no botao para o resumo da compra")
   public void checkout_itemPage_button() {
	   WebDriverWait wait_checkoutButton = new WebDriverWait(driver, 1);
	   wait_checkoutButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
	   driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")).click();
   }
   
   @Then ("O site abre a pagina do carrinho de compras")
   public void checkoutPage_validation() {
	   assertThat(driver.findElement(By.cssSelector("#cart_title")).getText(), is ("SHOPPING-CART SUMMARY\nYour shopping cart contains: 1 Product"));
	   String valorFrete = driver.findElement(By.cssSelector("#total_shipping")).getText();
	   valorFrete = valorFrete.substring(1);
	   double valorFreteD = Double.parseDouble(valorFrete);
	   pedido.setValorFrete(valorFreteD);
	   pedido.setValorTotal(valorFreteD+pedido.getValorProduto());
	   valorDoPedido = "$"+String.valueOf(pedido.getValorTotal());
	   driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
   }

   //	Steps for f02_createUserAndValidateAddress.feature


   @Given ("Dado seja inserido o e-mail e clicado no botao Nova Conta")
   public void clickCreateUserPage_button() {
	   driver.findElement(By.cssSelector("#email_create")).sendKeys(pedido.getEmail());
	   driver.findElement(By.cssSelector("#SubmitCreate")).click();
   }
   
   @And ("e seja preenchido os campos obrigatorios do cadastro")
   public void fillCreateUserPage_fields() {
	   WebDriverWait wait_id_gender1 = new WebDriverWait(driver, 3);
	   wait_id_gender1.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
	   driver.findElement(By.cssSelector("#id_gender1")).click();
	   driver.findElement(By.cssSelector("#customer_firstname")).sendKeys(pedido.getNome());
	   driver.findElement(By.cssSelector("#customer_lastname")).sendKeys(pedido.getSobrenome());
	   driver.findElement(By.cssSelector("#passwd")).sendKeys(pedido.getSenha());
	   driver.findElement(By.cssSelector("#address1")).sendKeys(pedido.getRua());
	   driver.findElement(By.cssSelector("#city")).sendKeys(pedido.getCidade());
	   Select lista_estados = new Select(driver.findElement(By.name("id_state")));
	   lista_estados.selectByVisibleText(pedido.getEstado());
	   driver.findElement(By.cssSelector("#postcode")).sendKeys(pedido.getCep());
	   driver.findElement(By.cssSelector("#phone_mobile")).sendKeys(pedido.getTelefone());
	   driver.findElement(By.cssSelector("#alias")).clear();
	   driver.findElement(By.cssSelector("#alias")).sendKeys(pedido.getAliasEndereco());

   }
   
   @When ("Ao clicar no botao Registrar")
   public void clickRegisterCreateUserPage_button() {
	   driver.findElement(By.cssSelector("#submitAccount")).click();
   }
   
   @Then ("Sera validado a seguir o endereco de entrega e")
   public void validateInfoAddressPage_text() {
	   assertThat(driver.findElement(By.cssSelector("#address_delivery > li:nth-child(2)")).getText(), is(nome_completo));
	   assertThat(driver.findElement(By.cssSelector("#address_delivery > li:nth-child(3)")).getText(), is(pedido.getRua()));
	   assertThat(driver.findElement(By.cssSelector("#address_delivery > li:nth-child(4)")).getText(), is(info_endereco));
	   assertThat(driver.findElement(By.cssSelector("#address_delivery > li:nth-child(6)")).getText(), is(pedido.getTelefone()));
	   driver.findElement(By.name("processAddress")).click();
   }
   
   @Then ("aceito os Termos de Servico")
   public void acceptTermsOfServiceShippingPage_checkbox() {
	   driver.findElement(By.cssSelector("#cgv")).click();
	   driver.findElement(By.name("processCarrier")).click();
   }
   
   
   //	Steps for f03_validateTotalCartPaymentAndFinishPurchase.feature
   
   @Given ("Dado que o total da compra seja validado")
   public void validateTotalCartPaymentPage_text() {
	   assertThat(driver.findElement(By.cssSelector("#total_price")).getText(), is(valorDoPedido));
   }
   
   @And ("e selecionado o metodo de pagamento")
   public void selectMethodPaymentPage_button() {
	   driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a")).click();
   }
   
   @When ("Ao confirmar a compra")
   public void confirmOrderPaymentPage_button() {
	   driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button")).click();
   }
   
   @Then ("Validar se a compra foi finalizada com sucesso")
   public void validateOrderPaymentPage_text() {
	   assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/p/strong")).getText(), is("Your order on My Store is complete."));
   }
   
}
