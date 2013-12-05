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
public class InputTxt1 {
    
public static void main(String[] args) {
    
    // 読み込むファイルの設定
    String inputFileName = "C:\\Users\\tomo\\Documents\\大学院2013\\修論\\MIDI音源\\テキストファイル\\sample_midi_1.txt";
    // ファイルオブジェクトの生成
    File inputFile = new File(inputFileName);
    try {
      // 入力ストリームの生成
      FileInputStream fis = new FileInputStream(inputFile);
      InputStreamReader isr = new InputStreamReader(fis);
      BufferedReader br = new BufferedReader(isr);
      // テキストファイルからの読み込み
      String msg;
      int min = 127;
      int max = 0;
      int ctrnum = 0;
      String value = null;
      String ctrname ="";
      String[] ctname;
      ctname = new String[126];
      
      double sum,sumx2,ave,bunsan,dev;
      sum = sumx2 = ave = bunsan = dev = 0;
      int count_vel,count_mod,count_sus;
      count_vel = count_mod = count_sus = 0;
      while ( ( msg = br.readLine()) != null ) {
          System.out.println(msg);
          
          if(msg.indexOf("control change")!= -1){
            for(int j = 127;j>0;j--){
                ctrname = "control change "+j;
                        if(msg.indexOf(ctrname)!= -1){
                            ctname[j] = ctrname;
                            System.out.println("発見" + ctname[j]);
                            for(int i = 1;i<5; i++){
                                if(" ".equals(msg.substring(msg.length()-i,msg.length()-i+1))){
                                    value = msg.substring(msg.length()-i+1);
                                    break;
                                }
                            }
                            System.out.println("value :" + value);
                           
                            break;
                        }
            }System.out.println("発見＋＋" + ctname[1]);
          }
      }
      // 後始末
      br.close();
      
      String style;
      style = editStyle(max,min,dev,count_sus,count_mod);
      
      
      //計算した標準偏差値などをテキストファイルに出力
      try{
        String Fileoutputname = inputFileName + "_result.txt";
        File file = new File(Fileoutputname);
        FileWriter filewriter = new FileWriter(file);
        
        filewriter.write("name" + ctrname + "\r\n");
        filewriter.write("num" + ctrnum + "\r\n");
        filewriter.write("分散:" + bunsan + "\r\n");
        filewriter.write("標準偏差:" + dev + "\r\n");
        filewriter.write("moduration数:" + count_mod + "\r\n");
        filewriter.write("susutain:" + count_sus + "\r\n");
        filewriter.write("最小値:" + min + "\r\n");
        filewriter.write("最大値:" + max + "\r\n");
        filewriter.write("演奏スタイル:" + style + "\r\n");
        
        filewriter.close();
    }catch(IOException e){
        System.out.println(e);
    }
    }catch(Exception e) {
    }
}


public static int editmin(int vel, int min){
    if(min>vel){
        min = vel;
    }
    return(min);
}

public static int editmax(int vel, int max){
    if(max<vel){
        max = vel;
    }
    return(max);
}

public static String editStyle (int max,int min,double dev,int count_sus,int count_mod){
    String style = "スタイル無し";
    /*演奏スタイルgrand 
     * velocity	最小値80以上 最大値127
     * 標準偏差5から10
     * moduration 0
     * sustain	0
     */
    if(min >= 80){
        if((dev > 5)&&(dev <= 10)){
            if((count_sus == 0)&&(count_mod == 0)){
                style = "grand";
            }
        }
    }
    /*演奏スタイルaltisonante
     * velocity	最小値70 最大値127
     * 標準偏差10から15
     * modulation	1
     * sustain  	0
     */
    else if(min >= 70){
        if((dev > 10) && (dev <= 15)){
            if((count_mod > 0)&&(count_sus == 0)){
                style = "altisonante";
            }
        }
    }
    /*sentito
     * velocity	最小値70以上 最大値127
     * 標準偏差20以上30以内
     * modulation	1
     * sustain  	1
     */
    else if((min >= 70)&&(max <= 127)){
        if((dev >= 20) && (dev <= 30)){
            if((count_mod > 0)&&(count_sus > 0)){
                style = "sentito";
            }
        }
    }
    /*festivo
     * velocity	最小値80 最大値120
     * 標準偏差15超え20以下
     * modulation	0
     * sustain  	1
     */
    else if((min >= 80)&&(max <= 120)){
        if((dev > 15) && (dev <= 20)){
            if((count_mod == 0)&&(count_sus > 0)){
                style = "festivo";
            }
        }
    }
    /*delirante
     * velocity	最小値40 最大値90
     * 標準偏差20以上30以下
     * modulation	0
     * sustain  	0
     */
    else if((min >= 40)&&(max <= 90)){
        if((dev >= 20) && (dev <= 30)){
            if((count_mod == 0)&&(count_sus == 0)){
                style = "delirante";
            }
        }
    }
    /*ardente
     *velocity	最小値50 最大値90
     * 標準偏差15以上20以下
     * modulation	1
     * sustain  	0
      */
    else if((min >= 50)&&(max <= 90)){
        if((dev >= 15) && (dev <= 20)){
            if((count_mod > 0)&&(count_sus == 0)){
                style = "ardente";
            }
        }
    }
    /*pacato
     *velocity	最小値20最大値80
     *標準偏差10から15(≠)
     * modulation	1
     * sustain  	1
     */
    else if((min >= 20)&&(max <= 80)){
        if((dev >= 10) && (dev <= 15)){
            if((count_mod > 0)&&(count_sus > 0)){
                style = "pacato";
            }
        }
    }
    /*schwach
     * velocity	最小値30 最大値70
     * 標準偏差5から10(≠)
     * modulation	0
     * sustain  	1
     */
    else if((min >= 30)&&(max <= 70)){
        if((dev >= 5) && (dev <= 10)){
            if((count_mod == 0)&&(count_sus > 0)){
                style = "shwach";
            }
        }
    }
return style;
}

}
