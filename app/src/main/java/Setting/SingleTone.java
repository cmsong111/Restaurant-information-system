package Setting;

import lombok.Getter;
import lombok.Setter;
import DTO.*;
public class SingleTone {
    private static SingleTone instance = new SingleTone();

    private SingleTone() {
    }

    public static SingleTone getInstance() {
        if (instance == null){
            instance = new SingleTone();
        }
        return instance;
    }

    @Getter
    private final String BaseURL = "http://113.198.230.14:5001";

    @Getter
    @Setter
    private UserDTO user = null;

}
