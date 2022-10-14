class Solution {

    // problem link -- https://leetcode.com/problems/number-of-enclaves/description/
    public int numEnclaves(int[][] grid) {
        int count = 0;
        
        // first row
        for(int i = 0, j = 0; j < grid[0].length;j++){
            int val = grid[i][j];
            
            if(val == 1) dfs(i, j, grid);
        }
        
        // last row
        for(int i = grid.length-1, j = 0; j < grid[0].length;j++){
            int val = grid[i][j];
            
            if(val == 1) dfs(i, j, grid);
        }
        
        // first column
        for(int i = 0, j = 0; i < grid.length; i++){
            int val = grid[i][j];
            
            if(val == 1) dfs(i, j, grid);
        }
        
        // last column
        for(int i = 0, j = grid[0].length-1; i < grid.length ; i++){
            int val = grid[i][j];
            
            if(val == 1) dfs(i, j, grid);
        }
        
        // Now count the number of enclaves
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1) count++;
            }
        }
        
        return count;
    }

    private static void dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;

        grid[i][j] = 0;

        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }


}



// ROUGH WORK









