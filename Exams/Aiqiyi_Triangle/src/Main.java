import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 给三个整数，每个都只能减，求能形成三角形的最大周长
     * */
    public int triangle(int[] arr){
        if(arr==null||arr.length!=3)
            return 0;
        Arrays.sort(arr);
        while(arr[0]+arr[1]<=arr[2]){
            arr[2]--;
        }
        return arr[0]+arr[1]+arr[2];
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] arr = new int[3];
        for(int i=0;i<3;i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.println(m.triangle(arr));
    }
}
