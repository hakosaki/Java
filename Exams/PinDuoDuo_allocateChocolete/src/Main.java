import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/**
 * n个小朋友，每个小朋友要w[i]重量的巧克力
 * m块巧克力，重量h[i]
 * 能满足的数量
 * 输入n 3
 * w[i] 2 2 3
 * m 2
 * h[i] 3 1
 * 输出 1
 * */
public class Main {
    public int allocateChocolate(int[] arr1,int[] arr2){
        if(arr1==null||arr2==null||arr1.length<=0||arr2.length<=0)
            return Integer.MIN_VALUE;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            for(int j=arr1.length-1;j>=0;j--){
                if(arr2[i]>=arr1[j]){
                    if(map.containsKey(j))
                        continue;
                    else {
                        map.put(j, arr2[i]);
                        break;
                    }
                }
            }
        }
        return map.size();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] s1 = scanner.nextLine().split(" ");
        int m = Integer.parseInt(scanner.nextLine());
        String[] s2 = scanner.nextLine().split(" ");
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for(int i=0;i<n;i++)
            arr1[i] = Integer.parseInt(s1[i]);
        for(int i=0;i<m;i++)
            arr2[i] = Integer.parseInt(s2[i]);
        Main main = new Main();
        System.out.println(main.allocateChocolate(arr1,arr2));
    }
}
