package HTTP;

import DTO.StoreDTO;
import Setting.SingleTon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchHTTP {


    Gson gson = new Gson();
    // 가게 이름으로 검색
    public  ArrayList<Map<String, Object>> searchByName(StoreDTO store) throws IOException {
            CloseableHttpClient Client = HttpClientBuilder.create().build();
            // 파라미터
            String baseURL = SingleTon.getBaseURL() + "/store/serch-name";
            // URL 생성
            HttpGet httpget = new HttpGet(baseURL);
            try {
                URI uri = new URIBuilder(httpget.getURI())
                        .addParameter("location1", store.getLocation1())
                        .addParameter("location2", store.getLocation2()) //콤보박스로 지역 수정할 수 있게
                        .addParameter("name", store.getName())
                        .build();
                httpget.setURI(uri);
            }catch(URISyntaxException t){}
            // HTTP GET method 실행
            HttpResponse response = Client.execute(httpget);
        // 로그 남기기
            /*logger.info(httpget.getURI().toString());
            logger.info(StoreKidsServiceKey);*/

        if (response.getStatusLine().getStatusCode() == 200) {
            // body 결과값 얻기
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            List<Map<String, Object>> allStores=null;
            allStores=gson.fromJson(result, new TypeToken<List<Map<String, Object>>>(){}.getType());
            System.out.println(allStores.toString());


            ArrayList<Map<String, Object>> storeList=new ArrayList<Map<String, Object>>();
            storeList.addAll(allStores);
            return storeList;
        }

        else {
            return null;
        }
    }
    public  ArrayList<Map<String, Object>> search_Category(StoreDTO store) throws IOException{

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/store/serch-overwall");

        String json = gson.toJson(store);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");
        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);


        if (response.getStatusLine().getStatusCode() == 200) {
            // body 결과값 얻기

           HttpEntity entity2 = response.getEntity();
            String result2 = EntityUtils.toString(entity2);
            List<Map<String, Object>> allStores2=null;
            allStores2=gson.fromJson(result2, new TypeToken<List<Map<String, Object>>>(){}.getType());
            System.out.println(allStores2.toString());

            ArrayList<Map<String, Object>> storeList2=new ArrayList<Map<String, Object>>();
            storeList2.addAll(allStores2);

            return storeList2;
        }
        else {
            return null;
        }

    }

}
