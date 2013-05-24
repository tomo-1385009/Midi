/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package midisearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
      }
      
      // 後始末
      br.close();
      // エラーがあった場合は、スタックトレースを出力
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
    
    
}
