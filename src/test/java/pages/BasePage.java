package pages;

import org.openqa.selenium.WebDriver;

/**
 * @author daniel
 * @version $Revision: $<br/>
 * $Id: $
 * @since 10/30/18 6:15 PM
 */
public class BasePage {
    protected WebDriver navegador;

    public BasePage(WebDriver navegador){
        this.navegador = navegador;
    }


}
