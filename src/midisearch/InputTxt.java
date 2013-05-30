/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package midisearch;

import java.io.*;
/**
 *
 * @author tomo
 */
public class InputTxt {
    
public static void main(String[] args) {
    
    // 読み込むファイルの名前
    String inputFileName = "amazing_sample.txt";
    // ファイルオブジェクトの生成
    File inputFile = new File(inputFileName);
    try {
      // 入力ストリームの生成
      FileInputStream fis = new FileInputStream(inputFile);
      InputStreamReader isr = new InputStreamReader(fis);
      BufferedReader br = new BufferedReader(isr);
      // テキストファイルからの読み込み
      String msg;
      while ( ( msg = br.readLine()) != null ) {
          System.out.println(msg);
          //Velocityの抽出
          if(msg.indexOf("velocity")!= -1){
              if(msg.indexOf("wheel")!= -1){
              }
              
              else {
                  System.out.println("velocity発見");
                  //Velocityの大きさを文字列の中から選んで整数型に変更
                  for(int i = 1;i<5; i++){
                      if(" ".equals(msg.substring(msg.length()-i,msg.length()-i+1))){
                        System.out.println("String:" + msg.substring(msg.length()-i+1));
                        String dev = msg.substring(msg.length()-i+1);
                        int x = Integer.parseInt(dev);
                        System.out.println("int:" + x);
                        break;
                        }
                      }
                  }
              }
          
          //control changeの抽出
          else if(msg.indexOf("control change")!= -1){
              System.out.println("control change発見");
              if(msg.indexOf(":64")!= -1){
                  System.out.println("mosulation発見");
              }
              else if(msg.indexOf(":1")!= -1){
                  System.out.println("sustain発見");
              }
          }
      
      }
      
      // 後始末
      br.close();
      
      //計算した標準偏差値などをテキストファイルに出力
      try{
        String Fileoutputname = inputFileName + "_output.txt";
        File file = new File(Fileoutputname);
        FileWriter filewriter = new FileWriter(file);
        
        filewriter.write("test\r\n");
        filewriter.write("test2");
        filewriter.write("test3");
        
        filewriter.close();
    }catch(IOException e){
        System.out.println(e);
    }
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
    
    
}
