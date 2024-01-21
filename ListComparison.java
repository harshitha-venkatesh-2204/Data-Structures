import java.util.ArrayList;
import java.util.LinkedList;

public class ListComparison{
    public static void main(String[] args){
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        LinkedList<Integer> linkList = new LinkedList<Integer>();
        //add arrayList
        long nanoStartTimeToAddArrayList=System.nanoTime();
        for (int i = 0; i <1000000; i++) {
           arrList.add(i);
        }
        long nanoEndTimeToAddArrayList=System.nanoTime();
        double timeTakenToAddArrayList = (nanoEndTimeToAddArrayList - nanoStartTimeToAddArrayList)/1e9;
        System.out.println("Time taken to add Array List: " +timeTakenToAddArrayList + " secs");

        //add linkedList
        long nanoStartTimeToAddLinkedList=System.nanoTime();
        for (int i = 0; i <1000000; i++) {
           linkList.add(i);
        }
        long nanoEndTimeToAddLinkedList=System.nanoTime();
        double timeTakenToAddLinkedList = (nanoEndTimeToAddLinkedList - nanoStartTimeToAddLinkedList)/1e9;
        System.out.println("Time taken to add Linked List: " +timeTakenToAddLinkedList + " secs");

        //get arrayList
        long nanoStartTimeToGetArrayList=System.nanoTime();
        for (int i = 0; i <1000000; i++) {
           arrList.get(i);
        }
        long nanoEndTimeoGetArrayList=System.nanoTime();
        double timeTakenToGetArrayList = (nanoEndTimeoGetArrayList - nanoStartTimeToGetArrayList)/1e9;
        System.out.println("Time taken to get Array List: " +timeTakenToGetArrayList + " secs");


         //get linkedList
        long nanoStartTimeToGetLinkedList=System.nanoTime();
        for (int i = 0; i <linkList.size(); i++) {
           linkList.get(i);
        }
        long nanoEndTimeToGetLinkedList=System.nanoTime();
        double timeTakenToGetLinkedList= (nanoEndTimeToGetLinkedList- nanoStartTimeToGetLinkedList)/1e9;
        System.out.println("Time taken to get Linked List: " +timeTakenToGetLinkedList + " secs");
        

         //remove arrayList
        long nanoStartTimeToRemoveArrayList=System.nanoTime();
        for (int i = arrList.size()-1; i>=0; i--) {
           arrList.remove(i);
        }
        long nanoEndTimeToRemoveArrayList=System.nanoTime();
        double timeTakenToRemoveArrayList = (nanoEndTimeToRemoveArrayList - nanoStartTimeToRemoveArrayList)/1e9;
        System.out.println("Time taken to remove Array List: " +timeTakenToRemoveArrayList + " secs");

        //remove LinkedList
        long nanoStartTimeToRemoveLinkedList=System.nanoTime();
        for (int i = linkList.size()-1 ; i>=0; i--) {
           linkList.remove(i);
        }
        long nanoEndTimeToRemoveLinkedList=System.nanoTime();
        double timeTakenToRemoveLinkedList = (nanoEndTimeToRemoveLinkedList - nanoStartTimeToRemoveLinkedList)/1e9;
        System.out.println("Time taken to remove Linked List: " +timeTakenToRemoveLinkedList + " secs");




    }
}
