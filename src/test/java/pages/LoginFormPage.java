package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author daniel
 * @version $Revision: $<br/>
 * $Id: $
 * @since 10/29/18 2:46 PM
 */
public class LoginFormPage extends BasePage {
    public LoginFormPage (WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage digitarLogin (String login){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this;
        
    }


    public LoginFormPage digitarSenha (String senha){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(senha);
        return this;

    }

    public SecretaPage clicarSignIn (){
        //Clicar no link com o texto SIGN IN
        navegador.findElement(By.linkText("SIGN IN")).click();

        return new SecretaPage(navegador);
    }

    public SecretaPage fazerLogin(String login, String senha){
        digitarLogin(login);
        digitarSenha(senha);
        clicarSignIn();

        return new SecretaPage(navegador);

    }

}
