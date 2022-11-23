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

public class LogInHTTP {
    Gson gson = new Gson();

    public UserDTO login(UserDTO userDTO) throws IOException {

        //URL 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/user/login");

        // BODY 담기
        String json = gson.toJson(userDTO);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);


        if (response.getStatusLine().getStatusCode() != 200) {
            return null;
        } else {
            String result = EntityUtils.toString(response.getEntity());
            return gson.fromJson(result, UserDTO.class);
        }
    }

    public UserDTO create(UserDTO userDTO) throws IOException {
        //URL 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/user/create");

        // BODY 담기
        String json = gson.toJson(userDTO);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);
        String body = EntityUtils.toString(response.getEntity());

        UserDTO testest = gson.fromJson(body, UserDTO.class);

        if (testest.getUpk() == 0L) {
            return null;
        } else {
            return testest;
        }
    }
}
