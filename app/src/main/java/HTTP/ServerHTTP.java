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

public class ServerHTTP {
    /**
     * Server에 아동지원가맹정 API 부터 새로운 값으로 갱신하는 작업
     *
     * @return String
     * @throws IOException
     * @author 김남주
     */
    public String updateKids() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/store/update-kids");
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }

    /**
     * Server에 착한가격가맹점 API 부터 새로운 값으로 갱신하는 작업
     *
     * @return String
     * @throws IOException
     * @author 김남주
     */
    public String updatePrice() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/store/update-price");
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }

    /**
     * Server에 부산맛집정보 API 부터 새로운 값으로 갱신하는 작업
     *
     * @return String
     * @throws IOException
     * @author 김남주
     */
    public String updateTasty() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/store/update-tasty");
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }

}
