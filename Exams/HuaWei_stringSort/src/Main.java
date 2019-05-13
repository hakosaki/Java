import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * 输入N个字符串，空格隔开，每个字符串取8位截断，不足补0，升序输出字符串
 * 输入 2 abc 123456789
 * 输出 12345678 90000000 abc00000
 * */
public class Main {
    public static void main(String[] args) {
        /*
         * 输入
         * */
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            arr[i] = in.next();
        }
        /*
         * 数据处理
         * */
        ArrayList<String> arrList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String everyarr = arr[i];
            while (everyarr.length() > 8) { // 判断字符串长度
                arrList.add(everyarr.substring(0, 8));// 截取前0-7
                everyarr = everyarr.substring(8, everyarr.length());// 截取后几位
            }
            if (everyarr.length() != 8) {// 判断后几位的长度是否等于8
                String newStr = String.format("%1$0" + (8 - everyarr.length()) + "d", 0);
//              第一项补0（8 - everyarr.length()）d个0
                String tmp = everyarr + newStr;
                arrList.add(tmp);
            } else {
                arrList.add(arr[i]);
            }
        }
        Collections.sort(arrList);
        /*
         * 输出
         * */
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i)+" ");
        }
    }
}