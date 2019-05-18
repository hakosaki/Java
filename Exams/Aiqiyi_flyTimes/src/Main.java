import java.util.Scanner;

public class Main {
    /**
     * 数组前n项和小于等于sum，求n
     * */
    public int flyTimes(int[] arr,int s){
        if(arr==null||arr.length==0||s<0)
            return 0;
        int len = arr.length;
        int tmp = 0;
        int i = 0;
        while(i<len && tmp<= s){
            tmp += arr[i];
            i++;
        }
        return i==len?i:i-1;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int s = Integer.parseInt(s1[1]);
        int[] arr = new int[n];
        String[] s2 = scanner.nextLine().split(" ");
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s2[i]);
        System.out.println(m.flyTimes(arr,s));
    }
}
