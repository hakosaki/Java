public class removeDuplication {
    /**
     * 删除字符串中重复的字符
     * good
     * god
     *
     * 1.暴力
     * */
    public String removeDup1(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i=0;i<sb.length();i++){
            for(int j=i+1;j<sb.length();){
                if(sb.charAt(i)==sb.charAt(j))
                    sb.deleteCharAt(j);
                else
                    j++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String s = "abcaabcd";
        removeDuplication r = new removeDuplication();
        System.out.println(r.removeDup1(s));
    }
}
