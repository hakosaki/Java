import java.util.Scanner;
import java.util.Stack;

public class Main {
    /**
     * 括号深度
     *
     * 输入
     * 合法括号序列
     * 输出括号深度
     * ()()() 1
     * ((())) 3
     *        0
     * */
    public int bracketDepth(String s){
        if(s==null||s.equals(""))
            return 0;
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int depth = 0,max = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(')
                stack.push('(');
            else if(s.charAt(i)==')'){
                depth = stack.size();
                stack.pop();
                if(depth>max)
                    max = depth;
            }else
                continue;
        }
        return max;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(m.bracketDepth(s));
    }
}
