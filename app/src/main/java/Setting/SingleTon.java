package Setting;

import lombok.Getter;
import lombok.Setter;
import DTO.*;

public class SingleTon {

    private SingleTon() {
    }

    @Getter
    private static final String BaseURL = "http://113.198.230.14:5001";

    @Getter
    @Setter
    private static UserDTO user = new UserDTO();

}
