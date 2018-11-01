import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

/**
 * @author daniel
 * @version $Revision: $<br/>
 * $Id: $
 * @since 10/29/18 10:52 AM
 */
public class InformacoesUsuarioPageObjectsTest {
     private WebDriver navegador;

    @Before
    public void setUp(){
         navegador = Web.createChrome();
         
     }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        new LoginPage(navegador).clicarSignIn()
                                .fazerLogin("julio0001","123456" )
                                .clicarMe()
                                .clicarNaAbaMoreDataAboutYou()
                                .clicarBotaoAddMoreData();
    }

    @After
    public void tearDown(){
        //navegador.quit();
     }

}
