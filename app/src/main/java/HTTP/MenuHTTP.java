package HTTP;

import DTO.*;
import Setting.SingleTon;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;

public class MenuHTTP {
    Gson gson = new Gson();
    public MenuDTO createMenu(MenuDTO menu) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/menu/create");

        // DTO Body에 담기
        String json = gson.toJson(menu);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return gson.fromJson(result, MenuDTO.class);
    }
    public MenuDTO readMenu(StoreDTO menu) throws IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/menu/read");

        // DTO Body에 담기
        String json = gson.toJson(menu);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return gson.fromJson(result, MenuDTO.class);
    }
    public MenuDTO updateMenu(MenuDTO menu) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/menu/update");

        // DTO Body에 담기
        String json = gson.toJson(menu);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return gson.fromJson(result, MenuDTO.class);
    }
    public void deleteMenu(MenuDTO menu) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/menu/delete");

        // DTO Body에 담기
        String json = gson.toJson(menu);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);
    }
}
