public class Find {
    /**
     * 从右上开始，大于目标，则左移，小于目标则下移，找到返回true，越界返回false
     * */
    boolean Find(int target, int [][] array){
        if(array==null||array.length==0||array[0]==null||array[0].length==0)
            return false;
        int row = array.length;
        int col = array[0].length;
        int i = 0;
        int j = col - 1;
        while(i<row && j>=0){
            if(array[i][j] == target)
                return true;
            else if(array[i][j]<target)
                i++;
            else
                j--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] matrix2 = null;
        Find f = new Find();
        System.out.println(f.Find(2,matrix1));
        System.out.println(f.Find(1,matrix2));
    }
}
