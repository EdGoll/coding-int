import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SearchinRotatedSortedArray {

    public static void main(String [] args){
        int [] nums = {5,1,2};
        int target = 2;
        System.out.println(new SearchinRotatedSortedArray().search(nums, target));

    }

   
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1; 
            while (l <= r) { 
                int m = (l + r) / 2;             
                if (nums[m] == target){ 
                    return m; 
                }
                
                if(nums[l]<=nums[m]){
                    if (target > nums[m] || target < nums[l]) {
                        l = m + 1; 
                    }else{
                        r = m - 1; 
                    }
                }else{
                    if (target < nums[m] || target > nums[r]) {
                        r = m - 1;
                    }else{
                        l = m + 1;
                    }
                }
    
            }
            return -1; 
        } 
    

    
}



// public int search(int[] nums, int target) {
//     int i = 0, j = 0;
//     if(nums.length == 1){
//         if(nums[0]== target) {
//             return 0;
//         }else{
//             return -1;
//         }
//     }
//     while(i + 1 < nums.length && nums[i] <= nums[i + 1]){
//         System.out.println(nums[i]);
//         i++;
//     }       
//     if (target >= nums[0]  &&  target <= nums[i]){
//         j =  this.binarySearch(Arrays.copyOfRange(nums, 0, i+1),target);
//     }else if  (target >= nums[i+1]  &&  target <= nums[nums.length-1]) {
//         j = this.binarySearch(Arrays.copyOfRange(nums, i+1 , nums.length),target);
//         j = (j == -1 ?  -1 : j + i+1);
//     }else return -1        ;
//     return  j;
// }