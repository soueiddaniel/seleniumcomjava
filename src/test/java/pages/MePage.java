package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author daniel
 * @version $Revision: $<br/>
 * $Id: $
 * @since 10/30/18 6:14 PM
 */
public class MePage extends BasePage{

    public MePage (WebDriver navegador) {
        super(navegador);
    }

    public MePage clicarNaAbaMoreDataAboutYou(){
        //Clicar em um link que possui o texto MORE DATA ABOUT YOU
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clicarBotaoAddMoreData(){
        //Clicar no botão a partir do seu xpath
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        return new AddContactPage(navegador);

    }
}
