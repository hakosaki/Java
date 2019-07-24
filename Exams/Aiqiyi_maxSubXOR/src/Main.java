import java.util.Scanner;

public class Main {
    /**
     * 连续子序列中，最大值和次大值异或值，求最大异或值
     *
     * 遍历arr，每个i找前第一个比他大求异或，找后一个比他大求异或，存较大异或
     * */
    public int maxSubXOR(int n,int[] arr){
        if(arr==null||n==0)
            return 0;
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[i]){
                    res = Math.max(res,arr[j]^arr[i]);
                    break;
                }
            }
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    res = Math.max(res,arr[j]^arr[i]);
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.println(m.maxSubXOR(n,arr));
    }
}
