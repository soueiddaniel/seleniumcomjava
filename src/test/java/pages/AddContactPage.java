package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author daniel
 * @version $Revision: $<br/>
 * $Id: $
 * @since 10/31/18 9:24 AM
 */
public class AddContactPage extends BasePage {

    public AddContactPage (WebDriver navegador) {
        super(navegador);
    }


    public AddContactPage escolherTipoDeContato (String tipo){
       
        //No combo de name "type" escolher a opção Phone
        WebElement campoType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);
        return this;
    }


    public AddContactPage digitarContato (String contato){
        //No campo de name contact digitar + 5511980801314
        navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);

        return this;
    }

    public MePage clicarSalvar(){
        //Cliar no link de text SAVE que está no popup
        navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

        return new MePage(navegador);
    }


    public MePage adicionarContato (String tipo, String contato){
        escolherTipoDeContato(tipo);
        digitarContato(contato);
        clicarSalvar();
        return new MePage(navegador);

    }
}
