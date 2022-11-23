package HTTP;

import DTO.ArrayListReviewDto;
import DTO.ReviewDTO;
import DTO.StoreDTO;
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

public class ReviewHTTP extends ArrayList<ReviewDTO> {
    Gson gson = new Gson();

    /**
     * Review 를 생성하는 기능
     *
     * @param reviewDTO 중 RPK 제외
     * @return reviewDTO
     * @Author 김남주
     */
    public ReviewDTO createReview(ReviewDTO reviewDTO) throws IOException {
        // HTTP POST 객체 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/review/create");

        // DTO Body에 담기
        String json = gson.toJson(reviewDTO);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return gson.fromJson(result, ReviewDTO.class);
    }

    /**
     * Review PK 값으로 해당하는 Reviews를 수정하는 기능
     *
     * @param reviewDTO 변경할 내용 전부
     * @return StoreDTO
     * @Author 김남주
     */
    public ReviewDTO updateeview(ReviewDTO reviewDTO) throws IOException {
        // HTTP POST 객체 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/review/update");

        // DTO Body에 담기
        String json = gson.toJson(reviewDTO);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return gson.fromJson(result, ReviewDTO.class);
    }

    /**
     * Store PK 값으로 해당하는 Reviews를 읽어오는 기능
     *
     * @param storeDTO SPK 필수
     * @return ArrayList<ReviewDTO>
     * @Author 김남주
     */
    public ArrayList<ReviewDTO> readReviewbyStore(StoreDTO storeDTO) throws IOException {
        ArrayList<ReviewDTO> results = new ArrayList<>();

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/review/readStore");

        // DTO Body에 담기
        String json = gson.toJson(storeDTO);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        ArrayListReviewDto resultArray = gson.fromJson(result, ArrayListReviewDto.class);
        for (ReviewDTO item : resultArray.getReviewDTOArrayList()) {
            results.add(item);
        }

        return results;
    }

    /**
     * Review PK 하나로 해하하는 리뷰를 삭제하는 기능
     *
     * @param reviewDTO RPK 필수
     * @return NULL
     * @Author 김남주
     */
    public void deleteReview(ReviewDTO reviewDTO) throws IOException {
        // HTTP POST 객체 생성
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/review/delete");

        // DTO Body에 담기
        String json = gson.toJson(reviewDTO);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);
    }

    /**
     * Review PK 하나로 해당하는 리뷰를 읽어오는 기능
     *
     * @param reviewDTO RPK 필수
     * @return ReviewDTO 다 채우진 필드
     * @Author 김남주
     */
    public ReviewDTO readReview(ReviewDTO reviewDTO) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SingleTon.getBaseURL() + "/review/read");
        // TODO : 리뷰 하나 읽는 메소드 작성
        // DTO Body에 담기
        String json = gson.toJson(reviewDTO);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        // HTTP POST 요청하기
        HttpResponse response = client.execute(httpPost);

        // 결과 반환
        String result = EntityUtils.toString(response.getEntity());
        return gson.fromJson(result, ReviewDTO.class);
    }

}
