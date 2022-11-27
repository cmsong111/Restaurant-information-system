import DTO.StoreDTO;
import HTTP.StoreHTTP;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws URISyntaxException, IOException, ParseException, NoSuchAlgorithmException {
        StoreHTTP storeHTTP = new StoreHTTP();

        StoreDTO storeDTO = StoreDTO.builder()
                .spk(1001L)
                .build();

        //System.out.println(storeHTTP.createStore(storeDTO).toString());
        storeDTO = storeHTTP.readStore(storeDTO);

        System.out.println(storeHTTP.updateStore(storeDTO).toString());

        storeHTTP.deleteStore(storeDTO);


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
