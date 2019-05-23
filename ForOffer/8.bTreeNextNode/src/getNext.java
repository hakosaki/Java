/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class getNext {
    /**
     * 二叉树的下一个节点
     * 1.有右子树，则右子树最左边节点
     * 2.无右子树，为父节点左，返回父节点
     * 3.无右子树，为父节点右，往上回溯找到第一个父的左节点，返回该父节点
     * */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)
            return null;
        if(pNode.right!=null){
            TreeLinkNode cur = pNode.right;
            while(cur.left!=null){
                cur = cur.left;
            }
            return cur;
        }else if(pNode.next!=null){
            TreeLinkNode cur = pNode;
            /*
            * 记得判断父节点不为空！！
            * */
            while(cur.next!=null && cur!=cur.next.left){
                cur = cur.next;
            }
            return cur.next;
        }else{
            return null;
        }
    }
}