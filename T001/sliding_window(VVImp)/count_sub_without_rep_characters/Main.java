private static void run(String str){
        int count = 0;

        int aa = -1;
        int rr = -1;

        HashMap<Character,Integer> map = new HashMap<>();

        while(true){
            boolean f1 = false;
            boolean f2 = false;
            // acquire
            while(aa < str.length()-1){
                f1 = true;
                aa++;

                char acq = str.charAt(aa);

                map.put(acq,map.getOrDefault(acq,0)+1);
                if(map.get(acq) == 2){ 
                    break;
                }else{
                    int len = aa-rr;
                    count += len;
                }
            }

            // Now release

            while(rr < aa){
                f2 = true;
                rr++;

                char rel = str.charAt(rr);

                map.put(rel,map.get(rel)-1);

                if(map.get(rel) == 1)
                {
                    count += aa-rr;
                    break;
                }
            }

            if(f1 == false && f2 == false)
                break;
        }

        System.out.println(count);
    }