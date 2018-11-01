package suporte;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author daniel
 * @version $Revision: $<br/>
 * $Id: $
 * @since 10/29/18 10:40 AM
 */
public class Web {

    public static WebDriver createChrome () {
        //passando local do chromeDriver
        System.setProperty("webdriver.chrome.driver", "/home/daniel/autom/chromedriver");
        // Em Windows -->  System.setProperty("webdriver.chrome.driver","C:\\Users\\Daniel Soueid\\Downloads\\workspace\\chromedriver.exe");

        //abrindo o navegador
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a pagina desejada
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;

    }

}
