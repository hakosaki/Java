import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class getAllComb {
    /**
     * 按要求打印数组的组合排列
     * 1、2、2、3、4、5
     * 3、5不能相连，4不能在第三位
     *
     * 构造无向连通图，分别从6个点出发深度优先遍历，用set记录组合，排除第三位是4的情况
     * */
    private int[] numbers = {1,2,2,3,4,5};
    private int n = numbers.length;
    private boolean[] visited = new boolean[n];
    private int[][] graph = new int[n][n];
    private String combination = "";
    public Set<String> getAllCombinations(){
        buildGraph();
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++)
            this.depthFirstSearch(i,set);
        return set;
    }
    private void buildGraph(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    graph[i][j]=0;
                else
                    graph[i][j]=1;
            }
        }
        graph[3][5] = 0;
        graph[5][3] = 0;
    }
    private void depthFirstSearch(int start,Set<String> set){
        visited[start] = true;
        combination += numbers[start];
        if(combination.length()==n){
            if(combination.indexOf("4")!=2)
                set.add(combination);
        }
        for(int j=0;j<n;j++)
            if(graph[start][j]==1 && visited[j]==false)
                depthFirstSearch(j,set);
        combination = combination.substring(0,combination.length()-1);
        visited[start] = false;
    }
    public static void main(String[] args){
        getAllComb g = new getAllComb();
        Set<String> set = g.getAllCombinations();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String s = (String)it.next();
            System.out.println(s);
        }
    }
}
