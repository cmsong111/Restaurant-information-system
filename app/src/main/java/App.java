import DTO.UserDTO;
import Pages.*;
import Setting.SingleTon;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SingleTon.setUser(UserDTO.builder().upk(0L).build());

        //MainPage MT = new MainPage();
        LoginPage LT = new LoginPage();
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
