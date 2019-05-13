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
    }
}
