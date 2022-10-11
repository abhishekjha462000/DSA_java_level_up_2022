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
      Queue<MyEdge> mq = new ArrayDeque<>();
      // Queue<MyEdge> hq = new ArrayDeque<>();
      boolean[] vis = new boolean[graph.length];
      mq.add(new MyEdge(src, "" + src));

      while(!mq.isEmpty()){
         MyEdge removed = mq.remove();

         int srcRem = removed.src;

         if(!vis[srcRem]){
            vis[srcRem] = true;

            // print and add
            System.out.println(srcRem + "@" + removed.path);

            for(Edge e : graph[srcRem]){
               int nbr = e.nbr;
               mq.add(new MyEdge(nbr, removed.path + nbr));
            }

         }

      }

   }

   private static class MyEdge{
      int src;
      String path;

      MyEdge(){}
      MyEdge(int src, String path){
         this.src = src;
         this.path = path;
      }
   }



   // ROUGH WORK


   


