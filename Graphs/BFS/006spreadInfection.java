   // problem -- https://www.pepcoding.com/resources/online-java-foundation/graphs/infection-spread-official/ojquestion
   private static int timeTaken(int src, int t, List<Edge>[] graph){
      int nvtces = graph.length;
      int count = 0;

      Queue<Pair> queue = new ArrayDeque<>();
      boolean[] vis = new  boolean[nvtces];

      queue.add(new Pair(src, 1));

      while(!queue.isEmpty()){
         Pair removed = queue.remove();

         int vtx = removed.vtx;
         int time = removed.time;
         
         
         if(!vis[vtx]){
            vis[vtx] = true;
            if(time <= t) count++;
            
            for(Edge e : graph[vtx]){
               if(!vis[e.nbr]){
                  queue.add(new Pair(e.nbr, time +1));
               }
            }
         }
      }
      return count;

   }

   private static class Pair{
      int vtx;
      int time;

      Pair(){}
      Pair(int vtx, int time){
         this.vtx = vtx;
         this.time = time;
      }

      Pair(Pair other){
         this.vtx = other.vtx;
         this.time = other.time;
      }

      @Override
      public String toString(){
         return vtx + "@" + time;
      }
   }