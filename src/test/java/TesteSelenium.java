import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "TesteSelenium.csv")


public class TesteSelenium {
    private WebDriver navegador;


    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        navegador = Web.createChrome();

         //navegando para a pagina do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        //Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificando o form de login
        WebElement formSigninBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo de name login o texto julio0001
        formSigninBox.findElement(By.name("login")).sendKeys("julio0001");

        //Digitar no campo de password o texto 123456
        formSigninBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto SIGN IN
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possuí a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto MORE DATA ABOUT YOU
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }


    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato, @Param(name="mensagem")String mensagemEsperada) {
        //Clicar no botão a partir do seu xpath
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar o popup onde está o formulário de id addmoredata
        WebElement popUpAddMoreData = navegador.findElement(By.id("addmoredata"));

        //No combo de name "type" escolher a opção Phone
        WebElement campoType = popUpAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        //No campo de name contact digitar + 5511980801314
        popUpAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        //Cliar no link de text SAVE que está no popup
        popUpAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id toast-container validar que o texto é "Your contact has been added!"
        WebElement mensagem = navegador.findElement(By.id("toast-container"));
        String mensagemtxt = mensagem.getText();
        assertEquals(mensagemEsperada,mensagemtxt);
                                       
    }

    //@Test
    public void removerUmContatoDeUmUsuario(){
        //Clicar no elemento pelo seu xpath //span[text()="+551120203535"]/following-sibling::a)
        navegador.findElement(By.xpath("//span[text()=\"+551120203535\"]/following-sibling::a")).click();

        //Confirmar a janela do java script
        navegador.switchTo().alert().accept();


        //Validar que a mensagem apresentada foi Rest in peace, dear phone!
        WebElement mensagem = navegador.findElement(By.id("toast-container"));
        String mensagemtxt = mensagem.getText();
        assertEquals("Rest in peace, dear phone!",mensagemtxt);

        String ssarquivo = "C:\\Users\\Daniel Soueid\\Downloads\\workspace\\report\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, ssarquivo);


        //Aguardar até 10 segundos para que a janela desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagem));

        //Clicar no link com o texto logout
        navegador.findElement(By.linkText("Logout")).click();


    }

    @After
    public void TearDown(){
        //fechar o navegado
        //navegador.quit();
    }
}
