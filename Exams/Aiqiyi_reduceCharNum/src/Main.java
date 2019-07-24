import java.util.*;

public class Main {
    /**
     * 字符串，价值为每个字符出现次数的平方和
     * 允许减少n个字符，求最小价值
     *
     * 输入 aba 1
     * a:2 b:1 2^2+1=5
     * 减少a一次
     * 1+1=2
     * 输出 2
     * */
    /*
    * HashMap+Interator+sort
    * 时空有点大....
    * */
    public int[] findMostFrequent(char[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        int[] num = new int[map.size()];
        int i = 0;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            int value = (int) entry.getValue();
            num[i++] = value;
        }
        return num;
    }

    public int reduceCharNum(char arr[], int n) {
        int[] res = findMostFrequent(arr);
        int len = res.length;
        for (int i = 0; i < n; i++) {
            Arrays.sort(res);
            res[len - 1]--;
        }
        int pos = 0;
        for(int i = 0; i < len;i++){
            pos+=Math.pow(res[i],2);
        }
        return pos;
    }

    public static void main(String[] args) {
        Main m = new Main();
//        String s = "abacaba";
//        char[] arr = s.toCharArray();
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.nextLine().toCharArray();
        int n = scanner.nextInt();
        System.out.println(m.reduceCharNum(arr,n));
    }
}
