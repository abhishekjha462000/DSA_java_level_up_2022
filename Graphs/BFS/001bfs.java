    /**
     * bfs always gives us the shortest path between two vertices in a graph.
     * This concept can be used to find the minimum time to spread a infection or 
     * something like that.
     **/

    private static void bfs(int src, List<Edge>[] graph){
        int nvtces = graph.length;

        Queue<Integer> mq = new ArrayDeque<>();
        Queue<Integer> hq = new ArrayDeque<>();
        boolean[] vis = new boolean[nvtces];

        mq.add(src);

        /**
         * works on remove, mark*, work and add* algorithm
         * mark*, work and add* are only done for unvisited vertices
         **/

        /**
         * Why we are using * after mark and add ?
         * These steps are only performed when the vertex to be marked is unmarked and vertex to be added is unmarked
         **/
        while(mq.size() > 0){
            int removed = mq.remove(); // remove

            if(!vis[removed]){ // mark*, work and add*
                vis[removed] = true; // mark* 
                System.out.print(removed + " "); // work

                // Now add* the neighbor unvisited vertices
                for(Edge e : graph[removed]){
                    int nbr = e.nbr;

                    if(!vis[nbr]){
                        hq.add(nbr);
                    }
                }
            }

            if(mq.isEmpty()){
                Queue<Integer> temp = mq;
                mq = hq;
                hq = temp;
                System.out.println();
            }
        }
    }



    // ROUGH WORK





