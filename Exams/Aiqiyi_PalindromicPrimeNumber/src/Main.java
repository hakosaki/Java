import java.util.Scanner;

public class Main {
    /**
     * 给范围求其中回文素数
     * eg 6， 66， 606， 6666
     * */
    public int PalindromicPrimeNumber(int l,int r){
        int count = 0;
        if(l==1)
            l++;
        while (l<=r){
            if(isPlindromic(l) && isPrime(l))
                count++;
            l++;
        }
        return count;
    }
    private boolean isPrime(int num){
        int i = 2;
        while(i*i<=num) {
            if (num % i == 0)
                return false;
            i++;
        }
        return true;
    }
    private boolean isPlindromic(int num){
        char[] c = Integer.toString(num).toCharArray();
        int i=0,j=c.length-1;
        while(i<=j){
            if(c[i]!=c[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int l = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        System.out.println(m.PalindromicPrimeNumber(l,r));
    }
}
