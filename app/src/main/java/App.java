import DTO.MenuDTO;
import DTO.ReviewDTO;
import DTO.StoreDTO;
import HTTP.MenuHTTP;
import HTTP.StoreHTTP;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws URISyntaxException, IOException, ParseException, NoSuchAlgorithmException {

        MenuHTTP menuHTTP = new MenuHTTP();

        ArrayList<MenuDTO> menuList;

        menuList = menuHTTP.readMenu(StoreDTO.builder().spk(1L).build());

        for(MenuDTO item : menuList){
            System.out.println(item.toString());
        }

        MenuDTO menuDTO = menuList.get(0);

        menuDTO.setName("맛있는 감자");
        menuDTO.setPrice(10000);
        menuDTO.setImage("https://mediahub.seoul.go.kr/wp-content/uploads/2016/09/61a2981f41200ac8c513a3cbc0010efe.jpg");
        System.out.println(menuHTTP.updateMenu(menuDTO).toString());

        menuHTTP.deleteMenu(menuDTO);

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
