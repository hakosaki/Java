import java.io.*;
public class reduceCharNum{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());
        /*
        * 计数代替HashMap+Iterator
        * */
        int[] z = new int[26];
        for (int j = 0; j < s.length(); j++) {
            z[s.charAt(j) - 'a']++;
        }
        /*
        * 找最大代替排序
        * */
        for (int i = 0; i < k; i++) {
            int maxId = 0;
            for (int j = 0; j < 26; j++) {
                if (z[j] > z[maxId])
                    maxId = j;
            }
            z[maxId]--;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.pow(z[i], 2);
        }
        System.out.println(res);
    }
}