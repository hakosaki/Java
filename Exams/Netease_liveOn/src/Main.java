import java.util.Scanner;

public class Main {
//    房租 水果 钱 水果价格
    /**
     * 小易活下去
     * 输入 3 5 100 10
     * （房租 水果 钱 水果价格）
     * 输出 11（能活11天）
     * */
    public int liveOn(int[] arr){
        if(arr==null||arr.length<=3)
            return 0;
        int day = 0;
        int rent = arr[0];
        int fruit = arr[1];
        int moneny = arr[2];
        int fee = arr[3];
//        边界条件：money不能>0，而是>=rent
        for(;fruit>0&&moneny>=rent;moneny -= rent,fruit--)
            day++;
//        边界条件：money不能>0，而是>=rent+fee
        for(;moneny>=rent+fee;moneny=moneny-rent-fee)
            day++;
        return day;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] arr = new int[s.length];
        for(int i=0;i<s.length;i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.print(m.liveOn(arr));
    }
}
