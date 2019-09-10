package com.example.demo.base;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zhangxiaofeng
 * @Describetion：判断是工作日还是休息日
 * @date 2019/9/914:32
 */
public class HolidayDemo {

    public static void main(String[] args) {

        getBitefu();
//        String  s1 = getData("http://api.goseek.cn/Tools/holiday?date=20190929");
//        JSONObject json =  getjson(s1);
//        String value=json.get("data").toString();
//        System.out.println(value);
    }

    /**
     * 调用接口判断是工作日还是休息日
     */
    public static void getBitefu(){
        //apikey=123456 是免费接口，每日限制10次
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity("http://tool.bitefu.net/jiari/vip.php?d=20191009&apikey=123456", JSONObject.class);
        System.out.println(forEntity.toString());
        JSONObject body = forEntity.getBody();
        // 格式{"data":2,"status":1}
        System.out.println(forEntity.getBody());
        //1成功返回 0失败返回
        System.out.println(body.get("status").toString());
        // 0上班,1休息日,2节假日
        System.out.println(body.get("data").toString());
    }

    public static  String getData(String addess){
        URL url = null;
        HttpURLConnection httpConn = null;
        BufferedReader in = null;

        StringBuffer sb = new StringBuffer();
        try{
            url = new URL(addess);
            in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8") );
            String str = null;
            while((str = in.readLine()) != null) {
                sb.append( str );
            }
        } catch (Exception ex) {
        } finally{
            try{
                if(in!=null) {
                    in.close();
                }
            }catch(IOException ex) {
            }
        }
        String  data =sb.toString();
        return data;
    }

    //json串转化为json对象
    public static JSONObject getjson(String data) {
        JSONObject json = JSONObject.parseObject(data);
        return json;
    }


}
