package midisearch;

/* Copyright (c) 2012 the authors listed at the following URL, and/or
the authors of referenced articles or incorporated external code:
http://en.literateprograms.org/Levenshtein_distance_(Java)?action=history&offset=20110107003949

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

Retrieved from: http://en.literateprograms.org/Levenshtein_distance_(Java)?oldid=17022
*/

import java.util.Arrays;
import java.util.HashMap;
public class EditDistance {
    
    public String [] MidiFiles = {
        "amazing_flb1.mid",
        "amazing_flb2.mid",
        "amazing_flb3.mid",
        "amazing_flb4.mid",
        "amazing_flb5.mid",
        "amazing_flm1.mid",
        "amazing_flm2.mid",
        "amazing_flm3.mid",
        "amazing_flm4.mid",
        "amazing_flm5.mid",
        "amazing_fls1.mid",
        "amazing_fls2.mid",
        "amazing_fls3.mid",
        "amazing_fls4.mid",
        "amazing_fls5.mid",
        "amazing_flx1.mid",
        "amazing_flx2.mid",
        "amazing_flx3.mid",
        "amazing_flx4.mid",
        "amazing_flx5.mid",
        "amazing_fsb1.mid",
        "amazing_fsb2.mid",
        "amazing_fsb3.mid",
        "amazing_fsb4.mid",
        "amazing_fsb5.mid",
        "amazing_fsm1.mid",
        "amazing_fsm2.mid",
        "amazing_fsm3.mid",
        "amazing_fsm4.mid",
        "amazing_fsm5.mid",
        "amazing_fss1.mid",
        "amazing_fss2.mid",
        "amazing_fss3.mid",
        "amazing_fss4.mid",
        "amazing_fss5.mid",
        "amazing_fsx1.mid",
        "amazing_fsx2.mid",
        "amazing_fsx3.mid",
        "amazing_fsx4.mid",
        "amazing_fsx5.mid",
        "amazing_plb1.mid",
        "amazing_plb2.mid",
        "amazing_plb3.mid",
        "amazing_plb4.mid",
        "amazing_plb5.mid",
        "amazing_plm1.mid",
        "amazing_plm2.mid",
        "amazing_plm3.mid",
        "amazing_plm4.mid",
        "amazing_plm5.mid",
        "amazing_pls1.mid",
        "amazing_pls2.mid",
        "amazing_pls3.mid",
        "amazing_pls4.mid",
        "amazing_pls5.mid",
        "amazing_plx1.mid",
        "amazing_plx2.mid",
        "amazing_plx3.mid",
        "amazing_plx4.mid",
        "amazing_plx5.mid",
        "amazing_psb1.mid",
        "amazing_psb2.mid",
        "amazing_psb3.mid",
        "amazing_psb4.mid",
        "amazing_psb5.mid",
        "amazing_psm1.mid",
        "amazing_psm2.mid",
        "amazing_psm3.mid",
        "amazing_psm4.mid",
        "amazing_psm5.mid",
        "amazing_pss1.mid",
        "amazing_pss2.mid",
        "amazing_pss3.mid",
        "amazing_pss4.mid",
        "amazing_pss5.mid",
        "amazing_psx1.mid",
        "amazing_psx2.mid",
        "amazing_psx3.mid",
        "amazing_psx4.mid",
        "amazing_psx5.mid",
        "toiawase_ama1.mid",
        "toiawase_ama2.mid",
        "toiawase_ama3.mid",
        "toiawase_ama4.mid",
        "toiawase_ama5.mid",
        "toiawase_ama6.mid",
        "toiawase_ama7.mid",
        "toiawase_ama8.mid",
        "toiawase_ama9.mid",
        "toiawase_amaC1.mid",
        "toiawase_dore1.mid",
        "toiawase_FF1.mid",
        "toiawase_neko1.mid",
        "toiawase_neko2.mid",

    };
    public String s[][] ={
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って","表情豊かに","高らかに響かせて",},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って","表情豊かに"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って","勢いのない"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って","勢いのない"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"表情豊かに"},
        {"大きさを持って","表情豊かに"},
        {"表情豊かに"},
        {"表情豊かに"},
        {"表情豊かに"},
        {"表情豊かに"},
        {"表情豊かに","高らかに響かせて"},
        {"表情豊かに","高らかに響かせて"},
        {"大きさを持って","表情豊かに"},
        {"該当なし"},
        {"荒々しく","怒り狂って"},
        {"大きさを持って","表情豊かに"},
        {"表情豊かに"},
        {"大きさを持って","荒々しく","怒り狂って",},
        {"大きさを持って","表情豊かに"},
        {"大きさを持って","表情豊かに"},
        {"大きさを持って","表情豊かに"},
        {"大きさを持って","荒々しく","怒り狂って","落ち着いた"},
        {"大きさを持って","表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに","高らかに響かせて",},
        {"静かな","勢いのない"},
        {"静かな","勢いのない"},
        {"静かな","勢いのない"},
        {"静かな","表情豊かに"},
        {"静かな","勢いのない"},
        {"静かな"},
        {"静かな","勢いのない"},
        {"表情豊かに"},
        {"静かな","表情豊かに"},
        {"大きさを持って","表情豊かに"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って"},
        {"大きさを持って","勢いのない"},
        {"大きさを持って"},
        {"荒々しく","高らかに響かせて"},
        {"表情豊かに"},
        {"静かな","勢いのない"},
        {"荒々しく"},
        {"荒々しく","高らかに響かせて"},
        {"表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに"},
        {"表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに"},
        {"表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","表情豊かに"},
        {"静かな","勢いのない"},
        {"大きさを持って","表情豊かに"},
        {"荒々しく"},
        {"大きさを持って","荒々しく","怒り狂って","落ち着いた"},
        {"静かな","表情豊かに"},
        {"表情豊かに"},
        {"大きさを持って","表情豊かに"},
        {"荒々しく"},
        {"大きさを持って","表情豊かに"},
        {"荒々しく","怒り狂って","落ち着いた",},
        {"荒々しく"},
        {"大きさを持って"},
        {"大きさを持って","表情豊かに"},
        {"静かな","荒々しく"},
        {"荒々しく","怒り狂って"},

        
    };
    private int j;
    public int compute(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = i == 0 ? j : j == 0 ? i : 0;
				if (i > 0 && j > 0) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1];
					else
						dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(
								dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1));
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
    
//        public int compute(String s1[], String s2[]) {
//            
//                String a ="";
//                int point = 0;
//		int[][] dp = new int[s1.length + 1][s2.length + 1];
//
//		for (int i = 0; i < s1.length; i++) {
//			for (int j = 0; j < s1.length; j++) {
//                            System.out.println("key=" + s1[0]);
//                            System.out.println("musi=" + s2[0]);
//                            a = Arrays.deepToString(s[i]);
//                            if(s1[0].indexOf(s2[0])!= -1){
////                                if(s1[1].indexOf(s2[1])!= -1){
////                                    System.out.println("s2[1]=" + s1[0]);
////                                    point=11;
////                                }
//                                point ++; 
//                            }
//                            
//			}
//		}
//		return point;
//	}
    
	public int compute(String s1[], String s2[]) {
            
            
		int[][] dp = new int[s1.length + 1][s2.length + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
                            if(s1[0].indexOf(s2[0])!= -1){
////                                if(s1[1].indexOf(s2[1])!= -1){
////                                    System.out.println("s2[1]=" + s1[0]);
////                                    point=11;
                                return 0;
                            }
				dp[i][j] = i == 0 ? j : j == 0 ? i : 0;

				if (i > 0 && j > 0) {
                                    
					if (s1[i-1] == s2[j-1])
						dp[i][j] = dp[i - 1][j - 1];
                                                
					else 
						dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(
								dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1));
				}
			}
		}
                
		return dp[s1.length][s2.length];

                
	}
        
        public HashMap<String, Integer> search(String [] notes) {
            HashMap<String, Integer> results = new HashMap<String, Integer>();
            Integer score = 0;
//            String style = "";
            for (int i=0; i<s.length ;i++) {
                System.out.println("s[i]="+Arrays.deepToString(s[i]));
                score = compute(notes, s[i]);
//                System.out.println(score);
//                style = s[1][1];
//                System.out.println("key=" + Arrays.deepToString(notes));
                results.put(MidiFiles[i], score);
            }
            return results;
        }
	public static void main(String[] args) {
 		EditDistance distance = new EditDistance();
//              System.out.println(distance.compute("vintner", "writers"));
//		System.out.println(distance.compute("vintners", "writers"));
//		System.out.println(distance.compute("vintners", ""));
//		System.out.println(distance.compute("", ""));
              
//              for (int i=0; i<distance.s[1].length; i++) {    テスト用
//                System.out.print(distance.s[1][i]);
//              }
//              String [][] teststr = {{"v", "i", "n", "t", "n", "e", "r"}, {"w", "r", "i", "t", "e", "r", "s"}};
//              System.out.println(distance.compute(teststr[0], teststr[1]));
//                System.out.println(distance.compute(distance.s[18], distance.s[19])); 
        }
}