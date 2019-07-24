public class swapString {
    /**
     * 字符串反转
     * how are you
     * you are how
     * */
    public String swapString(String s){
        if(s==null||s.length()<=1)
            return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String[] ch = sb.toString().split(" ");
        sb = new StringBuilder();
        for(int i=0;i<ch.length;i++){
            StringBuilder tmp = new StringBuilder();
            tmp.append(ch[i]);
            tmp.reverse();
            sb.append(tmp);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args){
        swapString s = new swapString();
        String ss = "how are you";
        System.out.println(s.swapString(ss));
    }
}
