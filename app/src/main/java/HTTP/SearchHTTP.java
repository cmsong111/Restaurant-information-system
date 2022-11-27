package HTTP;

import DTO.ArrayListStoreDto;
import DTO.StoreDTO;
import Pages.MainPage;
import Setting.SingleTon;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class SearchHTTP {

    ArrayList<StoreDTO> stores=new ArrayList<>();
    Gson gson = new Gson();
    // 가게 이름으로 검색
    public ArrayList<StoreDTO> searchByName(StoreDTO store) throws IOException {
            CloseableHttpClient Client = HttpClientBuilder.create().build();
            // 파라미터
            String baseURL = SingleTon.getBaseURL() + "/store/serch-name";
            // URL 생성
            HttpGet httpget = new HttpGet(baseURL);
            try {
                URI uri = new URIBuilder(httpget.getURI())
                        .addParameter("location1", "부산광역시")
                        .addParameter("location2", "부산진구") //콤보박스로 지역 수정할 수 있게
                        .addParameter("name", store.getName())
                        .build();
                httpget.setURI(uri);
            }catch(URISyntaxException t){}
            // HTTP GET method 실행
            HttpResponse response = Client.execute(httpget);
        // 로그 남기기
            /*logger.info(httpget.getURI().toString());
            logger.info(StoreKidsServiceKey);*/

        if (response.getStatusLine().getStatusCode() != 200) {
            // body 결과값 얻기
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            ArrayListStoreDto storelist = gson.fromJson(result, ArrayListStoreDto.class);
            for (StoreDTO item : storelist.getStoreDTOArrayList()) {
                stores.add(item);
            }
            return stores;
        }

        else {
            return null;
        }
    }
    public ArrayList<StoreDTO> search_Category(StoreDTO store) throws IOException{
        String strURL="http://113.198.230.14:5001/store/serch-name?location1=부산광역시&location2=부산진구&";
        strURL=strURL+store.getCategory();
        if(MainPage.local_Currency==true)
            strURL=strURL+"&price=true";
        if(MainPage.forChild==true)
            strURL=strURL+"&kids=true";
        if(MainPage.roleModel==true)
            strURL=strURL+"&roleModel=true";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
       /* MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");*/
        Request request = new Request.Builder()
                .url(strURL)
                //.method("GET", body)
                .build();

        Response response = client.newCall(request).execute(); //Get요청 전송


        if (response.isSuccessful()) {
            ResponseBody result=response.body();
            ArrayListStoreDto storelist=gson.fromJson(result.toString(), ArrayListStoreDto.class);

            for (StoreDTO item : storelist.getStoreDTOArrayList()) {
                stores.add(item);
            }
            return stores;
        } else {
            System.out.println("서버 통신 실패");
            return null;
        }
    }

}
