private static void run(String str){

        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);

            map2.put(ch,1);
        }

        int ss = 0;
        int ee = str.length()-1;

        int aa = -1;
        int rr = -1;

        int minLength = Integer.MAX_VALUE;
        int count = 0;


        HashMap<Character,Integer> map1 = new HashMap<>();

        while(true){
            boolean f1 = false;
            boolean f2 = false;

            // acquire

            while(aa < str.length()-1 && count < map2.size()){
                f1 = true;
                aa++;

                char acq = str.charAt(aa);

                map1.put(acq,map1.getOrDefault(acq,0)+1);

                // count should be increased or not

                if(map1.get(acq) == 1)
                    count++;
            }

            // release

            while(rr < aa && count == map2.size())
            {
                f2 = true;

                // store the previous string
                int len = aa-rr+1;

                if(len < minLength){
                    ss = rr;
                    ee = aa;
                    minLength = len;
                }

                rr++;

                char rel = str.charAt(rr);

                // count should be decreased or not

                if(map1.get(rel) == 1)
                    count--;

                int freq = map1.get(rel);

                if(freq == 1)
                {
                    map1.remove(rel);
                }else{
                    map1.put(rel,map1.get(rel)-1);
                }
            }

            if(f1 == false && f2 == false)
                break;
        }

        System.out.println(str.substring(ss+1,ee+1));
    }