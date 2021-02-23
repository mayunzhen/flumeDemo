package com.myz.flume.source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author mayunzhen
 * @version 1.0
 * @date 2021/2/5 10:34
 * @desc
 */
public class FlumeTcpDemo {
    public static void main(String[] args) throws Exception{
      while (true){
          Socket socket = new Socket("access.szautopilot.com",59004);
          OutputStream os = socket.getOutputStream();

          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
          bw.write("mayun\n");
          bw.flush();
          bw.close();
          Thread.sleep(3000);
      }
    }
}
