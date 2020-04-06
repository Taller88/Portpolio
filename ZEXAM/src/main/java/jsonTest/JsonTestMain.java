package jsonTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;


import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonTestMain {
		//Json URL 호출 
		private static String readAll(Reader rd) throws IOException {
          StringBuilder sb = new StringBuilder();
          int cp;
          while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
          }
          return sb.toString();
        }
		//호출할 json URL 입력(시작메소드)
        public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
          InputStream is = new URL(url).openStream();
          try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
          } finally {
            is.close();
          }
        }

        public static void main(String[] args) throws IOException, JSONException {
           

//          JSONObject json = readJsonFromUrl("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json");
//          System.out.println(json.toString());
//          System.out.println(json.get("storeInfos"));
//          System.out.println("====================================");
          //37.556747, 126.919559
          //JSONObject json1 = readJsonFromUrl("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByGeo/json?lat=37.556789&lng=126.919527&m=300");
          String currentLat="37.556789";	//나중에 주소 api검색시 값을 받아 저장 default=쌍용 
          String currentLng="126.919527";
          JSONObject json1 = readJsonFromUrl("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByGeo/json?lat="+currentLat+"&lng="+currentLng+"&m=300");
          
          JsonParser parser=new JsonParser();
          JsonObject jsonObj=(JsonObject)parser.parse(json1.toString());
          JsonArray memberArray=(JsonArray)jsonObj.get("stores");
          System.out.println("Json 배열 크기: "+memberArray.size());
          for(int i=0; i<memberArray.size(); i++) {
             JsonObject object=(JsonObject)memberArray.get(i);
             System.out.println("일련번호: "+object.get("code"));
             System.out.println("약국명: "+object.get("name"));
             System.out.println("입고시간: "+object.get("stock_at"));
             System.out.println("최신화시간: "+object.get("created_at"));
             System.out.println("약국주소: "+object.get("addr"));
             System.out.println("판매처 형태: "+object.get("type"));
             System.out.println("재고현황: "+object.get("remain_stat"));
             System.out.println("위도: "+object.get("lng"));
             System.out.println("경도: "+object.get("lat"));
             System.out.println();
         }
          
          
          
       }
}