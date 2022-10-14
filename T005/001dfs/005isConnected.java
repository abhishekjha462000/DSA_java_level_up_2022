    private static boolean isConnected(List<Edge>[] graph){
        int nvtces = graph.length;

        boolean[] vis = new boolean[nvtces];
        dfs(0, graph, vis);

        /**
         * Why this ?
         * 
         * Because if the graph were connected, then after running dfs once all the vertices would be marked as true
         * So if we somehow find a vertex which was not marked as true then this means that graph is not connected.
         **/

        for(int i = 0 ; i < vis.length;i++){
            if(!vis[i]) return false;
        }

        return true;
    }

    private static void dfs(int src, List<Edge>[] graph, boolean[] vis){
        vis[src] = true;

        for(Edge e : graph[src]){
            int nbr = e.nbr;

            if(!vis[nbr]){
                dfs(nbr, graph, vis);
            }
        }
    }


    // ROUGH WORK




