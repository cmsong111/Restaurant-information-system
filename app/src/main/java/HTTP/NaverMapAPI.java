package HTTP;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class NaverMapAPI {
    JSONParser parser = new JSONParser();

    public String getStaticMAP(double locationX, double locationY) throws URISyntaxException, IOException, ParseException {

        Reader reader = new FileReader("./NaverAPI-KEY.json");

        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        reader.close();

        HttpClient Client = HttpClientBuilder.create().build();
        String baseURL = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster";

        // URL 생성
        HttpGet httpget = new HttpGet(baseURL);
        URI uri = new URIBuilder(httpget.getURI())
                .addParameter("w", "750")
                .addParameter("h", "450")
                .addParameter("center", String.valueOf(locationX) + "," + String.valueOf(locationY))
                .addParameter("level", "14")
                .addParameter("scale", "2")
                .addParameter("markers","pos:"+String.valueOf(locationX) + " " + String.valueOf(locationY))
                .build();
        httpget.setURI(uri);
        httpget.setHeader("X-NCP-APIGW-API-KEY-ID",jsonObject.get("X-NCP-APIGW-API-KEY-ID").toString());
        httpget.setHeader("X-NCP-APIGW-API-KEY",jsonObject.get("X-NCP-APIGW-API-KEY").toString());

        // HTTP GET method 실행
        HttpResponse response = Client.execute(httpget);


        BufferedInputStream bInStr = new BufferedInputStream(response.getEntity().getContent()); // Buffered Stream 이용: fast down

        BufferedOutputStream bOutStr = new BufferedOutputStream(new FileOutputStream(new File(".\\location_Image.jpg"))); // Buffered  Stream
        int inpByte;
        while ((inpByte = bInStr.read()) != -1) {
            bOutStr.write(inpByte);
        }

        bInStr.close();
        bOutStr.close();
        return "http get 완료";
    }
}
