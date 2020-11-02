import java.util.*;
class Linked_List_68 {
    public static void alternateSort(LinkedList<Integer> ll){
        Collections.sort(ll);
        for(int i = 0; i<ll.size(); i=i+2){
            Integer x = ll.getLast();
            ll.removeLast();
            ll.add(i+1,x);
        }
        System.out.println(ll);
    }
    public static void main(String[] args) {
        Integer arr[] = {1, 3, 8, 2, 7, 5, 6, 4};
        LinkedList<Integer> ll = new LinkedList<Integer>(Arrays.asList(arr));
        alternateSort(ll);
    }
}