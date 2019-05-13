public class Find {
    boolean find(final int[][] matrix,final int number ){
        if(matrix == null)
            return false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;                                                     //需要新变量进行循环
        int column = columns - 1;                                        //需要新变量进行循环
       // while(row <=  rows  - 1 || column >= 0){                         强行要求查询到最左下，溢出
        while(row < rows && column >= 0){
            if(matrix[row][column] == number){
                return true;
            }else if(matrix[row][column] > number){
                --column;
            }else{
                ++row;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] matrix2 = null;
        Find f = new Find();
        boolean result = f.find(matrix2,3);
        System.out.println(result);
    }
}
