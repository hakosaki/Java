public class combBoolNum {
    /**
     * 给定一串由0、1、&、|、^组成字符串，再给预期布尔值desired，返回express组合方式
     * express = "1^0|0|1"，desired = false，返回2
     * express = "1"，desired = false，返回0
     *
     * 1.暴力递归
     * 对每个符号递归求左右布尔可能数
     *
     * 2.dp
     * t[j][i] 表示 express[j...i]组成true种数
     * f[j][i] 表示 express[j...i]组成false种数
     * 还是遍历枚举express[j...i]上每种组合
     * */
    private boolean isValid(char[] exp){
        int n = exp.length;
        if((n&1)==0)
            return false;
        for(int i=0;i<n;i+=2)
            if((exp[i]!='1')&&(exp[i]!='0'))
                return false;
        for(int i=1;i<n;i+=2)
            if((exp[i]!='&')&&(exp[i]!='|')&&(exp[i]!='^'))
                return false;
        return true;
    }
    public int combBoolNum1(String express,boolean desired){
        if(express==null||express.equals(""))
            return 0;
        char[] exp = express.toCharArray();
        if(!isValid(exp))
            return 0;
        return combBoolNum1(exp,desired,0,exp.length-1);
    }
    private int combBoolNum1(char[] exp,boolean desired,int l,int r){
        if(l==r){
            if(exp[l]=='1')
                return desired?1:0;
            else
                return desired?0:1;
        }
        int res = 0;
        if(desired){
            for(int i=l+1;i<r;i+=2){
                switch (exp[i]){
                    case '&':
                        res += combBoolNum1(exp,true,l,i-1) * combBoolNum1(exp,true,i+1,r);
                        break;
                    case '|':
                        res += combBoolNum1(exp,true,l,i-1) * combBoolNum1(exp,false,i+1,r);
                        res += combBoolNum1(exp,false,l,i-1) * combBoolNum1(exp,true,i+1,r);
                        res += combBoolNum1(exp,true,l,i-1) * combBoolNum1(exp,true,i+1,r);
                        break;
                    case '^':
                        res += combBoolNum1(exp,true,l,i-1) * combBoolNum1(exp,false,i+1,r);
                        res += combBoolNum1(exp,false,l,i-1) * combBoolNum1(exp,true,i+1,r);
                        break;
                }
            }
        }else{
            for(int i=l+1;i<r;i+=2){
                switch (exp[i]){
                    case '&':
                        res += combBoolNum1(exp,false,l,i-1) * combBoolNum1(exp,true,i+1,r);
                        res += combBoolNum1(exp,true,l,i-1) * combBoolNum1(exp,false,i+1,r);
                        res += combBoolNum1(exp,false,l,i-1) * combBoolNum1(exp,false,i+1,r);
                        break;
                    case '|':
                        res += combBoolNum1(exp,false,l,i-1) * combBoolNum1(exp,false,i+1,r);
                        break;
                    case '^':
                        res += combBoolNum1(exp,true,l,i-1) * combBoolNum1(exp,true,i+1,r);
                        res += combBoolNum1(exp,false,l,i-1) * combBoolNum1(exp,false,i+1,r);
                        break;
                }
            }
        }
        return res;
    }

    public int combBoolNum2(String express,boolean desired){
        if(express==null||express.equals(""))
            return 0;
        char[] exp = express.toCharArray();
        int n = exp.length;
        if(!isValid(exp))
            return 0;
        int[][] t = new int[n][n];
        int[][] f = new int[n][n];
        t[0][0] = exp[0]=='0'?0:1;
        f[0][0] = exp[0]=='1'?0:1;
        for(int i=2;i<n;i+=2){
            t[i][i] = exp[i]=='0'?0:1;
            f[i][i] = exp[i]=='1'?0:1;
            for(int j=i-2;j>=0;j-=2){
                for(int k=j;k<i;k+=2){
                    if(exp[k+1]=='&'){
                        t[j][i] += t[j][k] * t[k+2][i];
                        f[j][i] += (f[j][k] + t[j][k]) * f[k+2][i] + f[j][k] * t[k+2][i];
                    }else if(exp[k+1]=='|'){
                        t[j][i] += (f[j][k] + t[j][k]) * t[k+2][i] + t[j][k] * f[k+2][i];
                        f[j][i] += f[j][k] * f[k+2][i];
                    }else{
                        t[j][i] += f[j][k] * t[k+2][i] + t[j][k] * f[k+2][i];
                        f[j][i] += f[j][k] * t[k+2][i] + t[j][k] * t[k+2][i];
                    }
                }
            }
        }
        return desired?t[0][n-1]:f[0][n-1];
    }
    public static void main(String[] args){
        combBoolNum c = new combBoolNum();
        String s = "1^0|0|1";
        boolean desired = false;
        System.out.println(c.combBoolNum1(s,desired));
        System.out.println(c.combBoolNum2(s,desired));
    }
}
