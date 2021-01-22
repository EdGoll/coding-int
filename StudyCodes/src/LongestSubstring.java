import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String [] args){
        String input1 = "abcabcbb";
        String input2 = "dvdf";
        String input3 = "pwwkew"; //3
        String input4 = "aab";

        int i =  new LongestSubstring().lengthOfLongestSubstring(input3);
System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();    
        int i =0, j=0, ans=0; 
        while(i < s.length() &&   j < s.length()) {
            if(set.contains(s.charAt(j))) {                       
                set.remove(s.charAt(i++)); 
            }else{
               set.add(s.charAt(j++));
               ans = Math.max(ans, j - i);
            }                                                 
        }
        return set.size();        
    }
}

/*
Given a string s, find the length of the longest substring without repeating characters.

abcabcbb
 l  r  

Example 1:

Input: s = "abcabcbb"

Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
Accepted
1,835,747
Submissions
5,944,082
*/


/*
    public int lengthOfLongestSubstring(String s) {
        Set<Character> newSetSubStr = new HashSet<>();
        Set<Character> oldSetSubStr = new HashSet<>();
        int left = 0, right = s.length();        
        
        for (int i = left; i <  right; i++) {
            System.out.println(s.charAt(i));        
            if(newSetSubStr.contains(s.charAt(i))) {
                left++;
                //right = i+1;                 
                System.out.println(i+ " "+ left + " "+ right);
                if(newSetSubStr.size() > oldSetSubStr.size()){
                    oldSetSubStr = newSetSubStr;                       
                }
                //newSetSubStr = new HashSet<>();
                
            }else{
                
                newSetSubStr.add(s.charAt(i));
            } 
                                                
        }

        System.out.println("-------------------------------");
        if(newSetSubStr.size() > oldSetSubStr.size()){
            oldSetSubStr = newSetSubStr;                       
        }

        return oldSetSubStr.size();
        
    }

*/