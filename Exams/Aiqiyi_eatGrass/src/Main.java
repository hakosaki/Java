import java.util.Scanner;

public class Main {
    /**
     * 牛羊吃草，，每次只能吃4的幂数量草，eg 1 4 16 64，最后不能吃到的输
     *
     * 吃4的整数次幂1、16、64、256、…，尾数有3种情况：1、4、6，模5之后只有1和4两种情况。
     * 即一次只能吃1 (mod 5) 或 4 (mod 5)数量的草。
     *
     * R==0(MOD 5)情况，牛只能吃1(MOD 5)/4(MOD 5) yang赢
     * R==1(MOD 5)/R==4(MOD 5)                    niu赢
     * R==2(MOD 5),牛能把草变成1(MOD 5)/3(MOD 5)  yang赢
     * R==3(MOD 5)                                niu赢
     * */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<t;i++){
            int tmp = Integer.parseInt(scanner.nextLine());
            if(tmp%5==0||tmp%5==2)
                System.out.println("yang");
            else
                System.out.println("niu");
        }
    }
}
