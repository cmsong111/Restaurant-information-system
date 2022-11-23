package HTTP;

import DTO.StoreDTO;
import com.google.gson.Gson;
import DTO.UserDTO;
import Setting.SingleTon;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
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
        HttpGet Name_search = new HttpGet(SingleTon.getBaseURL() + "/store/serch-name");
        URIBuilder uri=new URIBuilder(Name_search.getURI());
        uri.addParameter("location1", storeName.getLocation1());
        uri.addParameter("location2", storeName.getLocation2());
        uri.addParameter("store", storeName.getName());


        // BODY 담기
        /*String json = gson.toJson(storeName);
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
        }*/
        return null;
    }



}
