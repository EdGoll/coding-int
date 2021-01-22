import java.util.Stack;

public class DFSGraphMatrix {

    public static void main(String[] args) throws Exception {
        int [][] mat =      {
            {1,0,0,0,0,0},
            {0,1,0,0,0,0},
            {0,0,1,0,0,0},
            {0,0,0,1,0,0},
            {0,0,0,0,1,0},
            {0,0,0,0,0,1}
        };
        
        searchDFS(mat,0,0);
    }

    public static void searchDFS(int[][] mat, int col, int row){
        int h = mat.length;
        if (h==0){
            return;
        }
        int l=mat[0].length;
        boolean [][] visited = new boolean[h][l];
        Stack<int []> stack = new Stack<>();
        int [] coord = new int [2];
        stack.push(new int [] {row,col});
        while(!stack.empty()){
            coord = stack.pop();
            row = coord[0];
            col = coord[1];

            if(row<0 || col < 0 || row >= h || col >= h || visited[row][col] ){
                continue;
            }

            visited[row][col]=true;
            System.out.println(mat[row][col]);

            if(col-1 >=0 && mat[row][col-1]!=0){
                stack.push(new int [] {row,col-1});
            }
            if(col+1 < mat[row].length && mat[row][col+1]!=0){
                stack.push(new int [] {row,col+1});
            }
            if(row-1 >=0 && mat[row-1][col]!=0){
                stack.push(new int [] {row-1,col});
            }
            if(row+1 < mat.length && mat[row+1][col]!=0){
                stack.push(new int [] {row+1,col});
            }


            // if(row-1 >=0 && col-1 >= 0 && mat[row-1][col-1]!=0){
            //     stack.push(new int [] {row-1,col-1});
            // }
            // if(row-1 >=0 && col+1 < mat[row].length && mat[row-1][col+1]!=0){
            //     stack.push(new int [] {row-1,col+1});
            // }            
            // if(row+1 < mat.length && col-1 >= 0 && mat[row+1][col-1]!=0){
            //     stack.push(new int [] {row+1,col-1});
            // } 
            // if(row+1 < mat.length && col+1 < mat[row].length && mat[row+1][col+1]!=0){
            //     stack.push(new int [] {row+1,col+1});
            // }                       

        }
    }
    
}
