import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * N个房间，i号房间人重分配，i出来依次给i+1……，X为最后进人房间号，求重分配前人数，
     * 输入
     * 3 1
     * 6 5 1
     * 输出
     * 4 4 4
     * */
    /*
    * 85%，时间复杂度过高
    * */
    public int[] roomAllocate(int[] arr,int n,int x){
        if(arr==null||n<1||n>Math.pow(10,5)||x<1||x>n)
            return null;
        int people = 0;
        while(arr[x-1]!=0){
            arr[x-1]--;
            people++;
            x--;
            if(x<1)
                x=n;
        }
        arr[x-1] = people;
        return arr;
    }
    public long[] roomAllocate1(long[] arr,long min,int n,int x){
        if(arr==null||n<1||n>Math.pow(10,5)||x<1||x>n)
            return null;
        int minPos = x-1;
        while(arr[minPos]!=min){
           minPos = minPos>0?minPos-1:n-1;
        }
        for(int i=0;i<n;i++){
            arr[i] -= min;
        }
        int remain = 0;
        for(int i=x-1;i!=minPos;i=i>0?i-1:n-1){
            arr[i] -= 1;
            remain += 1;
        }
//        System.out.println(remain);
        arr[minPos] += remain + n * min;
        return arr;
    }
    public static void main(String[] args){
        Main m = new Main();
       /* int[] arr = {6,5,1};
        int n = 3;
        int x = 1;
        System.out.println(Arrays.toString(m.roomAllocate(arr,n,x)));*/
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        long[] arr = new long[n];
        long min = Long.MAX_VALUE;
        for(int i=0;i<n;i++) {
            arr[i] = Long.parseLong(s[i]);
            if(min>arr[i])
                min = arr[i];
        }
//        System.out.println(min);
        long[] res = m.roomAllocate1(arr,min,n,x);
        System.out.print(res[0]);
        for(int i=1;i<n;i++)
            System.out.print(" "+res[i]);
    }
}
