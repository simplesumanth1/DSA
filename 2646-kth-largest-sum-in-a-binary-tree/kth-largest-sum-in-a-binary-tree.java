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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long>pq = new PriorityQueue<>();
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty()){
            int size = q.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode top = q.poll();
                sum+=(long)(top.val);
                if(top.left != null)q.offer(top.left);
                if(top.right != null)q.offer(top.right);
            }
                level++;
            pq.offer(sum);
            if(pq.size()>k)pq.poll();
        }
        if(level<k)return -1;
        return pq.peek();
        
        
    }
}