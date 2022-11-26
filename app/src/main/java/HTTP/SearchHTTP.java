package HTTP;

import DTO.ArrayListStoreDto;
import DTO.ReviewDTO;
import DTO.StoreDTO;
import Pages.MainPage;
import com.google.gson.Gson;
import DTO.UserDTO;
import Setting.SingleTon;
import okhttp3.*;
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
import java.util.ArrayList;

import Pages.MainPage;

public class SearchHTTP {

    ArrayList<StoreDTO> stores=new ArrayList<>();
    Gson gson = new Gson();
    // 가게 이름으로 검색
    public ArrayList<StoreDTO> searchByName(StoreDTO store) throws IOException {
        String strURL="http://113.198.230.14:5001/store/serch-name?location1=부산광역시&location2=부산진구&";
        strURL=strURL+store.getName();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
       /* MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");*/
        Request request = new Request.Builder()
                .url(strURL)
                //.method("GET", body)
                .get()
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
