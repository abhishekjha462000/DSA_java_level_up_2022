    public static List<String> grayCode(int n){
        if(n == 1){
            List<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");

            return base;
        }

        List<String> ans = new ArrayList<>();

        List<String> rres = grayCode(n-1);
        
        for(String str : rres){
            ans.add("0" + str);
        }
        for(int i = rres.size()-1; i >= 0;i--){
            ans.add("1" + rres.get(i));
        }
        return ans;
    }


    // 0 as the base case
    
    // public static List<String> grayCode(int n){
    //     if(n == 0){
    //         List<String> base = new ArrayList<>();
    //         base.add("");
    //         return base;
    //     }

    //     List<String> ans = new ArrayList<>();

    //     List<String> rres = grayCode(n-1);

    //     for(String str : rres){
    //         ans.add("0" + str);
    //     }
    //     for(int idx = rres.size()-1; idx >= 0;idx--){
    //         ans.add("1" + rres.get(idx));
    //     }
    //     return ans;
    // }

    
    // ROUGH WORK




    