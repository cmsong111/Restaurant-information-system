package HTTP;

import com.google.gson.Gson;
import DTO.UserDTO;
import Setting.SingleTon;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LogInHTTP {
    Gson gson = new Gson();

    public UserDTO login(UserDTO userDTO) throws IOException, NoSuchAlgorithmException {

        //URL 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/user/login");

        //비밀번호 암호화
        userDTO.setPassword(encrypt(userDTO.getPassword()));


        // BODY 담기
        String json = gson.toJson(userDTO);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);


        if (response.getStatusLine().getStatusCode() != 200) {
            return UserDTO.builder().upk(0L).build();
        } else {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(gson.fromJson(result, UserDTO.class).toString());
            return gson.fromJson(result, UserDTO.class);
        }
    }

    public UserDTO create(UserDTO userDTO) throws IOException, NoSuchAlgorithmException {
        //URL 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/user/create");
        //비밀번호 암호화
        userDTO.setPassword(encrypt(userDTO.getPassword()));
        // BODY 담기
        String json = gson.toJson(userDTO);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);
        String body = EntityUtils.toString(response.getEntity());

        UserDTO testest = gson.fromJson(body, UserDTO.class);
        System.out.println(testest.toString());

        if (testest.getUpk() == 0L) {
            return UserDTO.builder().upk(0L).build();
        } else {
            return testest;
        }
    }

    public String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());

        return bytesToHex(md.digest());
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
