import java.util.Scanner;
import java.util.Stack;

public class Main {
    /**
     * 括号匹配，求不匹配的括号数
     * */
    public int bracketMatch(String s ){
        if(s==null||s.length()==0)
            return 0;
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='(')
                stack.push('(');
            else if(s.charAt(i)==')'){
                if(!stack.isEmpty())
                    stack.pop();
                else
                    count++;
            }else
                continue;
        }
        if(!stack.isEmpty())
            count+=stack.size();
        return count;
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(m.bracketMatch(s));
    }
}
