import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
    
		    //write your code here
        Set<Integer> ans = new HashSet<>();

        for(int i : arr){
            ans.add(i);
        }

        int k = ans.size();

        int count = 0;

        int aa = 0;
        int rr = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        
        while(aa < arr.length){
            boolean flag = true;
            while(aa < arr.length && count < k){
                int val = arr[aa];

                if(map.containsKey(val)){
                    map.put(val,map.get(val)+1);
                }else{
                    map.put(val,1);
                    count++;
                }

                flag = false;
                aa++;
            }
            
            // aa signifies that all the values till aa-1(including) have been acquired
            // rr signifies that all the values till rr-1(including) have been released

            // Now release

            while(count == k && rr < aa){
                int val = arr[rr];

                count += arr.length-(aa-1);

                // now release the element at rr index

                int ff = map.get(val);

                if(ff == 1)
                {
                    map.remove(val);
                    count--;
                }else{
                    map.put(val,ff-1);
                }

                flag = false;
                rr++;
            }

            if(flag)
                break;
        }
        
        // if.(map.size() == k)

        System.out.println(count);
		
	}


}
