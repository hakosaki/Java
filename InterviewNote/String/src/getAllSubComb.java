public class getAllSubComb {
    /**
     * 输出所有字符的组合
     * abc
     * a b c ab ac bc abc
     *
     * 1.暴力递归
     * 用该字符，不用该字符两种情况，迭代起始字符和字符长度
     *
     * 2.01字符串
     * 001-111代表abc中是否用到字符
     *
     * */
    public void getAllSubComb1(String s){
        if(s==null||s.length()==0)
            return;
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=len;i++)
            combInteration(c,0,i,sb);
    }
    private void combInteration(char[] c,int start,int len,StringBuffer sb){
        if(len==0){
            System.out.println(sb.toString());
            return;
        }
        if(start == c.length)
            return;
        sb.append(c[start]);
        combInteration(c,start+1,len-1,sb);
        sb.deleteCharAt(sb.length()-1);
        combInteration(c,start+1,len,sb);
    }

    public void getAllSubComb2(String s){
        if(s==null||s.length()<=0)
            return;
        int len = s.length();
        char[] c = s.toCharArray();
        boolean[] used = new boolean[len];
        char[] cache = new char[len];
        int index = 0;
        int result = len;
        while(true){
            index = 0;
            while(used[index]){
                used[index] = false;
                ++result;
                if(++index==len)
                    return;
            }
            used[index] = true;
            cache[--result] = c[index];
            System.out.println(new String(cache).substring(result).toString());
        }
    }
    public static void main(String[] args){
        getAllSubComb g = new getAllSubComb();
        String s = "abc";
        g.getAllSubComb1(s);
        System.out.println();
        g.getAllSubComb2(s);
    }
}
