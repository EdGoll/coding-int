import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zz = false;
        // iterate till queue is empty
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            //operar con nivel, aqui esta el level
            List<Integer> nivel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                
                TreeNode node = queue.poll();
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