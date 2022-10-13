class Solution {
    private static class Edge{
        int src;
        int nbr;
        
        Edge(){}
        
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
        
        Edge(Edge other){
            this.src = other.src;
            this.nbr = other.nbr;
        }
        
        @Override
        public String toString(){
            return src + "->" + nbr;
        }
    }

    public int findCircleNum(int[][] grid) {
        int n = grid.length;

        // We will convert the grid into a graph and then find the number of connected components of this constructed graph
        List<Edge>[] graph = new ArrayList[n];
        
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0 ;i < n;i++){
            for(int j = 0; j < n;j++){

                // The reason we did i != j as that is not something we should take into account as a city is by default connected to itself
                if(i != j && grid[i][j] == 1){
                    // This means that there is a edge between i and j
                    graph[i].add(new Edge(i, j));
                    graph[j].add(new Edge(j, i));
                    
                    // I did this so that i do not add this edge again
                    grid[j][i] = 0;
                }
            }
        }
        
        boolean[] vis = new boolean[n]; // common visited array
        
        int count = 0 ; // counts the number of connected components
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                // run the dfs on it
                count++;
                dfs(i, graph, vis);
            }
        }
        
        return count;
    }
    
    // simple dfs algorithm
    private static void dfs(int src, List<Edge>[] graph, boolean[] vis){
        vis[src] = true;
        
        for(Edge e : graph[src]){
            int nbr = e.nbr;
            
            if(!vis[nbr]){
                dfs(nbr, graph, vis);
            }
        }
        
    }
}



// ROUGH WORK






