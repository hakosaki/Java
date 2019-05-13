import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*
        * 数据输入
        * */
        Scanner in = new Scanner(System.in);
        int num =in.nextInt();
        int[] a=new int[num-1];
        int[] b=new int[num-1];
        for(int i=0;i<num-1;i++) {
            a[i]=in.nextInt();
            b[i]=in.nextInt();
        }
        /*
        * 数据处理
        * */
        if(num==1) {
            System.out.println(0);
        }
        if(num==2) {
            System.out.println(1);
        }else{
            int[] tree=new int[num];

            for(int i=0;i<num;i++) {
                tree[i]=1;
            }
            for(int k=0;k<num-1;k++) {
                tree[b[num-2-k]-1] = tree[b[num-2-k]-1] + tree[a[num-2-k]-1];
            }

            int max=tree[1];

            for(int i=1;i<num;i++) {
                if(max<tree[i]) {
                    max=tree[i];
                }
            }

            System.out.println(max);
        }
    }
}