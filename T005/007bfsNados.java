   /**
    * 7
    * 8
    * 0 1
    * 1 2
    * 2 3
    * 0 3
    * 3 4
    * 4 5
    * 5 6
    * 4 6
    * 2
    * 
    * If starting vertex is 2 the output must be 
    * 2@2
    * 1@21
    * 3@23
    * 0@210
    * 4@234
    * 5@2345
    * 6@2346
    **/

   private static void bfs(int src, List<Edge>[] graph){
      int nvtces = graph.length;

      Queue<BFSPair> queue = new ArrayDeque<>();
      boolean[] vis = new boolean[nvtces];

      queue.add(new BFSPair(src, src + ""));
      

      // remove, [mark*, work, add*]
      while(queue.size() > 0){
         BFSPair removed = queue.remove(); // remove

         String path = removed.path;

         if(!vis[removed.vtx]){
            vis[removed.vtx] = true; // mark

            System.out.println(removed); // work

            for(Edge e : graph[removed.vtx]){
               int nbr = e.nbr;

               if(!vis[nbr]){ // add
                  queue.add(new BFSPair(nbr, path + nbr));
               }
            }

         }
      }
   }

   private static class BFSPair{
      int vtx;
      String path; // stores the path from src to vtx in the form of a string

      BFSPair(){}

      BFSPair(int vtx, String path){
         this.vtx = vtx;
         this.path = path;
      }

      BFSPair(BFSPair other){
         this.vtx = other.vtx;
         this.path = other.path;
      }

      @Override
      public String toString(){
         return vtx +  "@" + path;
      }
   }



   // ROUGH WORK


   


