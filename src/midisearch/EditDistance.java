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

import java.util.HashMap;
public class EditDistance {
    public String [] MidiFiles = {
        "amazing_pi",
        "amazing_pi_no",
        "amazing_pi_2",
        "arabesuku_1_",
        "arabesuku_1_2",
        "arabesuku_1_2_no",
        "arabesuku_2_pi",
        "arabesuku_2_pi_no",
        "arabesuku_2_pi_2",
        "durand_Chaconne",
        "durand_Chaconne_2",
        "durand_Chaconne_2_no",
        "faure_sicilienne",
        "faure_sicilienne_no",
        "faure_sicilienne_2",
        "gennsousokkyokyoku_pi",
        "gennsousokkyokyoku_pi_2",
        "gennsousokkyokyoku_pi_2_no",
        "hangariabukyoku_5_pi",
        "hangariabukyoku_5_pi_no",
        "hangariabukyoku_5_pi_2",
        "je_te_veux_pi",
        "je_te_veux_pi_2",
        "je_te_veux_pi_2_no",
        "kokken",
        "kokken_2",
        "kokken_2_no",
        "la_campanella_pi",
        "la_campanella_pi_2",
        "mizunotawamure",
        "mizunotawamure_2",
        "promenade",
        "promenade_2",
        "promenade_2_no",
        "salute_deamor_pi",
        "salute_deamor_pi_2",
        "shuyo_hitononozominoyorokobiyo_s_pi",
        "shuyo_hitononozominoyorokobiyo_s_pi_2",
        "vexations_pi",
        "vexations_pi_2"
    };
    public String s[][] ={
        {"A5", "D6", "A5", "A5", "C5"," F5", "C5", "C5", "A#4", "A4", "G4", "F4", "C4", "C4"},//1
        {"A5", "D6", "A5", "A5", "C5", "F5", "C5", "C5", "A#4", "A4", "G4", "F4", "C4", "C4"},//2
        {"C4", "F4", "F4", "A4", "G4", "F4", "A4", "A4", "G4", "F4", "D4","C4"},//3
        {"C#4", "E4", "A4", "C#5", "E5", "F#5", "G#5", "D#5", "B4", "G#4", "D#4", "B3", "A3", "C#4", "F#4", "A4", "C#5", "D#5", "E5", "B4", "G#4", "E4", "B3", "G#3", "C#4", "F#4", "C#4", "C#4", "F#4", "A4"},//4
        {"E4", "C#5", "A#4", "C#5", "A#4", "G#4", "E5", "C#5", "E5", "C#5", "G#5", "F#5", "G#5", "F#5", "G#5", "F#5", "G#5", "F#5", "G#5"},//5
        {"E4", "C#5", "A#4", "C#5", "A#4", "G#4", "E5", "C#5", "E5", "C#5", "G#5", "F#5", "G#5", "F#5", "G#5", "F#5", "G#5", "F#5", "G#5"},//6
        {"E5", "F#5", "E5", "A4", "A5", "B5", "A5", "D5", "E5", "F#5", "E5", "A4", "A5", "B5", "A5", "D5", "E5", "F#5", "E5", "B4", "B5", "C6", "B5", "D5", "E5", "F#5", "E5", "B4", "B5", "C6", "B5", "D5", "E5", "F#5", "E5", "C5", "C6", "D6", "C6", "D5", "E5", "F#5", "E5", "C5", "C6", "D6", "C6", "D5", "E5", "F#5", "E5", "C5", "C6", "D6", "C6", "D5", "E5", "F#5", "E5", "C5", "C6", "D6", "C6", "D5"},//7
        {"E5", "F#5", "E5", "A4", "A5", "B5", "A5", "D5", "E5", "F#5", "E5", "A4", "A5", "B5", "A5", "D5", "E5", "F#5", "E5","B4", "B5", "C6", "B5", "D5", "E5", "F#5", "E5","B4", "B5", "C6", "B5", "D5", "E5", "F#5", "E5", "C5", "C6", "D6", "C6", "D5", "E5", "F#5", "E5", "C5", "C6", "D6", "C6", "D5", "E5", "F#5", "E5", "C5", "C6", "D6", "C6", "D5", "E5", "F#5", "E5", "C5", "C6", "D6", "C6", "D5"},//8
        {"E5", "F#5", "E5", "B4", "D5", "G4", "B4", "C5", "B4", "D4", "A4", "E4", "G4", "A4", "G4", "D4", "C4", "E4", "G4", "B4", "A4", "E4", "A4", "A5", "G4", "A4", "G4", "D4", "E4", "G4", "B4", "A4", "E4", "A4", "A5", "A5", "B5", "A5", "F#5", "D5", "B4", "A4", "B4", "A4", "F#4", "D4", "B3", "A3", "D4", "B3", "C#4", "F#4", "D4", "A3"},//9
        {"E5", "F#5", "E5", "B4", "D5", "G4", "B4", "C5", "B4", "D4", "A4", "E4", "G4", "A4", "G4", "D4", "C4", "E4", "G4", "B4", "A4", "E4", "A4", "A5", "G4", "A4", "G4", "D4", "E4", "G4", "B4", "A4", "E4", "A4", "A5", "A5", "B5", "A5", "F#5", "D5", "B4", "A4", "B4", "A4", "F#4", "D4", "B3", "A3", "D4", "B3", "C#4", "F#4", "D4", "A3"},//10
        {"E5", "F#5", "E5", "B4", "D5", "G4", "B4", "C5", "B4", "D4", "A4", "E4", "G4", "A4", "G4", "D4", "C4", "E4", "G4", "B4", "A4", "E4", "A4", "A5", "G4", "A4", "G4", "D4", "E4", "G4", "B4", "A4", "E4", "A4", "A5", "A5", "B5", "A5", "F#5", "D5", "B4", "A4", "B4", "A4", "F#4", "D4", "B3", "A3", "D4", "B3", "C#4", "F#4", "D4", "A3"},//11
        {"E4", "F#4", "G4", "A4", "B4", "C5", "D5", "E5", "F5", "E5", "D5", "F5", "E5", "D5", "C5", "B4", "D5", "C5", "B4", "A4", "G#4", "B4", "A4", "G#4", "A4"},//12
        {"E5", "E5", "D5", "E5", "F5", "G5", "A5", "G5", "F5", "G5", "F5", "E5", "D5", "D5", "C5", "D5", "E5", "F5", "G5", "F5", "E5", "F5", "E5", "D5", "C5", "C5", "B4", "C5", "D5", "E5", "F5", "E5", "D5", "E5", "D5", "C5"},//13
        {"E5", "E5", "D5", "E5", "F5", "G5", "A5", "G5", "F5", "G5", "F5", "E5", "D5", "D5", "C5", "D5", "E5", "F5", "G5", "F5", "E5", "F5", "E5", "D5", "C5", "C5", "B4", "C5", "D5", "E5", "F5", "E5", "D5", "E5", "D5", "C5"},//14
        {"D4", "G4", "A#4", "D5", "G5", "A#5", "A5", "G5", "A5"},//15
        {"D4", "G4", "A#4", "D5", "G5", "A#5", "A5", "G5", "A5"},//16
        {"B4", "G4", "A4", "A#4", "C5", "C#5", "D5", "D#5", "F5", "G5", "D5", "A#4", "G4", "A4", "A#4", "C5", "C#5", "D5", "E5", "F#5", "G5", "B4", "G4", "A4", "A#4", "C5", "C#5", "D5", "D#5", "F5", "G5", "D5", "A#4", "G4", "A4", "A#4", "C5", "C#5", "D5", "E5", "F#5", "G5"},//17
        {"G#5", "F#5", "F5", "F#5", "C#5", "D#5", "E5", "G#5", "G#5", "F#5", "F5", "F#5", "F5", "F#5", "A5", "G#5", "G#5", "F#5", "F5", "F#5"},//18
        {"C#4", "F#4", "A4", "F#4", "F4", "F#4", "G#4", "F#4"},//19
        {"C#4", "F#4", "A4", "F#4", "F4", "F#4", "G#4", "F#4"},//20
        {"C#6", "C#6", "D6", "C#6", "B5", "A#5", "B5", "C#6", "B5", "A#5", "C6", "B5"},//21
        {"E4", "G4", "D4", "C4", "E4", "B3"},//22
        {"E3", "G3", "D4", "C4", "E4", "B3", "A3", "B3", "A3", "E3", "B3", "D3", "E3", "G3"},//23
        {"E3", "G3", "D4", "C4", "E4", "B3", "A3", "B3", "A3", "E3", "B3", "D3", "E3", "G3"},//24
        {"F#6", "A#6", "C#6", "F#6", "D#6", "F#6", "C#6", "F#6", "A#6", "C#6", "F#5", "A#5", "F#5", "A#5", "C#5", "F#5", "D#5", "F#5", "C#5", "F#5", "A#4", "C#5", "F#4", "A#4", "C#4", "C#5", "G#4", "C#5", "G#4", "G#5", "G#4", "G#5", "D#5", "G#5", "D#5", "D#6", "D#5", "D#6", "G#5", "D#6", "G#5", "G#6", "G#5", "G#6", "C#6", "G#6", "C#6", "C#7"},//25
        {"G#6", "A#6", "G#6", "D#6", "D#7", "D#6", "C#6", "D#6", "C#6", "G#5", "G#6", "G#5", "G#5", "A#5", "G#5", "D#5", "D#6", "D#5", "C#5", "D#5", "C#5", "G#4", "D#5", "G#5", "A#5", "G#5", "D#5", "C#5", "G#5", "C#6", "D#6", "C#6", "G#5", "G#5", "D#6", "G#6", "A#6", "G#6", "D#6", "C#6", "G#6", "C#7", "D#7", "C#7", "A#6", "G#6", "A#6", "G#6", "D#6", "D#7", "D#6", "C#6", "D#6", "C#6", "G#5", "G#6", "G#5", "G#5", "A#5", "G#5", "D#5", "D#6", "D#5", "C#5", "D#5", "C#5", "G#4"},//26
        {"G#6", "A#6", "G#6", "D#6", "D#7", "D#6", "C#6", "D#6", "C#6", "G#5", "G#6", "G#5", "G#5", "A#5", "G#5", "D#5", "D#6", "D#5", "C#5", "D#5", "C#5", "G#4", "D#5", "G#5", "A#5", "G#5", "D#5", "C#5", "G#5", "C#6", "D#6", "C#6", "G#5", "G#5", "D#6", "G#6", "A#6", "G#6", "D#6", "C#6", "G#6", "C#7", "D#7", "C#7", "A#6", "G#6", "A#6", "G#6", "D#6", "D#7", "D#6", "C#6", "D#6", "C#6", "G#5", "G#6", "G#5", "G#5", "A#5", "G#5", "D#5", "D#6", "D#5", "C#5", "D#5", "C#5", "G#4"},//27
        {"D#4", "D#4", "D#4", "D#6", "D#6", "D#6", "D#4", "D#4", "D#4", "D#6", "D#6", "D#6", "D#4", "D#6", "D#6", "D#4", "D#6", "D#6", "D#5", "D#6", "D#6", "C#6", "B5", "B5", "A#5", "G#5", "G5", "G#5", "A#5", "D#5", "D#5", "E5", "D#5", "C#5"},//28
        {"C#5", "B4", "A#4", "C4", "F#4", "B4", "D#5", "C#5", "C5", "C#5", "F#4", "C#5", "E5", "D#5", "D5", "D#5", "B4", "D#5", "D5", "D#5", "C#5", "D#5", "C5", "D#5", "B4", "F5", "D#5", "D5", "D#5", "A#5", "D#5", "F#5", "F5", "E5", "F5", "A#4", "F5", "G#5", "F#5", "F5", "F#5", "D#5", "F#5", "F5", "F#5", "E5", "F#5", "D#5", "F#5", "D5", "G#5", "F#5", "F5", "F#5", "C#5", "F#5", "A#5", "G#5", "G5", "G#5", "C#5", "G#5"},//29
        {"D#5", "G#5", "D#6", "F#6", "D#6", "G#5", "C#5", "G#5", "C#6", "E6", "D#5", "G#6", "D#6", "F#6", "D#6", "G#5", "C#5", "G#5", "C#6", "E6", "D#5", "G#5", "D#6", "F#6", "G#5", "D#6", "G#6", "B6", "G#5", "C#6", "G#6", "C#7", "G#6", "C#6", "F#5", "C6", "E6", "G#6", "G#5", "C#6", "G#6", "C#7", "G#6", "C#6", "F#5", "C6", "E6", "G#6", "G#5", "C#6", "G#6", "C#7", "F#5", "C6", "E6", "G#6", "D5", "G#5", "C6", "E6", "C#6", "A5", "F5", "B4", "G#4", "D5", "F#5", "A#5", "G5", "D5", "B4", "F4", "D4", "G#4", "C5", "E5", "C5", "G#4", "F4", "G4", "B4", "D5", "G5", "D4", "G#4", "C5", "E5", "C5", "G#4", "F4", "G4", "B4", "D5", "G5", "D4", "G#4", "C5", "E5", "C5", "G#4", "D4", "E4", "D4", "C4", "D4", "E4", "G#4", "A#4", "C5", "D5", "E5", "F#5", "A5", "B5", "G5", "B4", "C#5", "D#5", "F5", "G5", "A5", "B5", "C#6"},//30
        {"C#6", "D#6", "C#6", "F#6", "D#6", "C#6", "G#5", "G#5", "F#5", "C#5", "D#5", "C#5", "F#5", "D#5", "C#5", "G#4", "G#4", "F#4", "B2", "C#3", "E3", "A3", "B3", "C#4", "E4", "A4", "B3", "C#4", "E4", "A4", "E5","A4", "E4", "C#4", "B3", "C#4", "E4", "A4", "B3", "C#4", "E4", "A4", "B3", "C#4", "E4", "A4", "B3", "C#4", "E4", "4", "A3", "C#4", "E4", "A3", "C#4", "E4", "F#3", "A3", "C#4", "E4", "C#4", "A3", "F#3", "E3", "F#3", "A3", "C#4", "A3", "F#3", "E3", "C#3", "E3", "F#3", "A3", "F#3", "E3", "C#3"},//31
        {"G4", "F4", "A#4", "C5", "F5", "D5", "C5", "F5", "D5", "A#4", "C5", "G4", "F4", "G4", "F4", "A#4", "C5", "F5", "D5", "C5", "F5", "D5", "A#4", "C5", "G4", "F4", "F4", "G4", "D4", "F4", "G4", "C4", "G4", "A4", "F4", "F5", "D5", "C5", "A#4", "F4", "F4", "G4", "D4", "F4", "G4", "D#4", "A#4", "C5", "G#4", "G#5", "F5", "D#5", "C#5", "G#4"},//32
        {"A5", "E5", "F5", "A5", "D5", "A5", "D5", "F5", "C5", "D5", "F5", "D5", "F5", "C5", "D5", "C5", "A4", "A#4", "C5", "A4", "A#4", "D5", "C5", "A4", "C5", "F5", "D#5", "D5", "C5", "A#4"},//33
        {"A5", "E5", "F5", "A5", "D5", "A5", "D5", "F5", "C5", "D5", "F5", "D5", "F5", "C5", "D5", "C5", "A4", "A#4", "C5", "A4", "A#4", "D5", "C5", "A4", "C5", "F5", "D#5", "D5", "C5", "A#4"},//34
        {"G#5", "B4", "G#5", "F#5", "E5", "D#5", "E5", "A5", "A5"},//35
        {"G5", "F#5", "E5", "C5", "D5", "E5", "F#5", "E5", "D5", "B4", "C5", "D5", "E5", "F#5", "G5", "A5", "B5", "C6", "D6", "F#6", "E6", "D6", "C6"},//36
        {"G4", "A4", "B4", "D5", "C5", "C5", "E5", "D5", "D5", "G5", "F#5", "G5", "D5", "B4", "G4", "A4", "B4", "C5", "D5", "E5", "D5", "C5", "B4", "A4", "B4", "G4", "F#4", "G4", "A4", "D4", "F#4", "A4", "C5", "B4", "A4"},//37
        {"B4", "C5", "D5", "D5", "C5", "B4", "A4", "D4", "E4", "F#4", "A4", "G4", "A4", "C5"},//38
        {"D#5", "F5", "E5", "G5",  "F#5"},//39
        {"C5", "A#4", "B4", "D#5", "C5", "A4", "A#4", "A4", "G#4", "A4", "C5", "D5"},//40
        
    };
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
    
	public int compute(String s1[], String s2[]) {
            
		int[][] dp = new int[s1.length + 1][s2.length + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
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
            for (int i=0; i<s.length ;i++) {
                score = compute(notes, s[i]);
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