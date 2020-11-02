import java.util.*;
class Linked_List_72 {
    Node Head;
    class Node{
        int data;
        Node next;
        Node(int value){
            data = value;
            next = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_72 list = new Linked_List_72();
        list.insertElement();
        list.isPallindrome();
    }
    public void insertElement(){
        Head = new Node(1);
        Head.next = new Node(2);
        Head.next.next = new Node(3);
        Head.next.next.next = new Node(4);
        Head.next.next.next.next = new Node(3);
        Head.next.next.next.next.next = new Node(2);
        Head.next.next.next.next.next.next = new Node(1);
        Head.next.next.next.next.next.next.next = Head.next;
    }
    public void isPallindrome(){
        //Detect and remove Loop
        detectAndRemoveLoop();
    }
    public void detectAndRemoveLoop(){
        Node slowptr = Head,fastptr = Head,endNode = null;
        while(slowptr != null && fastptr != null && fastptr.next != null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if(slowptr == fastptr){
                endNode = removeLoop(slowptr);
                break;
            }
        }

        Stack<Integer> s1 = new Stack<Integer>();
        Node move = Head;
        while(move != endNode){
            s1.push(move.data);
            move = move.next;
        }
        move = Head;
        while(move != null){
            int temp = s1.pop();
            if(temp != move.data){
                System.out.println("Not Palindrome");
                return;
            }
            move = move.next;
        }
        System.out.println("Palindrome");
    }
    public Node removeLoop(Node loop){
        Node ptr1 = null,ptr2 = null;

        //get number of nodes in loop
        ptr1 = loop;
        int k = 1;
        while(ptr1.next != loop){
            k++;
            ptr1 = ptr1.next;
        }

        //set ptr2 at exactly k nodes after Head node
        ptr2 = Head;
        for(int i = 0; i<k; i++){
            ptr2 = ptr2.next;
        }

        //move ptr1 and ptr2 and mark where they meet is loop end node
        ptr1 = Head;
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}