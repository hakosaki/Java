import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {
    private Node root;
    public BinaryTree(){
        root = null;
    }
    /*
    * 插入
    * */
    public void insert(int data){
        Node newNode = new Node(data);
        if(root == null)
            root = newNode;
        else {
            Node parent;
            Node current = root;
            while (true) {
                parent = current;
                if (current.data > data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /*
    * 构建二叉树
    * */
    public boolean buildTree(int[] arr){
        if(arr==null||arr.length<=0)
            return false;
        this.root = null;
        for(int i=0;i<arr.length;i++)
            insert(arr[i]);
        return true;
    }
    /*
    * 中序遍历
    * */
    public void in(){
        this.in(this.root);
    }
    public void in(Node root){
        if(root==null)
            return;
        in(root.left);
        System.out.print(root.data+" ");
        in(root.right);
    }
//    中序非递归遍历
    public void in1(){
        Stack<Node> stack = new Stack<>();
        Node tmp = root;
        while(true){
            while(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
            if(stack.isEmpty())
                break;
            tmp = stack.pop();
            System.out.print(tmp.data+" ");
            tmp = tmp.right;
        }
    }
    /*
    * 前序遍历
    * */
    public void pre(){
        this.pre(this.root);
    }
    public void pre(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        pre(root.left);
        pre(root.right);
    }
//    前序非递归遍历
    public void pre1(){
        Stack<Node> stack = new Stack();
        Node tmp = root;
        while(true){
            while(tmp!=null) {
                System.out.print(tmp.data + " ");
                stack.push(tmp);
                tmp = tmp.left;
            }
            if(stack.isEmpty())
                break;
            tmp = stack.pop();
            tmp = tmp.right;
        }
    }
    /*
    * 后续遍历
    * */
    public void post(){
        this.post(this.root);
    }
    public void post(Node root){
        if(root==null)
            return;
        post(root.left);
        post(root.right);
        System.out.print(root.data+" ");
    }
//  后续非递归遍历
    public void post1(){
       Stack<Node> stack = new Stack<>();
       Node tmp = root;
       while(true){
           if(tmp!=null){
               stack.push(tmp);
               tmp = tmp.left;
           }else{
               if(stack.isEmpty())
                   return;
               if(stack.peek().right==null){
                   tmp = stack.pop();
                   System.out.print(tmp.data+" ");
                   while(stack.peek().right==tmp){
                       tmp = stack.pop();
                       System.out.print(tmp.data+" ");
                       if(stack.isEmpty())
                           break;
                   }
               }
               if(!stack.isEmpty())
                   tmp = stack.peek().right;
               else
                   tmp = null;
           }
       }
    }
    /*
    * 层序遍历
    * */
    public void layer(){
        if(this.root==null)
            return;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            Node cur = list.pop();
            System.out.print(cur.data+" ");
            if(cur.left!=null)
                list.add(cur.left);
            if(cur.right!=null)
                list.add(cur.right);
        }
    }
    /*
    * 先、中序建树求后序
    * */
    public void initTree(int[] pre,int[] in){
        this.root = this.initTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public Node initTree(int[] pre,int start1,int end1,int[] in,int start2,int end2){
        if(start1>end1 || start2>end2)
            return null;
        int data = pre[start1];
        Node root = new Node(data);
        int rootPos = findPos(in,data,start2,end2);
        int offSet = rootPos - start2 - 1;
        Node left = initTree(pre,start1+1,start1+1+offSet,in,start2,start2+offSet);
        Node right = initTree(pre,start1+2+offSet,end1,in,rootPos+1,end2);
        root.left = left;
        root.right = right;
        return root;
    }
    private int findPos(int[] in,int data,int start,int end){
        for(int i=start;i<=end;i++){
            if(in[i]==data)
                return i;
        }
        return -1;
    }
    /*
    * 求二叉树节点的最大距离
    * 三种情况：
    * 1.左子树节点最大距离
    * 2.右子树节点最大距离
    * 3.经过根+左最深+右最深
    *
    * 存在 左子树最大距离 比 根+左最深+右最深 大，因为二叉树有可能不平衡
    * */
    public int getMaxDistance(){
        int[] depth = new int[1];
        int max = getMaxDistance(root,depth);
        return max;
    }
    private int getMaxDistance(Node cur,int[] depth){
        if(cur==null){
            depth[0] = 0;
            return 0;
        }
        int leftMax = getMaxDistance(cur.left,depth);
        int leftDepth = depth[0];
        int rightMax = getMaxDistance(cur.right,depth);
        int rightDepth = depth[0];
        depth[0] = Math.max(leftDepth+1,rightDepth+1);
        return Math.max(Math.max(leftMax,rightMax),leftDepth+rightDepth+1);
    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        int[] arr = {2,8,7,4,9,3,1,6,7,5};
        System.out.println(bt.buildTree(arr));
        System.out.print("先序遍历1： ");
        bt.pre();
        System.out.print("先序遍历2： ");
        bt.pre1();
        System.out.println();
        System.out.print("中序遍历1： ");
        bt.in();
        System.out.print("中序遍历2： ");
        bt.in1();
        System.out.println();
        System.out.print("后序遍历1： ");
        bt.post();
        System.out.print("后序遍历2： ");
        bt.post1();
        System.out.println();
        System.out.print("层序遍历： ");
        bt.layer();
        System.out.println();
        int[] pre = {2,1,8,7,4,3,6,5,7,9};
        int[] in = {1,2,3,4,5,6,7,7,8,9};
        bt.initTree(pre,in);
        bt.post();
        System.out.println();
        int[] arr1 = {2,5,4,3,6,7};
        System.out.println(bt.buildTree(arr1));
        System.out.println(bt.getMaxDistance());
    }
}
