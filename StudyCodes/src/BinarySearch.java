public class BinarySearch {
    
    int serchBS(int[] arr, int target){

        int l = 0;
        int r = arr.length - 1;

        while (l <= r){
            int m = 1 + ( r - 1 ) / 2;

            if (arr[m] == target) return m;

            if (arr[m] < target) l = m + 1;

            else r = m - 1;
        }

        return -1;
    }

}
