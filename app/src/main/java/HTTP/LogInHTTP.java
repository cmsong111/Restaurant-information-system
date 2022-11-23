package HTTP;

import com.google.gson.Gson;
import DTO.UserDTO;
import Setting.SingleTone;
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
        HttpPost httpPost = new HttpPost(SingleTone.getInstance().getBaseURL() + "/user/login");

        // BODY 담기
        String json = gson.toJson(userDTO);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type","application/json");

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
        System.out.println(userDTO.toString());
        //URL 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTone.getInstance().getBaseURL() + "/user/create");

        // BODY 담기
        String json = gson.toJson(userDTO);
        System.out.println("보낼 제이슨"+json);

        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type","application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        System.out.println("서버에서 날라온 스트링: "+EntityUtils.toString(response.getEntity()));

        UserDTO testest = gson.fromJson(EntityUtils.toString(response.getEntity()),UserDTO.class);
        System.out.println("객체화 완료"+testest.toString());

        if (response.getStatusLine().getStatusCode() != 200) {
            System.out.println("널 반환했음");
            return null;
        } else {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("객체 반환했음");

            return gson.fromJson(result, UserDTO.class);
        }
    }
}
