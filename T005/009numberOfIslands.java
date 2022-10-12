class Solution {
    public int numIslands(char[][] grid) {
        int count = 0; // counts the total number of islands

        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m ;i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, char[][] grid){
        // Here grid[i][j] == '0' condition is very necessary otherwise we would be trapped in an infinite loop.
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }

}



// ROUGH WORK






