import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/*
* 有三只球队，每只球队编号分别为球队1，球队2，球队3，这三只球队一共需要进行 n 场比赛。
* 现在已经踢完了k场比赛，每场比赛不能打平，踢赢一场比赛得一分，输了不得分不减分。
* 已知球队1和球队2的比分相差d1分，球队2和球队3的比分相差d2分，每场比赛可以任意选择两只队伍进行。
* 求如果打完最后的 (n-k) 场比赛，有没有可能三只球队的分数打平
*
* 输入2
* 3 3 0 0
* 3 3 3 3
* 输出yes
* no
* */

/*
题目中只说队伍之间相差的分数，并没有说哪支队伍得分多，哪支队伍得分少。所以，本题应该分4种情况讨论。假设球队1得分为m (m >= 0) ，至少需要need 场比赛才能持平。

当 球队1< 球队2，球队2<球队3 时，得分情况：
        球队1：m
        球队2：m + d1
        球队3：m + d1 + d2 。此时有3 * m = k - d1 - d1 - d2    need = d1 + d2 + d2（此时球队3得分最多，所以球队1还需要赢d1 + d2场，球队2还需要赢d2场）

当 球队1< 球队2，球队2>球队3 时，得分情况：
        球队1：m
        球队2：m + d1
        球队3：m + d1 - d2 。此时有3 * m = k - d1 - d1 + d2    need = d1 + d2 （此时球队2得分最多，所以球队1还需要赢d1场，球队3还需要赢d2场）

当 球队1> 球队2，球队2>球队3 时，得分情况：
        球队1：m
        球队2：m - d1
        球队3：m - d1 - d2 。此时有3 * m = k + d1 + d1 + d2    need = d1 + d1 + d2 （此时球队1得分最多，所以球队2还需要赢d1场，球队3还需要赢d1 + d2场）

当 球队1> 球队2，球队2<球队3 时，得分情况：
        球队1：m
        球队2：m - d1
        球队3：m - d1 + d2 。
        此时有3 * m = k + d1 + d1 - d2  。这时不能确定哪个球队得分最多，还要分情况：
                    当 d1  >= d2 时，球队1得分最多need = d1 + d1 - d2
                    当 d1  <   d2 时，球队3得分最多need = d2 - d1 + d2
* */

/*
* FootballTeam1是错误代码！！！！！！！
* */
public class FootballTeam1 {

    public static void main(String[] args) {
        /*
         * 输入
         * */
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
//      输入为空
        if(string.equals(""))
            return;
//      t不合法
        int t;
        if(string.charAt(0)>'0'&&string.charAt(0)<='9') {
            t = Integer.parseInt(string);
        }else{
            return;
        }
//      System.out.println(t);

        LinkedList<ArrayList<Integer>> list = new LinkedList<>();
        while(t>0){
            string = scanner.nextLine();
            if(string.equals(""))
                return;
            String[] s = string.split(" ");
//          n k d1 d2判断
            ArrayList<Integer> intList = new ArrayList<>(4);
            int n =  Integer.parseInt(s[0]);
            if(n<0||n>Math.pow(10,12)) {
                return;
            }else {
                intList.add(n);
            }
            int k =  Integer.parseInt(s[1]);
            if(k<0||k>n) {
                return;
            }else {
                intList.add(k);
            }
            int d1 =  Integer.parseInt(s[2]);
            if(d1<0||d1>k) {
                return;
            }else {
                intList.add(d1);
            }
            int d2 =  Integer.parseInt(s[3]);
            if(d2<0||d2>k) {
                return;
            }else {
                intList.add(d2);
            }
            list.add(intList);
            t--;
        }
//        System.out.println(arrList);
        /*
         * 数据处理
         * */
        while(!list.isEmpty()){
            ArrayList temp = list.pop();
//          System.out.println(temp);
            /*
             * 错误判断
             * */
           /* if(temp.get(0).equals(temp.get(1))){
                if(temp.get(2).equals(0) && temp.get(3).equals(0)){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }else{
                int d =(int)temp.get(0)-(int)temp.get(1);
                if((d==(int)temp.get(2)+(int)temp.get(3))||(temp.get(2).equals(0) && temp.get(3).equals(0))){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }*/

        }
        /*
         * 输出
         * */
    }
}
