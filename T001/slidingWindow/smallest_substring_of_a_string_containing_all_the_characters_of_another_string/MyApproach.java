private static void run(String s1,String s2){

        HashMap<Character,Integer> map2 = new HashMap<>();

        /**
         * Make frequency map for string s2
         **/
        for(int i = 0;i<s2.length();i++){
            char ch = s2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }


        /**
         * Now we need to find the substring of s1 with minimum length which consists of s2
         **/

        HashMap<Character,Integer> map1 = new HashMap<>();

        int ss = 0;
        int ee = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;

        int aa = -1; // acquire variable
        int rr = -1; // release variable

        /**
         * Why infinite while loop ? -- think
         **/

        while(true)
        {
            // count can never exceed s2.length()
            if(aa < s1.length()-1 && count < s2.length()){
                /**
                 * Why aa < s1.length()-1 ?
                 * 
                 * Because if aa == s1.length()-1 then aa++ == s1.length() which would create an error in charAt() method
                 * 
                 **/
                /**
                 * do something -- acquire the character
                 **/
                aa++; // character at aa has been acquired

                char acq = s1.charAt(aa); //  acquired character

                // put this character into the map1

                map1.put(acq,map1.getOrDefault(acq,0)+1);

                // Since we have acquired a character we need to decide if the count must be increased or not

                // for count to be increased acq must be a valid character i.e., it must be present in map2 and its frequency in map1 <= frequency in map2

                if(map2.containsKey(acq) && map1.get(acq) <= map2.get(acq))
                    count++;

            }else{
                /**
                 * release the characters
                 **/

                // before releasing store the string config

                int len = aa-rr+1;

                /**
                 * Why did i specifally write count == s2.length() in the below condition ?
                 * 
                 * Because we can come from above if condition due to two reasons either due to aa == s1.length()-1 or (aa < s1.length()-1 && count == s2.length())
                 * The second is fine but first is not as in that case it might happen that aa == s1.length()-1 && count < s2.length() and still we would be changing our answer which is not present as we need to change only if we have all the characters of s2
                 **/
                if(count == s2.length() && len < minLength)
                {
                    ss = rr;
                    ee = aa;
                    minLength = len;
                }

                rr++; // release the character

                char rel = s1.charAt(rr); //  released character

                // check if count should be decreased or not

                // for that to happen rel must be a valid character and map1.get(rel) <= map2.get(rel)

                if(map2.containsKey(rel) && map1.get(rel) <= map2.get(rel))
                    count--;

                // Now decrease the frequncy of rel in map1

                // Now this is a tricky part as if map1.get(rel) == 1, then we need to remove it completely
                // Otherwise, just decrease the frequency

                int freq = map1.get(rel);

                if(freq == 1)
                    map1.remove(rel);
                else
                    map1.put(rel,map1.get(rel)-1);

            }

            if(rr == aa)
                break;
        }


        System.out.println(s1.substring(ss+1,ee+1));
    }