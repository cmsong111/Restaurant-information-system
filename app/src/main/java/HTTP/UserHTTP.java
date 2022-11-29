package HTTP;

import DTO.UserDTO;
import Setting.SingleTon;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserHTTP {
    Gson gson = new Gson();

    /**
     * @param userDTO (Not null : ID,Password)
     * @return 완성된 UserDTO
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @author 김남주
     */
    public UserDTO login(UserDTO userDTO) throws IOException, NoSuchAlgorithmException {

        //URL 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/user/login");

        //비밀번호 암호화
        userDTO.setPassword(encrypt(userDTO.getPassword()));

        // BODY 담기
        String json = gson.toJson(userDTO);
        StringEntity entity = new StringEntity(json, "UTF-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        if (response.getStatusLine().getStatusCode() != 200) {
            return UserDTO.builder().upk(0L).build();
        } else {
            String result = EntityUtils.toString(response.getEntity());
            return gson.fromJson(result, UserDTO.class);
        }
    }

    /**
     * @param userDTO (ID, Password, name)
     * @return 완성된 UserDTO
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @author 김남주
     */
    public UserDTO create(UserDTO userDTO) throws IOException, NoSuchAlgorithmException {
        //URL 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/user/create");
        //비밀번호 암호화
        userDTO.setPassword(encrypt(userDTO.getPassword()));
        // BODY 담기
        String json = gson.toJson(userDTO);
        StringEntity entity = new StringEntity(json, "UTF-8");
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

    /**
     * 유저 정보 업데이트 하는 메소드입니다.
     * UPK랑 꼭 같이 보내주세요
     *
     * @param userDTO
     * @return UserDTO
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public UserDTO editUser(UserDTO userDTO) throws NoSuchAlgorithmException, IOException {
        //URL 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/user/update");
        //비밀번호 암호화
        userDTO.setPassword(encrypt(userDTO.getPassword()));
        // BODY 담기
        String json = gson.toJson(userDTO);
        StringEntity entity = new StringEntity(json, "UTF-8");
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

    /**
     * 회원 탈퇴 UPK 필수
     *
     * @param userDTO
     * @return success : true, fail : false
     */
    public boolean withdrawal(UserDTO userDTO) throws IOException {
        //URL 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/user/delete");

        // BODY 담기
        String json = gson.toJson(userDTO);
        StringEntity entity = new StringEntity(json, "UTF-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);
        String body = EntityUtils.toString(response.getEntity());

        if (body.equals("Delete Done")) {
            return true;
        } else {
            return false;
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
