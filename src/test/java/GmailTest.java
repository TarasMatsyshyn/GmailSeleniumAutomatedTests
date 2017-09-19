import businessObject.GmailDeleteImportantMessagesBO;
import businessObject.GmailMarkInputMessagesBO;
import model.UserModel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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

        return data;
    }



    @Test(dataProvider = "getData")
    public void gmailTest(String email, String password) throws Exception{

        PropertiesParser propertiesParser = new PropertiesParser();

        //Get credentials from xml file
//        UserModel testUserModel = userModelList.get(0);

        //Get start gmail page
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

    @AfterMethod
    public void closeDriver() {
//        SingletonChromeConnection.getDriver().quit();
    }

}