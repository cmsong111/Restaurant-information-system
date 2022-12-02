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


       /* ReviewHTTP reviewHTTP = new ReviewHTTP();
        ArrayList<ReviewDTO> results=  reviewHTTP.readReviewbyStore(StoreDTO.builder().spk(1L).build());
        for (ReviewDTO item : results){
            System.out.println(item.toString());
        }*/



        //LoginPage LT = new LoginPage();
        //MenuEditPage ME=new MenuEditPage();

        LoginPage LT = new LoginPage();

        //ReviewPage RP = new ReviewPage();
        //MainPage temp = new MainPage();
        //ReviewEditPage RE=new ReviewEditPage();
        //StoreList SL = new StoreList();
        //StoreDetail SD = new StoreDetail();
        //StoreList SL = new StoreList();
        //StoreDetail SD = new StoreDetail();
        //SignUpPage SP = new SignUpPage();
        //AdminPage AP = new AdminPage();
        //AdminCreateStorePage ACSP = new AdminCreateStorePage();
        //AdminUpdateStorePage AUSP = new AdminUpdateStorePage();
        //AdminDeleteStorePage ADSP = new AdminDeleteStorePage();

        //SuperAdminPage SAP = new SuperAdminPage();
    }
}
