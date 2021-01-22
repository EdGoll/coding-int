import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianofTwoSortedArrays {

    public static void main(String[] args) {

        // nums1 = [1,3], nums2 = [2] Output: 2.00000
        // nums1 = [1,2], nums2 = [3,4] 2.50000
        // nums1 = [0,0], nums2 = [0,0] Output: 0.00000
        // Input: nums1 = [], nums2 = [1] Output: 1.00000
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };

        new MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2);

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double resp = 0;        
        int[] arrAux = new int[nums1.length + nums2.length];
        int indx = 0;

        for (int i : nums1) {
            arrAux[indx] = i;
            indx++;
        }
        for (int i : nums2) {
            arrAux[indx] = i;
            indx++;            
        }

        Arrays.sort(arrAux);

        if(arrAux.length % 2 == 0){
            resp = (double)((arrAux[(arrAux.length/2) - 1] + arrAux[arrAux.length/2])*1.000 / 2);            
        }else{
            resp = (double)arrAux[arrAux.length/2]*1.000;
        }
System.out.println(resp);
        return resp;
    }

}
