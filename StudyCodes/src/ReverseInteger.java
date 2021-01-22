public class ReverseInteger {

    public static void main(String [] args) {
        
       // new ReverseInteger().reverse(9646324351);

    }
    
    public int reverse(int numero) {
        int inverseInt =numero;
        String invNum = "";
        numero = Math.abs(numero);
        if(-Math.pow(2, 31) >= numero && numero <=Math.pow(2, 31)){
            return 0;
        }
        while(numero>0){
            //if(numero%10!=0){
                int res = numero%10;
                System.out.println(res);
                invNum += res != 0 ? res : "0";
                System.out.println(invNum);
            //}
            numero=numero/10;
           
        }

        return "".equalsIgnoreCase(invNum) ? 0 : 
        inverseInt >=0 ? Integer.valueOf(invNum) : Integer.valueOf(invNum)*(-1) ;
    }


}
