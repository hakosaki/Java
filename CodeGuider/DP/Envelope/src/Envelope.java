import java.util.Arrays;
import java.util.Comparator;

public class Envelope {
    /**
     * 给N行2列二维数组，分别代表信封长和宽，
     * 若A的长、宽都小于B，信封A可以放进信封B，
     * 最多嵌套多少层？
     *
     * 输入
     * ｛｛3,4｝,｛2,3,｝,｛4,5｝,｛1,3｝,｛2,2｝,｛3,6｝,｛1,2｝,｛3,2｝,｛2,4｝｝
     * 输出
     * 4 ({1,2},{2,3},{3,4},{4,5})
     * */
    public int len;
    public int wid;

    public Envelope(int weight, int hight) {
        len = weight;
        wid = hight;
    }
    public Envelope(){}
    private class EnvelopeComparator implements Comparator<Envelope>{
        @Override
        public int compare(Envelope o1,Envelope o2){
        //按信封长度升序，若长度相等按照宽度降序，只有长、宽均大于才能放进
            return o1.len != o2.len?o1.len-o2.len:o2.wid-o1.wid;
        }
    }

    private Envelope[] getSortedEnvelopes(int[][] matrix){
        int n = matrix.length;
        Envelope[] res = new Envelope[n];
        for(int i=0;i<n;i++)
            res[i] = new Envelope(matrix[i][0],matrix[i][1]);
        Arrays.sort(res,new EnvelopeComparator());
        return res;
    }

    public int maxEnvelope(int[][] matrix){
        Envelope[] envelopes = getSortedEnvelopes(matrix);
        int[] ends = new int[envelopes.length];
        ends[0] = envelopes[0].wid;
        int right = 0;
        int l=0,r=0,m=0;
        for(int i=1;i<envelopes.length;i++){
            l = 0;
            r = right;
            while(l<=r){
                m = ((l+r)>>1);
                if(envelopes[i].wid>ends[m])
                    l = m+1;
                else
                    r = m-1;
            }
            right = Math.max(right,l);
            ends[l] = envelopes[i].wid;
        }
        return right+1;
    }

    public static void main(String[] args){
        int[][] matrix ={{3,4},{2,3},{4,5},{1,3},{2,2},{3,6},{1,2},{3,2},{2,4}};
        Envelope e = new Envelope();
        System.out.println(e.maxEnvelope(matrix));
    }
}
