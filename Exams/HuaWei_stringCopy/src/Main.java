import java.util.Scanner;
import java.util.Stack;
/*
* 输入字符串，将数字n后括号内字符串复制n次，不存在数字后没括号情况，不存在括号不匹配情况，括号有([{
* 输入 3(a2(b))
* 输出 abbabbabb
*
* 输入 4(a)
* 输出 aaaa
* */
public class Main {
    public static String stringCopy(String string){
        StringBuilder newString = new StringBuilder();
        int pos = 0;
        Stack<Integer> count = new Stack<>();
        Stack<Integer> start = new Stack<>();
        while (pos!= string.length()){
            if(string.charAt(pos)>='0' && string.charAt(pos)<='9') {
                StringBuilder tmp = new StringBuilder();
                while (string.charAt(pos) >= '0' && string.charAt(pos) <= '9') {
                    tmp.append(string.charAt(pos));
                    pos++;
                }
                count.add(Integer.parseInt(tmp.toString()));
                pos++;
                start.add(pos);
            }else if(string.charAt(pos) == ')'||string.charAt(pos) == ']'||string.charAt(pos) == '}'){
                int currCount = count.pop();
                int currStart = start.pop();
                String s = string.substring(currStart,pos);
                for(int i = 0;i < currCount-1;i++){
                    newString.append(s);
//                  System.out.println(newString);
                }
                pos++;
            }else{
                newString.append(string.charAt(pos));
                pos++;
            }
        }
        return newString.toString();
    }

    public static String Interation(String string){
        for(int i = 0;i < string.length();i++){
            if(string.charAt(i)>='0' && string.charAt(i)<='9'){
                return Interation(stringCopy(string));
            }
        }
        return string;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if(string.length()>=100||string.equals("")||string == null)
            return;
        String result = Interation(string);
        System.out.println(result);
    }
}
