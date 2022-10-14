   private static boolean isBipartite(List<Edge>[] graph){
      int nvtces = graph.length;

      boolean[] vis = new boolean[nvtces];

      for(int src = 0; src < nvtces; src++){
         if(!vis[src]){
            // run bfs on it
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            Queue<Pair> queue = new ArrayDeque<>();

            queue.add(new Pair(src, 0));

            while(!queue.isEmpty()){
               Pair removed = queue.remove();

               int vtx = removed.vtx;
               int level = removed.level;

               if(!vis[vtx]){
                  vis[vtx] = true;

                  if(level % 2 == 0) even.add(vtx);
                  else odd.add(vtx);

                  for(Edge e : graph[vtx]){
                     int nbr = e.nbr;

                     if(!vis[nbr]){
                        queue.add(new Pair(nbr, level + 1));
                     }
                  }
               }else{
                  if(level % 2 == 0 && odd.contains(vtx)) return false;
                  if(level % 2 == 1 && even.contains(vtx)) return false;
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



   // ROUGH WORK









