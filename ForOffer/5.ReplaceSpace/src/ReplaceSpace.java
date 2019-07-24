public class ReplaceSpace {
    /**
     * 字符串空格用%20代替
     * 时间复杂度要求O（n）
     *
     * StringBuffer
     * 遍历第一遍遇空格加两字符
     * 长度相等直接返回
     * 长度不等，从末尾依次替换
     * */
    public String replaceSpace(StringBuffer str) {
        if(str==null||str.length()<=0)
            return "";
        int n = str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i)==' ')
                str.append("  ");
        }
        int r = str.length();
        if(r==n)
            return str.toString();
        int end1 = n-1;
        int end2 = r-1;
        while(end1!=end2){
            if(str.charAt(end1)==' '){
                str.setCharAt(end2--,'0');
                str.setCharAt(end2--,'2');
                str.setCharAt(end2--,'%');
            }else{
                str.setCharAt(end2--,str.charAt(end1));
            }
            end1--;
        }
        return str.toString();
    }
    public static void main(String[] args) {
       StringBuffer str = new StringBuffer("We are happy.");
       ReplaceSpace r = new ReplaceSpace();
       String strResult = r.replaceSpace(str);
       System.out.println(strResult);
    }
}