    private static void bfs(int src, List<Edge>[] graph){
        int nvtces = graph.length;
        Queue<Integer> mq = new ArrayDeque<>();
        Queue<Integer> hq = new ArrayDeque<>();
        boolean[] vis = new boolean[nvtces];
        mq.add(src);

        // This works on rpa algorithm which means remove print and add algorithm
        // print and add are only done for unvisited vertices and before doing this we mark the vertex as visited.

        while(!mq.isEmpty()){
            // remove print and add
            int removed = mq.remove(); // remove


            if(!vis[removed]){ // if unvisited then print and add the neighbours
                vis[removed] = true;
                System.out.print(removed + " "); // print

                for(Edge e : graph[removed]){
                    hq.add(e.nbr); // add the neighbors
                }
            }

            if(mq.isEmpty()){
                System.out.println();
                Queue<Integer> temp = hq;
                hq = mq;
                mq = temp;

            }

        }
    }



    // ROUGH WORK





