package tree;

public class CompletTree {
    
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        TreeNode l = root;
        TreeNode r = root;
        int h = 0;        
        //search in deep while right  is not null, becouse is a complet tree, the de left ever is full 
        while( r != null ) {            
            l = l.left;
            r = r.right;            
            h++;            
        }  
        
        if( l == null ) { // Left subtree and right subtree is balanced
            return ( 1 << h ) - 1;  // 2 ^ (height) - 1;
        } else { // Left subtree is deeper than right subtree, the we calcular H for subtree right and left in recursive mode and using the first return sentence  return ( 1 << h ) - 1;
            //apply DFS to left and right
            int lH = countNodes(root.left); 
            int rH = countNodes(root.right);

            return 1 + lH + rH; //we add 1 becouse is the root, thats is not null validate yet
           // return dfs(root,0);
        }
                    
    }
    
       
        
/*         

        1
      /   \
    -2     3-
    / \   / \
   -4   5 6  null --
   
     
     2^1 -1 = 1
     2     
   1/    
   4     
   
    2^1 -1 = 1
     2     
      \1   
       5  
  ----------------- 
  2^1 -1 = 1
         3
       1/ 
       6     
    
    2^0 -1 = 0
   3
    \ 0
     null
*/
    

      
}