import java.util.LinkedList;
import java.util.Scanner;
/*
* 输入整数n,依次将后面数组前n个数串在一起，不够n则串完跳至下一行，直至全部串完
* 输入 2
* 1,2,3,4
* 7,8,9,10
* 输出1,2,7,8,3,4,9,10
*
* 输入 3
* 1
* 2,3,4
* 输出
* 1,2,3,4
* */
public class Main {
    public static void main(String[] args) {
/*
* 输入
* */
        LinkedList<LinkedList<String>> strList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

//      健壮性-输入为空
        if(string.equals(""))
            return;
//      健壮性—n非法
        int n;
        if('0'<string.charAt(0)&&string.charAt(0)<='9') {
            n = Integer.parseInt(string);
        }else {
           return;
        }
//        System.out.println(n);
        while(true) {
            string = scanner.nextLine();
            if (string.equals("")) {
                break;
            } else {
                String[] s = string.split(",");
                LinkedList<String> charList = new LinkedList<>();
                for (int i = 0; i < s.length; i++) {
                    charList.add(s[i]);
                }
                strList.add(charList);
            }
        }
//        System.out.println(strList);
/*
* 循环处理数据
* */
        LinkedList<String> result = new LinkedList<>();
        while(!strList.isEmpty()){
            LinkedList<String> tmp = strList.pop();
//            System.out.println(tmp);
            for(int i=0;i<n;i++ ){
                if(!tmp.isEmpty()) {
                    result.add(tmp.pop());
                }
                else
                    break;
            }
            if(!tmp.isEmpty())
                strList.add(tmp);
        }
/*
* 输出
* */
//      健壮性-输出为空
        if(!result.isEmpty()) {
            System.out.println(result);
        }else
            return;
    }
}
