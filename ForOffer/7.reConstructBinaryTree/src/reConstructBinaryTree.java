public class reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        if(pre==null||pre.length==0||in==null||in.length==0)
            return null;
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    private TreeNode reConstructBinaryTree(int[] pre,int start1,int end1,int[] in,int start2,int end2){
        if(start1>end1||start2>end2)
            return null;
        int data = pre[start1];
        TreeNode root = new TreeNode(data);
        int pos = findRoot(in,data,start2,end2);
        /**
         * -1 不是 +1 ！！！！
         * */
        int offset = pos - start2 - 1;
        TreeNode left = reConstructBinaryTree(pre,start1+1,start1+offset+1,in,start2,start2+offset);
        TreeNode right = reConstructBinaryTree(pre,start1+offset+2,end1,in,pos+1,end2);
        root.left = left;
        root.right = right;
        return root;
    }
    private int findRoot(int[] in,int data,int start2,int end2){
        for(int i=start2;i<=end2;i++){
            if(in[i]==data)
                return i;
        }
        return -1;
    }
}
