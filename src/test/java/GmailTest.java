import businessObject.GmailDeleteImportantMessagesBO;
import businessObject.GmailMarkInputMessagesBO;
import model.UserModel;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.GmailLoginPO;
import utils.PropertiesParser;
import utils.SingletonChromeConnection;
import utils.UserCredentionalXMLParser;

import java.util.List;


public class GmailTest {

    private List<UserModel> userModels() throws Exception{
        UserCredentionalXMLParser xmlParser = new UserCredentionalXMLParser();
        return xmlParser.unMarshaling();
    }

    @DataProvider(parallel = true)
    public Object [] [] getData() throws Exception {
        List<UserModel> users = userModels();
        Object [][] data = new Object[users.size()][2];

        data[0][0] = users.get(0).getLogin();
        data[0][1] = users.get(0).getPassword();

        data[1][0] = users.get(1).getLogin();
        data[1][1] = users.get(1).getPassword();

        data[2][0] = users.get(2).getLogin();
        data[2][1] = users.get(2).getPassword();

        data[3][0] = users.get(3).getLogin();
        data[3][1] = users.get(3).getPassword();

        data[4][0] = users.get(4).getLogin();
        data[4][1] = users.get(4).getPassword();

        return data;
    }



    @Test(dataProvider = "getData")
    public void gmailTest(String email, String password) throws Exception{

        //Get start gmail page
        PropertiesParser propertiesParser = new PropertiesParser();
        SingletonChromeConnection.getDriver().get(propertiesParser.getBaseUrl());

        //Log in
        GmailLoginPO login = new GmailLoginPO();
        login.logIn(email , password);

        //Marking first three messages as important
        GmailMarkInputMessagesBO gmailMarkInputMessagesBO =new GmailMarkInputMessagesBO();
        gmailMarkInputMessagesBO.markMessagesAsImportant();

        //Delete this three messages from important
        GmailDeleteImportantMessagesBO deleteImportantMessagesBO = new GmailDeleteImportantMessagesBO();
        Assert.assertEquals(deleteImportantMessagesBO.deleteImportantMessages(),true);
    }

    @AfterClass
    public void closeDriver() {
        SingletonChromeConnection.getDriver().close();
        SingletonChromeConnection.getDriver().quit();
    }

}