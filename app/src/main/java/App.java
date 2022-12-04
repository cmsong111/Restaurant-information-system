import DTO.MenuDTO;
import DTO.ReviewDTO;
import DTO.StoreDTO;
import HTTP.MenuHTTP;
import HTTP.ReviewHTTP;
import HTTP.StoreHTTP;
import org.json.simple.parser.ParseException;
import Pages.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws URISyntaxException, IOException, ParseException, NoSuchAlgorithmException {

        LoginPage LT = new LoginPage();
    }
}
