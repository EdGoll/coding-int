import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Practice {

    public static void main(String [] args ) {

        Integer [] arr1 = new Integer [] {9,9,9,9,9,9,9};
        Integer [] arr2 = new Integer [] {9,9,9,9};  
        Practice p = new Practice();
        ListNode head = p.createList(arr1);
        ListNode head2 = p.createList(arr2);
        System.out.println(p.getLenghtList(head));
        System.out.println(p.getLenghtList(head2));
        ListNode l = p.sumListNodes(head,head2);
        p.getLenghtList(l);
    }

    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     ListNode dummyHead = new ListNode(0);
    //     ListNode p = l1, q = l2, curr = dummyHead;
    //     int carry = 0;
    //     while (p != null || q != null) {
    //         int x = (p != null) ? p.val : 0;
    //         int y = (q != null) ? q.val : 0;
    //         int sum = carry + x + y;
    //         carry = sum / 10;
    //         curr.next = new ListNode(sum % 10);
    //         curr = curr.next;
    //         if (p != null) p = p.next;
    //         if (q != null) q = q.next;
    //     }
    //     if (carry > 0) {
    //         curr.next = new ListNode(carry);
    //     }
    //     return dummyHead.next;
    // }    

    public ListNode createList(Integer [] arr){
        ListNode node = null;
        ListNode head = node;        
        ListNode end = head;
        for (Integer integer : arr) {            
            node = new ListNode();
            node.val = integer;
            if(end != null){
                end.next=node;
                end = end.next;
            }else{
                head = node;     
                end = head;
            }
        }
        return head;
    }

    public ListNode addElement(ListNode head, Integer val){
        ListNode node = new ListNode();
        node.val=val;
        ListNode end = head;
        if(head==null){
            head = new  ListNode ();
            head.val = val;
            return head;
        }
            while(end.next != null){
                end = end.next;
            }            
            end.next=node;
            end = end.next;
       
        return head;
    }

    public ListNode sumListNodes(ListNode l1 , ListNode l2){

        Integer l1Lenght = this.getLenghtList(l1);
        Integer l2Lenght = this.getLenghtList(l2);
        int num=0;
        int lenghtArr = l1Lenght < l2Lenght ?  l1Lenght : l2Lenght;        
        ListNode listIterate = l1Lenght < l2Lenght ?  l1 : l2;

        int [] arr3 = new int [ l1Lenght > l2Lenght ?  l1Lenght : l2Lenght];

        ListNode l3= null;
        int decena =0;        
        int unidad =0;      

        ListNode indx1 = l1;
        ListNode indx2 = l2;
        //for (int i=0 ; i< lenghtArr ; i++ ){
        while(listIterate != null) {
            num = indx1.val + indx2.val + decena ;
            decena = 0;

            if(num>9){            
                unidad = num%10; 

                num = num/10;
                decena = num%10; 

                num = unidad;
            }    
            l3 = this.addElement(l3,num);
            indx1 = indx1.next;
            indx2 = indx2.next;
            listIterate = listIterate.next;
        }

        ListNode restArr = indx1 != null ?  indx1 : indx2;        
        //for (int i=lenghtArr ; i< restArr ; i++ ) {
        while(restArr!=null){
            num = restArr.val + decena ;
            decena = 0;

            if(num>9){            
                unidad = num%10; 

                num = num/10;
                decena = num%10; 
               
                num = unidad;
            }    
            l3 = this.addElement(l3,num);
            restArr = restArr.next;
        }

        if(decena >0){
            l3 = this.addElement(l3,decena);
        }

        for (int i : arr3) {
            System.out.println(i);
        }

        return l3;
    } 

    public Integer getLenghtList(ListNode l){
        Integer cont=0;
        while(l!=null){
            System.out.print(l.val);
            l=l.next;
            cont++;
        }
        return cont;
    }

    public int [] sumArrays(){
        // int [] arr1 = new int [] {3,4,2};
        // int [] arr2 = new int [] {4,6,5};
        int [] arr1 = new int [] {9,9,9,9,9,9,9};
        int [] arr2 = new int [] {9,9,9,9};   
        
        int num=0;
        int lenghtArr = arr1.length < arr2.length ?  arr1.length : arr2.length;
        int [] arr3 = new int [ arr1.length > arr2.length ?  arr1.length +1 : arr2.length +1];
        int decena =0;        
        int unidad =0;      
        for (int i=0 ; i< lenghtArr ; i++ ) {
            num = arr1[i] + arr2[i] + decena ;
            decena = 0;
            System.out.println("suma "+num);
            if(num>9){            
                unidad = num%10; 
                System.out.println("unidad "+unidad);
                num = num/10;
                decena = num%10; 
                System.out.println("decena "+decena);
                num = unidad;
            }    
            arr3[i] = num;
        }
        int [] restArr = arr1.length > arr2.length ? arr1 : arr2;
        
        for (int i=lenghtArr ; i< restArr.length ; i++ ) {
            num = restArr[i] + decena ;
            decena = 0;
            System.out.println("suma "+num);
            if(num>9){            
                unidad = num%10; 
                System.out.println("unidad "+unidad);
                num = num/10;
                decena = num%10; 
                System.out.println("decena "+decena);
                num = unidad;
            }    
            arr3[i] = num;
        }
if(decena >0){
    arr3[arr3.length-1] = decena;
}

        for (int i : arr3) {
            System.out.println(i);
        }

        return arr3;
    }



 

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Integer[] lArr1 = this.getValueFromList(l1);
        Integer[] lArr2 = this.getValueFromList(l2);



        Integer addLs  =  this.getSumArrays(lArr1) + this.getSumArrays(lArr2);
        System.out.println(addLs);
        ListNode newList = this.getNewList(addLs);

        while(newList!=null){
            // System.out.println(newList.val);
            newList=newList.next;
        }
        return newList;
    }
    
    private Integer[] getValueFromList(ListNode l){
        List<Integer> listInts = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        while (l!=null){       
            
            stack.push(l.val);
            l=l.next;
        }

        while(!stack.empty()){           
            Integer num =  stack.pop();
            
            listInts.add(num);
        }

 

        return listInts != null ? (listInts.toArray(new Integer[listInts.size()])) : null;
    }     

    private Integer getSumArrays(Integer[] arr){

        String sum="";
        for (Integer number : arr) {
            
            sum += number;
        }
        System.out.println(sum);    
        return Integer.parseInt(sum);
    }

    private ListNode getNewList(Integer value){
        ListNode node = null;
        ListNode head = node;        
        ListNode end = head;

        Stack<String> stack = new Stack<String>();
        String strValue = value.toString();
        for (int i=0; i< strValue.length() ; i++) {
            stack.push(String.valueOf(strValue.charAt(i)));            
        }



        while(!stack.empty()){
            node = new ListNode();
            node.val = Integer.valueOf(stack.pop());
            if(end != null){
                end.next=node;
                end = end.next;
            }else{
                head = node;     
                end = head;
            }
        }

        return head;
    }


   

}

class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
    
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }