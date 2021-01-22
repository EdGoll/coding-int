package tree;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DFS {
    public List<List<Integer>> dephOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);
        boolean zz = false;
        // iterate till queue is empty
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            //operar con nivel, aqui esta el level
            List<Integer> nivel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                
                TreeNode node = queue.pop();
                // insert in queue if the child is not null
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                              
                // add the elements in level into batch
                nivel.add(node.val);
            }
            //solo para invertir orden
            // add the batch to result
            if(zz){                
                Collections.reverse(nivel);
            }                             
            zz=!zz;            
            result.add(nivel);
        }
        return result;
    }    
}
