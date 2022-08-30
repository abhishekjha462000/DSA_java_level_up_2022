private static void run(String str){

        HashMap<Character,Integer> map = new HashMap<>();

        int ss = 0;
        int ee = 0;

        int rr = -1;
        int aa = -1;

        int count = 0;
        int maxLength = Integer.MIN_VALUE;

        while(aa < str.length()-1){
            aa++;

            char acq = str.charAt(aa);

            if(map.containsKey(acq) == false){
                map.put(acq,aa);
                int len = aa-rr;

                if(maxLength < map.size())
                {
                    ss = rr;
                    ee = aa;
                    maxLength = len;
                }
                // System.out.println("added : "+acq+" "+aa+" "+map+" "+ss+" "+ee);
            }else{
                int len = aa-rr;

                if(maxLength < map.size())
                {
                    ss = rr;
                    ee = aa;
                    maxLength = len;
                }

                int prevIdx = map.get(acq);

                while(rr != prevIdx)
                {
                    map.remove(str.charAt(++rr));
                    // System.out.println("removed : "+str.charAt(rr)+" "+rr+" "+map+" "+ss+" "+ee);
                }


                map.put(acq,aa);
                // System.out.println("added : "+acq+" "+aa+" "+map+" "+ss+" "+ee);

            }
        }

        System.out.println(str.substring(ss+1,ee+1));
    }