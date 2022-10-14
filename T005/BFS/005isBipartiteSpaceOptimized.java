    private static boolean isBipartite(List<Edge>[] graph){
        int nvtces = graph.length;
        int[] vis = new int[nvtces]; // common visited array

        Arrays.fill(vis, -1); // vis[idx] = -1 would mean that vertex with idx has not been visited

        for(int src = 0 ; src < nvtces;src++){
            if(vis[src] == -1){ // run bfs only if it has not been visited
                Queue<Pair> queue = new ArrayDeque<>();

                queue.add(new Pair(src, 0));

                while(!queue.isEmpty()){
                    Pair removed = queue.remove(); // remove

                    int vtx = removed.vtx;
                    int level = removed.level;

                    if(vis[vtx] == -1){
                        // This means that it is umarked
                        vis[vtx] = level; // mark*

                        for(Edge e : graph[vtx]){
                            int nbr = e.nbr;

                            if(vis[nbr] == -1){ // add*
                                queue.add(new Pair(nbr, level + 1));
                            }
                        }
                    }else{
                        // This means that it has been previously visited
                        if(level % 2 == 0 && vis[vtx] % 2 == 1) return false;
                        if(level % 2 == 1 && vis[vtx] % 2 == 0) return false;
                    }
                }
            }
        }

        return true;
    }

    private static class Pair{
        int vtx;
        int level;

        Pair(){}
        Pair(int vtx, int level){
            this.vtx = vtx;
            this.level = level;
        }
        Pair(Pair other){
            this.vtx = other.vtx;
            this.level = other.level;
        }

        @Override
        public String toString(){
            return vtx + "@" + level;
        }
    }