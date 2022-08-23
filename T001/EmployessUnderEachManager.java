     public static void main(String[] args) throws IOException{

        Scanner scn = new Scanner(System.in);

        int n =  scn.nextInt();

        HashMap<String,HashSet<String>> hm = new HashMap<>();

        String ceo = "";

        while(n-- != 0){
        	String employee = scn.next();
        	String manager = scn.next();


        	if(manager.equals(employee)){
                ceo = manager;
        		continue;
        	}

        	if(hm.containsKey(manager)){
        		HashSet<String> hs = hm.get(manager);
        		hs.add(employee);
        	}else{
        		HashSet<String> hs = new HashSet<>();

        		hs.add(employee);
        		hm.put(manager,hs);
        	}
        }
        // System.out.println(hm);

        HashMap<String,Integer> ans = new HashMap<>();

        run(hm,ans,ceo);

        for(String key : ans.keySet()){
            System.out.println(key + " " + ans.get(key));
        }
    }

    private static int run(HashMap<String,HashSet<String>> hm,HashMap<String,Integer> ans,String manager){

        if(hm.containsKey(manager) == false){
            ans.put(manager,0);
            return 1;
        }

        int temp = 0 ;

        for(String employees : hm.get(manager)){
            temp += run(hm,ans,employees);
        }
    
        ans.put(manager,temp);

        return temp + 1;
    }

    // 1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.

    // 2. An employee directly reports to only one manager. 

    // 3. All managers are employees but the reverse is not true.

    // 4. An employee reporting to himself is the CEO of the company.

    // 5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.

    // 6
    // A C
    // B C
    // C F
    // D E
    // E F
    // F F


