package tree;

import java.util.List;

public class CycleGraph {
    
    private final int V; 
    private final List<List<Integer>> adj = new ArrayList<>(V); 

    private void addEdge(int source, int dest) { 
        adj.get(source).add(dest); 
    } 
  

    private boolean isCyclicUtil(int i, boolean[] seen,  boolean[] cycleStack, List<List<Integer>> adjs) { 
          
        // Mark the current node as visited and 
        // part of recursion stack 
        if (cycleStack[i]) return true; 
  
        if (seen[i]) return false; 
              
        seen[i] = true; 

        cycleStack[i] = true; 

        List<Integer> children = adjs.get(i); 
          
        for (Integer c: children) 
            if (isCyclicUtil(c, seen, cycleStack,adjs)) 
                return true; 
                  
        cycleStack[i] = false; 
  
        return false; 
    } 

    private boolean isCyclic()  
    { 
          
        // Mark all the vertices as not visited and 
        // not part of recursion stack 
        boolean[] seen = new boolean[V]; 
        boolean[] cycleStack = new boolean[V]; 
                    
        // Call the recursive helper function to 
        // detect cycle in different DFS trees 
        for (int i = 0; i < V; i++) 
            if (isCyclicUtil(i, seen, cycleStack,adj)) 
                return true; 
  
        return false; 
    }     

}
