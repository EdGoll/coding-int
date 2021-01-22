package tree;

import java.util.Stack;

public class Island {
    public int numIslands(char[][] grid) {
        int n = 0;
        for ( int i = 0 ; i < grid.length ; i++ ){
            for ( int j = 0 ; j < grid[i].length ; j++ ){
                System.out.println(grid[i][j]);
                if(grid[i][j] == '1' ){                                        
                    if(searchDFS(grid,i,j) > 0){
                        n++;
                    }
                }
            }
        } 
        return n;
    }
    
 public static int searchDFS(char[][] mat, int row, int col){
        int h = mat.length;        
        if (h==0){
            return 0;
        }    
        int contRegions = 0;        
        int l=mat[0].length;
        boolean [][] visited = new boolean[h][l];
        Stack<int []> stack = new Stack<>();
        int [] coord = new int [2];
        stack.push(new int [] {row,col});
     
        while(!stack.empty()){
            
            coord = stack.pop();
            row = coord[0];
            col = coord[1];
            

            if(row<0 || col < 0 || row >= h || col >= l || visited[row][col] ){
                continue;
            }

            visited[row][col]=true;
            
            System.out.println(mat[row][col]);
            mat[row][col] = '0';
            contRegions++;            

            if(col-1 >=0 && mat[row][col-1]!='0'){
                stack.push(new int [] {row,col-1});
            }
            if(col+1 < mat[row].length && mat[row][col+1]!='0'){
                stack.push(new int [] {row,col+1});
            }
            if(row-1 >=0 && mat[row-1][col]!='0'){
                stack.push(new int [] {row-1,col});
            }
            if(row+1 < mat.length && mat[row+1][col]!='0'){
                stack.push(new int [] {row+1,col});
            }
                    

        }
        return contRegions;
    }      
}
