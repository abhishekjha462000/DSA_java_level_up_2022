private static void run(String str){
        HashMap<Character,Integer> map = new HashMap<>();


        int ss = 0;
        int ee = 0;

        int aa = 0;
        int rr = 0;

        int maxLen = Integer.MIN_VALUE;

        while(aa <= str.length()){

            if(aa != str.length()){
                char ch = str.charAt(aa);

                //  update the length

                int len = aa-rr;

                if(len > maxLen){
                    ss = rr;
                    ee = aa;
                    maxLen = len;
                }

                if(map.containsKey(ch) == false){
                    // just put this into the map with the index
                    // store previous length
                    map.put(ch,aa);
                    aa++;
                    
                }else{

                    int prevIndex = map.get(ch);

                    while(rr != prevIndex+1){
                        map.remove(str.charAt(rr));
                        ++rr;
                    }

                    map.put(ch,aa);
                    aa++;
                }

            }else{
                // here aa = str.length();

                int len = aa-rr;

                if(len > maxLen)
                {
                    ss = rr;
                    ee = aa;
                    maxLen = len;
                }
                aa++;
            }
        }

        System.out.println(str.substring(ss,ee));
    }


    