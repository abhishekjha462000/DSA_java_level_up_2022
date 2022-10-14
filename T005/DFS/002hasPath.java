    private static boolean hasPath(int src, int dest, List<Edge>[] graph){
        int nvtces = graph.length;

        boolean[] vis = new boolean[nvtces];
        return hasPathHelper(src, dest, graph, vis);

    }

    private static boolean hasPathHelper(int src, int dest, List<Edge>[] graph, boolean[] vis){
        if(src == dest)
            return true;

        vis[src] = true;

        // Move to the unvisited neighbours of src
        for(Edge e : graph[src]){
            int nbr = e.nbr;
            if(!vis[nbr]){
                boolean rres = hasPathHelper(nbr, dest, graph, vis);
                if(rres) return true;
            }
        }

        // vis[src] = false; // This is extra step
        return false;

    }



    // ROUGH WORK





    