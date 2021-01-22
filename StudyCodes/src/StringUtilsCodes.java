public class StringUtilsCodes {

    public static void main(String [] args) {
        String input1 = "abcabcbb";
        String input2 = "bbbbb";
        String input3 = "pwwkew";
        
        String aux = "";
        
        for (int i = 0; i < input1.length(); i++) {
            System.out.println(input1.substring(i,i+1));

            if( input1.substring(i,i+1) != null){
                
                if(!aux.contains(input1.substring(i,i+1))){
                    aux += input1.substring(i,i+1);
                }else{
                    
                }

            }

        }
        
    }
}