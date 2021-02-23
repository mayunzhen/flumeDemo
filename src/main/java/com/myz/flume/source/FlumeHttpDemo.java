package com.myz.flume.source;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

import com.myz.flume.entity.CarPerception;
import com.myz.flume.utiles.JsonUtil;
import org.apache.flume.event.JSONEvent;
import com.google.gson.Gson;
 /**
 * @author mayunzhen
 * @version 1.0
 * @date 2021/2/4 11:13
 * @desc
 */
public class FlumeHttpDemo {

    private static String urlStr = "http://183.213.26.107:59000";

    public static int cnt = 0;
    public static void main(String[] args) throws InterruptedException {
        CarPerception carPerception = new CarPerception();
        carPerception.setId("0000300804AD90CC");
        carPerception.setTime(1611304709836L);
        carPerception.setLongitude("0");
        carPerception.setLatitude("0");
        carPerception.setSpeed(100);
        carPerception.setHeading(90D);
        carPerception.setPlate("胡A");
        carPerception.setCompany("移动");
        carPerception.setAutodrive(1);
        carPerception.setMotortype(1);
        List<CarPerception.Participant>  participants = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            CarPerception.Participant participant = new CarPerception.Participant();
            participant.setId(i);
            participant.setLane(i*10);
            participant.setLocation(new CarPerception.Participant.Position());
            participant.setOrientation(0.0);
            participant.setSize(new CarPerception.Participant.Size());
            participant.setSpeed(80D);
            participant.setType(3);
            participants.add(participant);
        }
        carPerception.setParticipants(participants);
        while (true){
            String message = JsonUtil.toJson(carPerception);
            String result = sendPost(message);
            System.out.println("send  message : " + cnt+" result:"+result);
           Thread.sleep(2000);
           cnt++;
        }
    }

     public static String sendPost(String param) {
         PrintWriter out = null;
         BufferedReader in = null;
         String result = "";
         try {
             URL realUrl = new URL(urlStr);
             URLConnection conn = realUrl.openConnection();
             conn.setRequestProperty("accept", "*/*");
             conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");  //设定 请求格式 json，也可以设定xml格式的
             // 发送POST请求必须设置如下两行
             conn.setDoOutput(true);
             conn.setDoInput(true);
             // 获取URLConnection对象对应的输出流
             out = new PrintWriter(conn.getOutputStream());
             // 发送请求参数

             JSONEvent jsonEvent = new JSONEvent();
             Map header = new HashMap();
             header.put("timestamp", System.currentTimeMillis());
             header.put("host", "183.213.26.107");
             header.put("topic","test");
             jsonEvent.setBody(param.getBytes("UTF-8"));
             jsonEvent.setHeaders(header);
             Gson gson = new Gson();
             List list = new ArrayList();
             list.add(jsonEvent);

             out.print(gson.toJson(list));
             // flush输出流的缓冲
             out.flush();
             // 定义BufferedReader输入流来读取URL的响应
             in = new BufferedReader(
                     new InputStreamReader(conn.getInputStream()));
             String line;
             while ((line = in.readLine()) != null) {
                 result += line;
             }
         } catch (Exception e) {
             System.out.println("发送 POST 请求出现异常！" + e);
             e.printStackTrace();
         }
         //使用finally块来关闭输出流、输入流
         finally {
             try {
                 if (out != null) {
                     out.close();
                 }
                 if (in != null) {
                     in.close();
                 }
             } catch (IOException ex) {
                 ex.printStackTrace();
             }
         }
         return result;
     }
}
