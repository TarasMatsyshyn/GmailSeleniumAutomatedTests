import businessObject.GmailDeleteImportantMessagesBO;
import businessObject.GmailLoginBO;
import businessObject.GmailMarkInputMessagesBO;
import model.UserModel;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.PropertiesParser;
import utils.SingletonChromeConnection;
import utils.UserCredentionalXMLParser;

import java.util.List;


public class GmailTest {

    @DataProvider(parallel = true)
    public Object [][] getData() throws Exception {
        List<UserModel> users = userModels();
        Object [][] data = new Object[users.size()][2];

        for(int i = 0; i < users.size(); i++){
            data[i][0] = users.get(i).getLogin();
            data[i][1] = users.get(i).getPassword();
        }
        return data;
    }

    @Test(dataProvider = "getData")
    public void gmailTest(String email, String password) throws Exception{

        //Get start gmail page
        PropertiesParser propertiesParser = new PropertiesParser();
        SingletonChromeConnection.getDriver().get(propertiesParser.getBaseUrl());

        //Log in
        GmailLoginBO login = new GmailLoginBO();
        login.login(email , password);

        //Marking first three messages as important
        GmailMarkInputMessagesBO gmailMarkInputMessagesBO =new GmailMarkInputMessagesBO();
        gmailMarkInputMessagesBO.markMessagesAsImportant();

        //Delete this three messages from important
        GmailDeleteImportantMessagesBO deleteImportantMessagesBO = new GmailDeleteImportantMessagesBO();
        deleteImportantMessagesBO.deleteImportantMessages();
    }

    @AfterMethod
    public void quit() {
        SingletonChromeConnection.quit();
    }

    private List<UserModel> userModels() throws Exception{
        UserCredentionalXMLParser xmlParser = new UserCredentionalXMLParser();
        return xmlParser.unMarshaling();
    }

}