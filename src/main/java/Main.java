import model.UserModel;
import utils.UserCredentionalXMLParser;

import javax.xml.bind.JAXBException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
        UserCredentionalXMLParser userCredentionalXMLParser = new UserCredentionalXMLParser();
        List<UserModel> userModels = userCredentionalXMLParser.unMarshaling();
        userModels.forEach(System.out::println);
        }
}