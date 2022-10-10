    private static void printAllPaths(int src, int dest, List<Edge>[] graph){
        int nvtces = graph.length;
        boolean[] vis = new boolean[nvtces];

        printAllPathsHelper(src, dest, graph, vis, "");
    }

    private static void printAllPathsHelper(int src, int dest, List<Edge>[] graph, boolean[] vis, String ans){
        ans += src +"";
        // vis[src] = true; // We cannot place this line here as after printing a path the destination would be marked as true and hence we would then never go there

        if(src == dest){
            System.out.println(ans);
            return ;
        }

        vis[src] = true;

        for(Edge e : graph[src]){
            int nbr = e.nbr;

            if(!vis[nbr]){
                printAllPathsHelper(nbr, dest, graph, vis, ans);
            }
        }

        vis[src] = false;

    }




    // ROUGH WORK






    