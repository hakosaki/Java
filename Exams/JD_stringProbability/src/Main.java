import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
/*
* 不完全代码
* */
public class Main {
    public static int countString(LinkedList<StringBuilder> list){
        int numString = list.size();
        StringBuilder string = list.peek();
        for(int i=0;i<numString-1;i++){
            StringBuilder subString = list.get(i);
            int start = 0;
            int end = subString.length()-1;
            
        }
    }

    public static void main(String[] args) {
        /*
        * 输入
        * */
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        LinkedList<StringBuilder> list = new LinkedList<>();
        for(int i=0;i<m+1;i++){
            StringBuilder subString = new StringBuilder();
            subString.append(scanner.next());
            list.add(subString);
        }
//        System.out.println(list);
        /*
        * 数据处理
        * */

    }
}
