import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static void main(String[] args) throws Exception {
        String s = "AB";
        int numRows = 1;

        System.out.println(new ZigZagConversion().convert(s, numRows));
    }

    public String convert(String s, int numRows) {

        if(s.length()==1) return s;
        if(numRows==1) return String.valueOf(s.charAt(0));

        List<StringBuilder> zz = new ArrayList<>();
        int indxChr = 0;
        boolean down=true;
        for (int i=0; i<Math.min(s.length(),numRows); i++){          
            zz.add(new StringBuilder());
        }
        
        for (int i = 0; i<s.length();i++){

            System.out.print(indxChr);
            System.out.println(s.charAt(i));    
            
            zz.get(indxChr).append(s.charAt(i));           
           
            if(down){
                             
                if(indxChr==numRows-1){
                    down=!down;
                    indxChr = numRows-1;
                }else{
                    indxChr++;
                }
            }

            if(!down){
               // zz.get(indxChr).append(s.charAt(i));   
                if(indxChr>0){
                    indxChr--;                 
                }else{
                    down=!down; 
                    indxChr=1; 
                }
                
            }

        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : zz) {
            System.out.println(row.toString());
            ret.append(row);
        };
        return ret.toString();
    }
}
