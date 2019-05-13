import java.util.*;

public class maze {
/**
 * 迷宫  0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，小写字母-对应钥匙
 *
 * 输入
 * 5 5
 * 02111
 * 01a0A
 * 01003
 * 01001
 * 01111
 *
 * 输出
 * 7
 * */
/**
 * 迷宫问题分BFS DFS
 *
 * BFS常用于求最优解(如最短时间，最优路径等)，站在一个点上，首先试一试自己周围的点是否可以走，如果是路则加入待走队列，如果是墙则丢弃。
 * 迷宫问题在广度优先搜索的时候需要特别注意的就是要及时抛弃，遇到走过的点立即丢弃，遇到墙立即丢弃，不然时间复杂度就很高。一般利用队列来辅助。
 *
 * DFS不需最优的特性，用于求解有或者没有的问题，一般利用堆栈或递归来实现。
 * */
    static class Node{
        int x;
        int y;
        int key;
        int step;
        public Node(int x,int y,int key,int step){
            this.x=x;
            this.y=y;
            this.key=key;
            this.step=step;
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        in.nextLine();
        char[][] G=new char[N][M];
        for(int i=0;i<N;i++){
            G[i]=in.nextLine().toCharArray();
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(G[i][j]=='2'){
                    System.out.println(bfs(i,j,N,M,G));
                    return;
                }
            }
        }
    }
//    深度优先
    private static int bfs(int si, int sj,int N,int M,char[][] G) {
        Queue<Node> queue=new LinkedList<>();
        int[][][] mp=new int[101][101][1025];
        int[][] next={{-1,0},{0,-1},{1,0},{0,1}};

        queue.offer(new Node(si,sj,0,0));
        while(!queue.isEmpty()){
            Node node=queue.poll();
            for(int i=0;i<4;i++){
                int x=node.x+next[i][0];
                int y=node.y+next[i][1];
                int key=node.key;
                if(x<0||x>=N||y<0||y>=M||G[x][y]=='0') continue;
                else if(G[x][y]=='3') return node.step+1;
                else if(G[x][y]<='z'&&G[x][y]>='a') key=key|(1<<(G[x][y]-'a'));
                else if(G[x][y]<='Z'&&G[x][y]>='A'&&(key&(1<<(G[x][y]-'A')))==0) continue;
                if(mp[x][y][key]==0){
                    mp[x][y][key]=1;
                    queue.offer(new Node(x,y,key,node.step+1));
                }

            }
        }
        return -1;
    }

}