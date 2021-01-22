import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[][] mat = { { 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1 } };
        int k = 0;
        for (int i = 0; i < mat.length - 1; i++) {
            System.out.println(mat[i + k][i]);
        }

    }

    public int[] twoSum(int[] nums, int target) {
        int[] indxs = new int[2];
        Map<Integer, Integer> l = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (!l.containsKey(nums[i])) {
                l.put(nums[i] - 9, i);
            } else {
                indxs[0] = l.get(nums[i]);
                indxs[1] = i;
                return indxs;
            }

        }
        return null;
    }
}
