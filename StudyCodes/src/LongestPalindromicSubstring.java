import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class LongestPalindromicSubstring {



    public static void main(String [] args){
         String input1 = "babad";
        String input2 = "cbbd";
        String input3 = "a"; //3
        String input4 = "ac";
        String input5 = "bb";
        String input6 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String input7 = "aacabdkacaa";
        String input8 = "dtgrtoxuybwyfskikukcqlvprfipgaygawcqnfhpxoifwgpnzjfdnhpgmsoqzlpsaxmeswlhzdxoxobxysgmpkhcylvqlzenzhzhnakctrliyyngrquiuvhpcrnccapuuwrrdufwwungaevzkvwbkcietiqsxpvaaowrteqgkvovcoqumgrlsxvouaqzwaylehybqchsgpzbkfugujrostopwhtgrnrggocprnxwsecmvofawkkpjvcchtxixjtrnngrzqpiwywmnbdnjwqpmnifdiwzpmabosrmzhgdwgcgidmubywsnshcgcrawjvfiuxzyzxsbpfhzpfkjqcpfyynlpshzqectcnltfimkukopjzzmlfkwlgbzftsddnxrjootpdhjehaafudkkffmcnimnfzzjjlggzvqozcumjyazchjkspdlmifvsciqzgcbehqvrwjkusapzzxyiwxlcwpzvdsyqcfnguoidiiekwcjdvbxjvgwgcjcmjwbizhhcgirebhsplioytrgjqwrpwdciaeizxssedsylptffwhnedriqozvfcnsmxmdxdtflwjvrvmyausnzlrgcchmyrgvazjqmvttabnhffoe";
        String input9 = "pihoigwlvzvtrugdolvtzrkyelaqdvbijzmkhebzawboaxkdjyfocpewwztffuaibcqurwwmijmvrnpfcoglyxpxkrbhupoxcafabxtoecodsjgngrionuvzaiigevuvruxxiwpjzjlqgenglhprcgzgpdzabrjhkbtfrbmwpcszepxhwiwdhvnpsmhhaiqsbeiwsaeomqtzcpjzfknejxlxwtpkufanhuoyjgihdzhtxnyctazzvnttjspfztjurdwmmzrvobcatkorfhpieoqfetcglembkgbexsznuduhrfoxkbswkanqwfkoktnnujqetijaqhrxuhkgsezfdrncbaltctwcourdbpdwhqlsxfwsoaduaqkbjeekwwykptjthhtokrvzsuelsywyznqscnwiszogzqvfsgggzltlvzkllinpfaigswquqfvabbzvestwxhbnfjhnvfhyxalchmtkcwnyyrbwjsoqooypwteozbivqiyldpqlykxinmzkgnmfbobgjivlzubfen";
        
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(input1));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(input2));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(input3));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(input4));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(input5));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(input6));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(input7));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(input8));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(input9));
    }


    // public String longestPalindrome(String s) {
     
    //     int l = s.length();
    //     boolean[][] table = new boolean [l][l];
    //     int maxLenght = 1, start = l - 1;
    //     for(int i = 0; i <= l - 1; i++){
    //         table[i][i] = true;
    //     }
    //     for(int i = 0; i < l - 1; i++){
    //         if(s.charAt(i) == s.charAt(i + 1)){
    //             table[i][i + 1] = true;
    //             if(maxLenght == 1 ){
    //                 maxLenght = 2;
    //                 start = 1;
    //             }
    //         }
    //     }

    
    //     for(int width = 3; width <= l; width++){
    //         for(int i = 0; i <= l - width; i++){
    //             int j = i + width - 1;
    //             if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
    //                 table[i][j] = true;
    //                 if (width > maxLenght){
    //                     maxLenght = width;
    //                     start = i;
    //                 }
    //             }
    //         }
    //     }

    //     return s.substring(start, start + maxLenght);
    // }

    public String longestPalindrome(String s) {
        if(!(1 <= s.length() && s.length() <= 1000)){
            return null;
        }
        if(s.length() == 1) return s;
        int l = s.length(), i = 0, j = 0, ans = 0, init = 0;
        char[] ch = s.toCharArray(); //APROCH: DINAMIC PROGRAMING WITH WINDOWS SLIDER.
        while(i < l ) {    
            if( this.isPalindromic(ch,Math.min(i, j),j)  //CASO: SE DEBE OBTENER EL MIN ENTRE i Y j PORQUE i PUEDE PASAR A j DEJANDO EXCEPCION                                   
                && (j-Math.min(i, j)) > (ans-init)){     // CAUSANDO PROBLEMA DE SLIDER
                ans = j;
                init = i;
            }                                            
            if(j == s.length()){ //CASO: J LLEGA AL FINAL Y NO ES PALINDROME
                i++;             //VUELVO J AL ULTIMO PALIDROME VALIDO Y MUEVO EL I A LA SIGUIENTE POS   
                j=ans;           //SE APLICA CONCEPTO DE WINDOWS SLIDER
            }else{
                j++;
            }
        }        
        return s.substring(Math.min(init, ans),ans);
    }

    private boolean isPalindromic(char[] ch, int init, int end){
        int i = init, j = end - 1;
        while (j > i) {
            if (ch[i] != ch[j]) return false;                        
            ++i;--j;
        }        
        return true;                 
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> listR = new ArrayList<>();
        int l = nums.length, i = 0, j = 0;
        while (i < l){
            if(j + 1 < l){
                Integer res = nums[i] + nums[j] + nums[j + 1];
                if(res == 0){
                    listR.add(nums[i]);
                    listR.add(nums[j]);
                    listR.add(nums[j + 1]);
                }else{
                    j++;
                }                
            }else{
                j = i;
                i++;
            }


        }
        return list;
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
