import sun.security.util.Length;

import java.util.Scanner;

/*
* duplication输出有错 没能够正常传送duplication
* */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||length<=0)
            return false;
        for(int i=0;i<length;i++){
            if(numbers[i]>length-1||numbers[i]<0)
                return false;
        }
        duplication[0] = -1;
        for(int i=0;i<length;i++) {
            while (i != numbers[i]) {
                if(numbers[i]==numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Duplicate d = new Duplicate();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);
        int res[] = new int[1];
        System.out.println(d.duplicate(arr,n,res));
        System.out.println(res[0]);
    }
}
