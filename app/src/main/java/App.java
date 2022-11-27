import DTO.UserDTO;
import HTTP.LogInHTTP;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws URISyntaxException, IOException, ParseException, NoSuchAlgorithmException {
        //NaverMapAPI api = new NaverMapAPI();
        //System.out.println(api.getStaticMAP(128.9586888,35.10382849));
        //SingleTon.setUser(UserDTO.builder().upk(0L).build());

        //MainPage MT = new MainPage();
//        SearchHTTP searchHTTP = new SearchHTTP();
//        StoreDTO storeDTO = StoreDTO.builder()
//                .location1("부산광역시")
//                .location2("부산진구")
//                .name("맥도날드")
//                .build();
//        System.out.println(storeDTO.toString());
//
//        //ArrayList<StoreDTO> result = searchHTTP.search_Category(storeDTO);
//        ArrayList<StoreDTO> result = searchHTTP.searchByName(storeDTO);
//        for (StoreDTO item : result) {
//            System.out.println(item.toString());
//        }

        LogInHTTP logInHTTP = new LogInHTTP();
        UserDTO user = UserDTO.builder()
                .id("namju59621")
                .password("namju59621")
                .name("김남주")
                .age(20)
                .build();
        System.out.println("USERDTO" + user.toString());
        //System.out.println("회원가입" + logInHTTP.create(user).toString());
        System.out.println("로그인" + logInHTTP.login(user).toString());


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
