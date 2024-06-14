package restaurant;

import restaurant.Pages.auth.LoginPage;
import restaurant.Setting.Auth;
import restaurant.Setting.RetrofitProvider;
import restaurant.api.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(App.class);
        LocationRepository locationRepository = RetrofitProvider.INSTANCE.getLocationRepository();
        Auth.INSTANCE.setLocation(locationRepository.getIp().execute().body());
        logger.info("Contry : {}", Auth.INSTANCE.getLocation().getCountry());
        logger.info("Latitude : {}", Auth.INSTANCE.getLocation().getLatitude());
        logger.info("Longitude : {}", Auth.INSTANCE.getLocation().getLongitude());
        new LoginPage();
    }
}
