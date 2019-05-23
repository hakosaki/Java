import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTree {
    private TreeNode root;
    public BinaryTree(){
        root = null;
    }
    /**
     * insert
     * */
    public void insert(int data){
        TreeNode newNode = new TreeNode(data);
        if(root==null) {
            root = newNode;
            return;
        }
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur!=null){
            pre = cur;
            if(data<cur.val){
                cur = cur.left;
                if(cur==null)
                    pre.left = newNode;
            }else{
                cur = cur.right;
                if(cur==null)
                    pre.right = newNode;
            }
        }
        return;
    }
    /**
     * initiate binary tree
     * */
    public boolean buildTree(int[] arr){
        if(arr==null||arr.length==0)
            return false;
        this.root = null;
        for(int i=0;i<arr.length;i++)
            insert(arr[i]);
        return true;
    }
    /**
     * 前序遍历
     * */
    /*
    * recursion
    * */
    public void pre1(){
        if(root==null)
            return;
        pre1(root);
        System.out.println();
    }
    private void pre1(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.val+" ");
        pre1(root.left);
        pre1(root.right);
    }
    /*
    * stack
    * */
    public void pre2(){
        if(root==null)
            return;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            while(cur!=null){
                System.out.print(cur.val+" ");
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()) {
                System.out.println();
                return;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }
    /**
     * 中序遍历
     * */
    /*
    * recursion
    * */
    public void in1(){
        if(root==null)
            return;
        in1(root);
        System.out.println();
    }
    private void in1(TreeNode root){
        if (root==null)
            return;
        in1(root.left);
        System.out.print(root.val+" ");
        in1(root.right);
    }
    /*
    * stack
    * */
    public void in2(){
        if(root==null)
            return;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()){
                System.out.println();
                return;
            }
            cur = stack.pop();
            System.out.print(cur.val+" ");
            cur = cur.right;
        }
    }
    /**
     * 后续遍历
     * */
    /*
    * recursion
    * */
    public void post1(){
        if(root==null)
            return;
        post1(root);
        System.out.println();
    }
    private void post1(TreeNode root){
        if(root==null)
            return;
        post1(root.left);
        post1(root.right);
        System.out.print(root.val+" ");
    }
    /*
    * stack
    * */
    public void post2(){
        if(root==null)
            return;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                if(stack.isEmpty()){
                    System.out.println();
                    return;
                }
                if(stack.peek().right==null) {
                    cur = stack.pop();
                    System.out.print(cur.val + " ");
                    while(stack.peek().right==cur){
                        cur =  stack.pop();
                        System.out.print(cur.val + " ");
                        if(stack.isEmpty())
                            break;
                    }
                }
                if(!stack.isEmpty())
                    cur = stack.peek().right;
                else
                    cur = null;
            }
        }
    }
    /**
     * 层序遍历
     * */
    public void layer(){
        if(root==null)
            return;
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue();
        TreeNode cur = root;
        queue.add(cur);
        while(!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur.val+" ");
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }
        System.out.println();
    }
    /**
     * 求二叉树节点最大距离
     * 三种情况：
     * 1.左最大距离
     * 2.右最大距离
     * 3.经过根+左最深+右最深
     * */
    public int getMaxDistance(){
        int[] depth = new int[1];
        return getMaxDistance(root,depth);
    }
    private int getMaxDistance(TreeNode root,int[] depth){
        if(root==null){
            depth[0] = 0;
            return 0;
        }
        int leftMax = getMaxDistance(root.left,depth);
        int leftDep = depth[0];
        int rightMax = getMaxDistance(root.right,depth);
        int rightDep = depth[0];
        depth[0] = Math.max(leftDep+1,rightDep+1);
        int max = Math.max(leftMax,rightMax);
        return Math.max(max,leftDep+rightDep+1);
    }

    public static void main(String[] args){
        BinaryTree b = new BinaryTree();
        int[] arr = {2,8,7,4,9,3,1,6,7,5};
        b.buildTree(arr);
        b.pre1();
        b.pre2();
        b.in1();
        b.in2();
        b.post1();
        b.post2();
        b.layer();
        System.out.println( b.getMaxDistance());
    }
}
