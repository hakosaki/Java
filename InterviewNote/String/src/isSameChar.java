import java.util.Arrays;

public class isSameChar {
    /**
     * 判断两个字符串是否相同字符组成
     * 1.排序
     *
     * 2.空间换时间
     * */
    public boolean isSameChar1(String s1,String s2){
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        Arrays.sort(b1);
        Arrays.sort(b2);
        s1 = new String(b1);
        s2 = new String(b2);
        return s1.equals(s2);
    }
    public boolean isSameChar2(String s1,String s2){
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        int[] bCount = new int[256];
        int i;
        for(i=0;i<b1.length;i++)
            bCount[b1[i]-'0']++;
        for(i=0;i<b2.length;i++)
            bCount[b2[i]-'0']--;
        for(i=0;i<256;i++)
           if(bCount[i]!=0)
               return false;
        return true;
    }
    public static void main(String[] args){
        isSameChar i = new isSameChar();
        String s1="aaaabbc";
        String s2="abcbaaa";
        System.out.println(i.isSameChar1(s1,s2));
        System.out.println(i.isSameChar2(s1,s2));
        s2 = "abcbaab";
        System.out.println(i.isSameChar1(s1,s2));
        System.out.println(i.isSameChar2(s1,s2));
    }
}
