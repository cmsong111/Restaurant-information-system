package restaurant.Setting;

import restaurant.DTO.UserDTO;
import lombok.Getter;
import lombok.Setter;

public class SingleTon {

    @Getter
    private static final String BaseURL = "http://127.0.0.1:8080";
    @Getter
    @Setter
    private static UserDTO user;

    private SingleTon() {
    }


}
