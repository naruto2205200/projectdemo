package com.example.demo.base;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/9/99:46
 */
public class baiduAPI {
    private static SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("yyyyMMdd");
    public static void main(String[] args) {

        //判断今天是否是工作日 周末 还是节假日

        String httpArg="20190916";
        System.out.println(httpArg);
        String jsonResult = request(httpArg);
//        String res=(String)map.get(f.format(new Date()));
        System.out.println(jsonResult);

        //0 上班 1周末 2节假日
    }



    /**
     * @param
     *            :请求接口
     * @param httpArg
     *            :参数
     * @return 返回结果
     */
    public static String request( String httpArg) {
        String httpUrl="http://www.easybots.cn/api/holiday.php";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?d=" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
//            Map<String,Object> map=JsonUtil.toMap(result);
//            String res=(String)map.get(httpArg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
