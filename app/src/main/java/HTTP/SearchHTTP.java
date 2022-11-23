package HTTP;

import DTO.StoreDTO;
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

public class SearchHTTP {

    Gson gson = new Gson();
    // 가게 이름으로 검색
    public StoreDTO searchByName(StoreDTO storeName) throws IOException {

        //URL 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTone.getInstance().getBaseURL() + "/store/serch-name");

        // BODY 담기
        String json = gson.toJson(storeName);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type","application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);


        if (response.getStatusLine().getStatusCode() != 200) {
            return null;
        } else {
            String result = EntityUtils.toString(response.getEntity());
            return gson.fromJson(result, StoreDTO.class);
        }
    }



}
