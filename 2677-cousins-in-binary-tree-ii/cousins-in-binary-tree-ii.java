/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root==null)return null;
        
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        List<Integer>levelSum = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            int sum=0;
            while(size-->0){
                TreeNode node = q.poll();
                sum+=node.val;
                if(node.left != null){
                    q.offer(node.left);

                }
                if(node.right != null){
                    q.offer(node.right);

                }

            }
            levelSum.add(sum);
        }
        
        q.offer(root);
        root.val =0;
        int level=1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode top = q.poll();
                int siblingSum =0;
                if(top.left!=null){
                    q.offer(top.left);
                    siblingSum+=top.left.val;
                }
                if(top.right!=null){
                    q.offer(top.right);
                    siblingSum+=top.right.val;
                }
                if(top.left!=null){
                    top.left.val = levelSum.get(level)-siblingSum;
                }
                if(top.right != null){
                    top.right.val = levelSum.get(level)-siblingSum;
                }
            }
            level++;
        }
        return root;
    }
}