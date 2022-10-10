import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;


class graphInput{

	private static class Edge {
		int src;
		int nbr;

		Edge(){}
		Edge(int src, int nbr){
			this.src = src;
			this.nbr = nbr;
		}

		@Override
		public String toString(){
			return src + "->" + nbr;
		}

	}

    public static void main(String[] args) throws IOException {
        initializeIO();

        Scanner scn = new Scanner(System.in);

        int nvtces = scn.nextInt();
        int nedges = scn.nextInt();

        List<Edge>[] graph = new ArrayList[nvtces];

        for(int i = 0;i < nvtces;i++){
        	graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < nedges ;i++){
        	int v1 = scn.nextInt();
        	int v2 = scn.nextInt();

        	// Since graph is assumed to be bidirectional by default
        	graph[v1].add(new Edge(v1, v2));
        	graph[v2].add(new Edge(v2, v1)); // In case the graph is directed we do not need this line
        }


        print(graph);
    }

    private static void print(List<Edge>[] graph) {
    	int nvtces = graph.length;

    	for(int i = 0;i<nvtces;i++){
    		System.out.println(i + "->" + graph[i]);
    	}
    }

    private static void initializeIO() {
        try 
        {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            System.setErr(new PrintStream(new FileOutputStream("error.txt")));
        }
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }
}