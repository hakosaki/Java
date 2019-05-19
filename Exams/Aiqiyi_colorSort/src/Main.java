import java.util.Scanner;

public class Main {
    /**
     * 一串颜色，Red和Green，要使R全在G左边，最小步数
     * 输入
     * RGRGR
     * 输出
     * 2(RRRGG)
     *
     * 输入
     * RRRGG
     * 输出
     * 2（RRRRR）
     *
     * 输入
     * RRGGG
     * 输出
     * 2（GGGGG）
     *
     * 大佬做法：记录G的数目，遇到R两种选择 1、把前面G都变成R 2、把当前位置变G
     * */
    public int colorSort(String s){
        if(s==null||s.equals(""))
            return 0;
        int n = s.length();
        int countG = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='G')
                countG++;
            else
                count = Math.min(countG,count+1);
        }
        return count;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(m.colorSort(s));
    }
}
