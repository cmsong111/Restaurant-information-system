package HTTP;

import DTO.StoreDTO;
import Setting.SingleTon;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class StoreHTTP {
    Gson gson = new Gson();

    public StoreDTO createStore(StoreDTO store) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/store/create");

        // DTO Body에 담기
        String json = gson.toJson(store);
        StringEntity entity = new StringEntity(json, "UTF-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return gson.fromJson(result, StoreDTO.class);
    }

    public StoreDTO readStore(StoreDTO store) throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(SingleTon.getBaseURL() + "/store/serch-id");

        // URI 제작
        URI uri = new URIBuilder(httpGet.getURI())
                .addParameter("id", store.getSpk().toString())
                .build();
        httpGet.setURI(uri);
        httpGet.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpGet);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return gson.fromJson(result, StoreDTO.class);
    }

    public StoreDTO updateStore(StoreDTO store) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/store/update");

        // DTO Body에 담기
        String json = gson.toJson(store);
        StringEntity entity = new StringEntity(json, "UTF-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return gson.fromJson(result, StoreDTO.class);
    }

    public void deleteStore(StoreDTO store) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/store/delete");

        // DTO Body에 담기
        String json = gson.toJson(store);
        StringEntity entity = new StringEntity(json, "UTF-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);
    }
}
