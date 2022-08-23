    public static void main(String[] args) throws IOException{
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        HashMap<String,String> hm = new HashMap<>();

        for(int i = 0; i < n ;i++){
            String src = scn.next();
            String dest = scn.next();

            hm.put(src,dest);
        }

        run(hm);

    }

    private static void run(HashMap<String,String> hm){

        HashMap<String,Boolean> ynMap = new HashMap<>();

        /**
         * Assume that every point is a starting point
         **/
        for(String key : hm.keySet()){
            ynMap.put(key,true);
        }

        /**
         * Now iterate over the hm and mark the desc that are visited by some other place as false, as you cannot visit a starting point
         **/
        
        for(String key : hm.keySet()){

            String src = key;
            String desc = hm.get(key);

            ynMap.put(desc, false);
        }

        // System.out.println(ynMap);

        String start = "";

        for(String key : ynMap.keySet()){
            if(ynMap.get(key)) start = key;
        }

        while(true){

            if(hm.containsKey(start))
            {
                System.out.print(start + " -> ");
                start = hm.get(start);
            }else{

                System.out.print(start + ".");
                break;
            }

        }

    }


    // 1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).

    // 2. You have to find the itinerary in order using the given list of tickets.



    // Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination. 




    // 4
    // Chennai Banglore
    // Bombay Delhi
    // Goa Chennai
    // Delhi Goa