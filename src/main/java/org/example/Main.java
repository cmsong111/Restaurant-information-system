package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.data.repository.local_repository.UserRepository;
import org.example.data.repository.remote_repository.LocationRemoteRepository;
import org.example.data.repository.remote_repository.RetrofitProvider;
import org.example.view.auth.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {
        Logger logger = LoggerFactory.getLogger(Main.class);
        LocationRemoteRepository locationRepository = RetrofitProvider.INSTANCE.getLocationRepository();
        UserRepository.INSTANCE.setLocation(locationRepository.getIp().execute().body());
        logger.info("Connect Info : {}", UserRepository.INSTANCE.getLocation());
        new LoginPage();
    }
}
