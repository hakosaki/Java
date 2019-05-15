import java.util.Scanner;

public class Main {
    public int guessGrade(int[] arr){
        if(arr==null||arr.length<3)
            return 0;
        int guessWrong = arr[0] - arr[1];
        int actualWrong = arr[0] - arr[2];
        return Math.min(arr[1],arr[2])+Math.min(guessWrong,actualWrong);
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(s[0]);
        arr[1] = Integer.parseInt(s[1]);
        arr[2] = Integer.parseInt(s[2]);
        System.out.println(m.guessGrade(arr));
    }
}
