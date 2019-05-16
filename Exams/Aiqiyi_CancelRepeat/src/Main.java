import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public String cancelRepeat(String s){
        if(s==null||s.length()==0)
            return null;
        HashMap<Character,Integer> map = new HashMap();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i=0;i<len;i++){
            if(map.containsKey(s.charAt(i)))
                continue;
            else {
                map.put(s.charAt(i),1);
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(m.cancelRepeat(s));
    }
}
