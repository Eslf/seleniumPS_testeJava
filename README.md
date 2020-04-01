# seleniumPS_testeJava

## Configuração de ambiente

Procure pelo arquivo "Step_mapping.java", localizado em src/test/java/steps_map e encontre a seção:

```java
//	  Steps for f01_selectItemToCart.feature

   @Given ("Acessada a pagina da loja")
   public void lojahomePage_open() {
   	System.setProperty("webdriver.firefox.driver", "FIREFOX_PATH");
		driver = new FirefoxDriver();
	    driver.get("http://automationpractice.com/");
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    insereDadosPedido();
   }
```

  Onde possui **"FIREFOX_PATH"**, substitua pelo diretório onde se encontra o arquivo de driver do 
  Mozilla Firefox ("Gekodriver").
  
  Execução de Testes
  
  Para executar os testes do deasfio de automação, encontre o arquivo **"Steps_execution.java"** localizado em src/test/java/steps_running e clique com o botão direito do mouse. No menu, vá até **"Run as"** e selecione a opção **"JUnit Test"**.