package HTTP;

import DTO.*;
import Setting.SingleTon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class MenuHTTP {
    Gson gson = new Gson();

    public MenuDTO createMenu(MenuDTO menu) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/menu/create");

        // DTO Body에 담기
        String json = gson.toJson(menu);
        StringEntity entity = new StringEntity(json,"UTF-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return gson.fromJson(result, MenuDTO.class);
    }

    public ArrayList<MenuDTO> readMenu(StoreDTO storeDTO) throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(SingleTon.getBaseURL() + "/menu/readInStore");
        URI uri = new URIBuilder(httpGet.getURI())
                .addParameter("spk", storeDTO.getSpk().toString())
                .build();
        httpGet.setURI(uri);

        System.out.println(httpGet.getURI());
        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpGet);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        ArrayList<MenuDTO> menuDTOArrayList = gson.fromJson(result, new TypeToken<ArrayList<MenuDTO>>() {
        }.getType());
        System.out.println(menuDTOArrayList);
        return menuDTOArrayList;
    }

    public MenuDTO updateMenu(MenuDTO menu) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/menu/update");

        // DTO Body에 담기
        String json = gson.toJson(menu);
        StringEntity entity = new StringEntity(json,"UTF-8");
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
