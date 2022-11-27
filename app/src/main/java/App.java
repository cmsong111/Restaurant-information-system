import DTO.StoreDTO;
import HTTP.NaverMapAPI;
import HTTP.SearchHTTP;
import Pages.MainPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws URISyntaxException, IOException, ParseException {
        //NaverMapAPI api = new NaverMapAPI();
        //System.out.println(api.getStaticMAP(128.9586888,35.10382849));
        //SingleTon.setUser(UserDTO.builder().upk(0L).build());

        //MainPage MT = new MainPage();
        SearchHTTP searchHTTP = new SearchHTTP();
        StoreDTO storeDTO = StoreDTO.builder()
                .location1("부산광역시")
                .location2("부산진구")
                .category("제과점")
                .kids(true)
                .price(false)
                .tasty(false)
                .roleModel(false)
                .build();
        System.out.println(storeDTO.toString());

        ArrayList<StoreDTO> result = searchHTTP.search_Category(storeDTO);
        for (StoreDTO item : result) {
            System.out.println(item.toString());
        }
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
