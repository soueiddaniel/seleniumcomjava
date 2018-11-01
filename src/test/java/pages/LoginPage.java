package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author daniel
 * @version $Revision: $<br/>
 * $Id: $
 * @since 10/29/18 2:30 PM
 */
public class LoginPage extends BasePage {
    public LoginPage (WebDriver navegador) {
        super(navegador);
    }

    //Método para clicar no link que possui o texto "Sign in"  e que enviara para a próxima pagina (LoginFormPage)
    public LoginFormPage clicarSignIn(){
        navegador.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(navegador);
    }

}
