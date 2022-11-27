import HTTP.NaverMapAPI;
import org.json.simple.parser.ParseException;
import Pages.*;
import java.io.IOException;
import java.net.URISyntaxException;
public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws URISyntaxException, IOException, ParseException {
        NaverMapAPI api = new NaverMapAPI();
        //System.out.println(api.getStaticMAP(128.9586888,35.10382849));
        //SingleTon.setUser(UserDTO.builder().upk(0L).build());

        MainPage MT = new MainPage();
        //LoginPage LT = new LoginPage();
        //ReviewPage RP = new ReviewPage();

       //StoreList SL = new StoreList();
        //StoreDetail SD = new StoreDetail();
        //StoreList SL = new StoreList();
        //StoreDetail SD = new StoreDetail();
        //SignUpPage SP = new SignUpPage();
         //AdminPage AP = new AdminPage();
        //AdminCreateStorePage ACSP = new AdminCreateStorePage();
        //AdminUpdateStorePage AUSP = new AdminUpdateStorePage();
        //AdminDeleteStorePage ADSP = new AdminDeleteStorePage();
    }
}
