import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public static void main(String[] args) {
        int [] nums = {-2,-1,-1,1,1,2,2}; //[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        //List<List<Integer>> l = new ThreeSum().threeSum(nums);
        List<List<Integer>> l = new ThreeSum().fourSum(nums,0);

        System.out.println(l);
    }

    public List<List<Integer>> fourSum(int[] nums, Integer target) {                
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sumTreeList = null;
        Arrays.sort(nums);
        int l = 0, r = 0, n = 0, sum = 0;
        for ( int k = 0 ; k < nums.length ; k++ ){
            
            for( int i = k +1  ; i < nums.length ; i++ ){
                n = nums[i];

                r = nums.length - 1;
                l = i + 1;

                int t2 = target - (nums[i] + nums[k]);

                while ( l < r ){
                    sum = nums[l] + nums[r]  ;
                    if ( sum > t2 ){
                        r -= 1;
                    }else if(sum < t2 ){
                        l += 1;
                    }else{
                        sumTreeList = new ArrayList<Integer>();
                        sumTreeList.add(nums[k]);
                        sumTreeList.add(n);
                        sumTreeList.add(nums[l]);
                        sumTreeList.add(nums[r]);
                        list.add(sumTreeList);
                        l += 1;
                        while (nums[l] == nums[l - 1] && l < r) {
                            l += 1;
                        } 
                        while (r < nums.length -1 && nums[r] == nums[r + 1] ) {
                            r -= 1;
                        }                                            
                    }
                }
                if (i + 1  < nums.length -1  && nums[i] == nums[i + 1]){
                    i++;
                }
            }
            if ( k + 1  < nums.length -1 &&  nums[k] == nums[k + 1] ){                    
                k++;
            }
        }
        return list;
    }
    

    public List<List<Integer>> threeSum(int[] nums) {        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sumTreeList = null;
        Arrays.sort(nums);

        int l = 0, r = 0, n = 0, sum = 0;

        for( int i = 0 ; i < nums.length ; i++ ){

            n = nums[i];

            if (i > 0 && n == nums[i - 1]){
                continue;
            }

            r = nums.length - 1;
            l = i + 1;
            

            while (l < r){

                sum = n + nums[l] + nums[r];

                if ( sum > 0 ){
                    // keep serching from right
                    r -= 1;

                }else if(sum < 0){
                    // keep serching from left
                    l += 1;

                }else{
                    // get de ans
                    sumTreeList = new ArrayList<Integer>();
                    sumTreeList.add(n);
                    sumTreeList.add(nums[l]);
                    sumTreeList.add(nums[r]);
                    list.add(sumTreeList);
                    l += 1;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l += 1;
                    }
                    
                }

            }

        }


        return list;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] indxs = new int[2];

        Map<Integer, Integer> l = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {

            if (!l.containsKey(nums[i])) {
                l.put(target - nums[i], i);
            } else {
                indxs[0] = l.get(nums[i]);
                indxs[1] = i;
                return indxs;
            }

        }
        return null;
    }
    
}
