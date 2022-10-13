class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0; // count of fresh oranges
        
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Pair> queue = new ArrayDeque<>();
        
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){

                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j));
                }else if(grid[i][j] == 1){
                    fresh++;
                }

            }
        }
        
        // This means that initially there were no oranges so time taken would be zero
        if(fresh == 0 && queue.size() == 0){
            return 0;
        }
        
        int time = -1;
        
        // For moving in four directions
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                Pair removed = queue.remove();
                int row = removed.row;
                int col = removed.col;
                
                for(int i = 0;i<dir.length;i++){
                    int dx = dir[i][0];
                    int dy = dir[i][1];
                    
                    int x  = row + dx;
                    int y  = col + dy;
                    
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                        grid[x][y] = 0;
                        queue.add(new Pair(x, y));
                        fresh--;
                    }
                }
            }
            
            time++;
        }
        
        // If after the process the number of fresh oranges then we were succesfull otherwise as mentioned in the question we return -1 as it is not possible to rot all the oranges
        if(fresh == 0) return time;
        else return -1;
    }
    
    
    private static class Pair{
        int row;
        int col;
        
        Pair(){}
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
        
        Pair(Pair other){
            this.row = other.row;
            this.col = other.col;
        }
    }
}



// ROUGH WORK







