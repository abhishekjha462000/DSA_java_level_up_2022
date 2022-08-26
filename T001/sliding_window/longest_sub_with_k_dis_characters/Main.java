private static void run(String str,int k){

        HashMap<Character,Integer> map = new HashMap<>();

        int aa = -1;
        int rr = -1;

        int ss = 0;
        int ee = 0;

        int count = 0;
        int maxLength = Integer.MIN_VALUE;

        while(true){
            
            boolean f1 = false;
            boolean f2 = false;

            // acquire
            while(aa < str.length()-1){
                f1 = true;
                aa++;
                char acq =  str.charAt(aa);

                map.put(acq,map.getOrDefault(acq,0)+1);

                if(map.size() > k)
                    break;
                
                if(map.size() == k)
                {
                    int len = aa-rr;

                    if(maxLength < len)
                    {
                        ss = rr;
                        ee = aa;
                        maxLength = len;
                    }
                }
            }

            // release

            while(rr < aa){
                f2 = true;
                rr++;
                char rel = str.charAt(rr);

                int freq = map.get(rel);


                if(freq == 1)
                {
                    map.remove(rel);
                }else{
                    map.put(rel,map.get(rel)-1);
                }

                if(map.size() == k)
                {
                    int len = aa-rr;

                    if(maxLength < len){
                        ss = rr;
                        ee = aa;
                        maxLength = len;
                    }
                    break;
                }
            }

            if(f1 == false && f2 == false)
                break;
        }

        System.out.println(str.substring(ss+1,ee+1));

    }