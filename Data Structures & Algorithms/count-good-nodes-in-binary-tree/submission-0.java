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
    int cnt;

    public void dfs(TreeNode root, int max){
        if(root==null) return;

        if(root.val >= max){
            cnt++;
            max = root.val;
        }

        dfs(root.left, max);
        dfs(root.right, max);
    }
    public int goodNodes(TreeNode root) {
        //루트 항상 1
        cnt = 0;
        int max = root.val;

        dfs(root, max);
        
        return cnt;
    }
}
