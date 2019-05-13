public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int originLength = str.length();
        if(originLength <= 0 || str == null)
            return str.toString();
        for(int i = 0; i < originLength; i++){
            if(str.charAt(i)==' ')
                str.append("  ");
        }
        int newLength = str.length();
        if(newLength == originLength)
            return str.toString();
        int originEnd = originLength - 1;
        int newEnd = newLength - 1;
       // while(originEnd != newEnd){
        while(originEnd >= 0 && newEnd > originEnd){
            if(str.charAt(originEnd) == ' '){
                str.setCharAt(newEnd--, '0');
                str.setCharAt(newEnd--, '2');
                str.setCharAt(newEnd--, '%');
            }else{
                str.setCharAt(newEnd--, str.charAt(originEnd));
            }
            --originEnd;
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
/*
* str.charAt
* str.setCharAt( , )
* StringBuffer str = new StringBuffer("");
* */