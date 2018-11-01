package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author daniel
 * @version $Revision: $<br/>
 * $Id: $
 * @since 10/30/18 12:56 PM
 */
public class SecretaPage extends BasePage {
    public SecretaPage (WebDriver navegador) {
        super(navegador);
    }

    public MePage clicarMe(){
        //Clicar em um link que possuí a class "me"
        navegador.findElement(By.className("me")).click();

        return new MePage(navegador);
    }
    

}
