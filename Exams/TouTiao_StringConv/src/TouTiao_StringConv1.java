import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 利用前缀和数组
 * 例如：
 * n=10,m=1,s=baabaabaab
 *   b a a b a a b a a b
 *   0 1 2 3 4 5 6 7 8 9
 *
 *   将 b-->a
 *   b 的前缀和数组为
 *          sums={ 0, 3, 6, 9, 10}//10 为字符串长度
 *   计算长度分别为:
 *          3  6-0-1=5   9-3-1=5  10-6-1=3
 *     ==>>max = max{ max, sums[i]-sum[i-m-1]-1}
 */

public class TouTiao_StringConv1 {
    public static int change(int n, int m, String s, char k) {
        int max = 0;
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == k) {
                sums.add(i);
            }
        }
        if (sums.size() <= m) {
            return n;
        }
        sums.add(s.length());
        max = sums.get(m);
        for (int i = m + 1; i < sums.size(); i++) {
            max = Integer.max(max, sums.get(i) - sums.get(i - m - 1) - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        System.out.println(Integer.max(change(n, m, s, 'a'), change(n, m, s, 'b')));
    }
}