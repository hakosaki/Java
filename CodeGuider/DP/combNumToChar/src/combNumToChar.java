public class combNumToChar {
    /**
     * 数字1~26转换成字母A~Z，求多少种不同转换结果
     *
     * i==n,后续没有合法字符，转换种数1
     * s[i]==0，不能转换返回0
     * s[i]在1~9间，p(i)=p(i+1)
     * s[i..i+1]在10~26,p(i)+=p(i+2)
     *
     * 1.暴力递归
     * 2.dp
     * 同Fibonacci
     *
     * */
    public int combNumToChar1(String s){
        if(s==null||s.equals(""))
            return 0;
        char[] c = s.toCharArray();
        return combNumToChar1(c,0);
    }
    private int combNumToChar1(char[] c,int i){
        if(i==c.length)
            return 1;
        if(c[i]=='0')
            return 0;
        int res = combNumToChar1(c,i+1);
        if(i+1<c.length && (c[i]-'0')*10+c[i+1]-'0'<27)
            res += combNumToChar1(c,i+2);
        return res;
    }

    public int combNumToChar2(String s){
        if(s==null||s.equals(""))
            return 0;
        char[] c = s.toCharArray();
        int n = c.length-1;
        int cur = c[n]=='0'?0:1;
        int next = 1;
        int tmp = 0;
        for(int i=n-1;i>=0;i--){
            if(c[i]=='0'){
                next = cur;
                cur = 0;
            }else{
                tmp = cur;
                if((c[i]-'0')*10+c[i+1]-'0'<27)
                    cur += next;
                next = tmp;
            }
        }
        return cur;
    }
    public static void main(String[] args){
        combNumToChar c = new combNumToChar();
        String s1 = "1111";
        String s2 = "10";
        System.out.println(c.combNumToChar1(s1));
        System.out.println(c.combNumToChar2(s1));
        System.out.println(c.combNumToChar1(s2));
        System.out.println(c.combNumToChar2(s2));
    }
}
