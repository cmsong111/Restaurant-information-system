package HTTP;

import DTO.StoreDTO;
import Setting.SingleTon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
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

public class SearchHTTP {


    Gson gson = new Gson();

    /**
     * Store 이름 + 위치 검색 메소드
     *
     * @param store (name, location1, location2)
     * @return ArrayList<Store> store
     * @throws IOException
     * @author 김남주
     */
    public ArrayList<StoreDTO> searchStoreByNameWithLocation(StoreDTO store) throws IOException {
        // URL 생성
        CloseableHttpClient Client = HttpClientBuilder.create().build();
        String baseURL = SingleTon.getBaseURL() + "/store/search-name";

        // 파라메터 설정
        HttpGet httpget = new HttpGet(baseURL);
        try {
            URI uri = new URIBuilder(httpget.getURI())
                    .addParameter("location1", store.getLocation1())
                    .addParameter("location2", store.getLocation2()) //콤보박스로 지역 수정할 수 있게
                    .addParameter("name", store.getName()).build();
            httpget.setURI(uri);
        } catch (URISyntaxException t) {
        }

        // HTTP GET method 실행
        HttpResponse response = Client.execute(httpget);

        // 객체화
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            ArrayList<StoreDTO> results = gson.fromJson(responseBody, new TypeToken<ArrayList<StoreDTO>>() {
            }.getType());
            System.out.println(results);
            return results;
        } else {
            return null;
        }
    }

    /**
     * Store를 전체적으로 검색하는 기능 (Locataion1 + Location2 + category + 가맹점)
     *
     * @param store
     * @return ArrayList<StoreDTO> result</StoreDTO>
     * @throws IOException
     * @author 김남주
     */
    public ArrayList<StoreDTO> searchStoreByOverall(StoreDTO store) throws IOException {

        //URI 만들기
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/store/serch-overwall");

        String json = gson.toJson(store);
        StringEntity entity = new StringEntity(json, "UTF-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        CloseableHttpResponse response = client.execute(httpPost);
        String responseBody = EntityUtils.toString(response.getEntity());

        // 객체화
        if (response.getStatusLine().getStatusCode() == 200) {
            // body 결과값 얻기
            ArrayList<StoreDTO> result = gson.fromJson(responseBody, new TypeToken<ArrayList<StoreDTO>>() {
            }.getType());
            System.out.println(result);
            return result;
        } else {
            return null;
        }

    }

    public ArrayList<StoreDTO> searchStoreByCategory(StoreDTO store) throws IOException {

        CloseableHttpClient Client = HttpClientBuilder.create().build();
        String baseURL = SingleTon.getBaseURL() + "/store/search-category";

        // 파라메터 설정
        HttpGet httpget = new HttpGet(baseURL);
        try {
            URI uri = new URIBuilder(httpget.getURI())
                    .addParameter("location1", store.getLocation1())
                    .addParameter("location2", store.getLocation2()) //콤보박스로 지역 수정할 수 있게
                    .addParameter("category", store.getCategory()).build();
            httpget.setURI(uri);
        } catch (URISyntaxException t) {
        }
        // HTTP GET method 실행
        HttpResponse response = Client.execute(httpget);

        // 객체화
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            ArrayList<StoreDTO> results = gson.fromJson(responseBody, new TypeToken<ArrayList<StoreDTO>>() {
            }.getType());
            System.out.println(results);
            return results;
        } else {
            return null;
        }
    }

    /**
     * Store SPK로 겁색하는 메소드
     * @param spk Long 타입의 Store SPK 번호
     * @return storeDTO 검색된 StoreDTO
     * @throws IOException
     */
    public StoreDTO serchByStoreSPK(long spk) throws IOException {
        // URL 생성
        CloseableHttpClient Client = HttpClientBuilder.create().build();
        String baseURL = SingleTon.getBaseURL() + "/store/search-id";

        // 파라메터 설정
        HttpGet httpget = new HttpGet(baseURL);
        try {
            URI uri = new URIBuilder(httpget.getURI())
                    .addParameter("spk", String.valueOf(spk))
                    .build();
            httpget.setURI(uri);
        } catch (URISyntaxException t) {
        }

        // HTTP GET method 실행
        HttpResponse response = Client.execute(httpget);

        // 객체화
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            StoreDTO results = gson.fromJson(responseBody, StoreDTO.class);
            return results;
        } else {
            return null;
        }
    }

    /**
     * Store 위치 검색 메소드
     *
     * @param location1 특별시, 광역시, 특별 자치시, 도, 특별자치도
     * @param location2 지치구, 군, 자치
     * @return ArrayList<Store> store
     * @throws IOException
     * @author 김남주
     */
    public ArrayList<StoreDTO> searchStoreByLocation(String location1, String location2) throws IOException {
        // URL 생성
        CloseableHttpClient Client = HttpClientBuilder.create().build();
        String baseURL = SingleTon.getBaseURL() + "/store/search-location";

        // 파라메터 설정
        HttpGet httpget = new HttpGet(baseURL);
        try {
            URI uri = new URIBuilder(httpget.getURI())
                    .addParameter("location1", location1)
                    .addParameter("location2", location2) //콤보박스로 지역 수정할 수 있게
                    .build();
            httpget.setURI(uri);
        } catch (URISyntaxException t) {
        }

        // HTTP GET method 실행
        HttpResponse response = Client.execute(httpget);

        // 객체화
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            ArrayList<StoreDTO> results = gson.fromJson(responseBody, new TypeToken<ArrayList<StoreDTO>>() {
            }.getType());
            System.out.println(results);
            return results;
        } else {
            return null;
        }
    }


}
