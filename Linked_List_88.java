import java.util.Scanner;

class Linked_List_88 {
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
        Linked_List_88 list = new Linked_List_88();
        //list.createList();
        //list.isMiddleNodeDeleted();
        //list.printList();
        list.inputElement();
    }
    public void inputElement(){
        int a,b,c;
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        input.nextLine();
        b = input.nextInt();
        input.nextLine();
        c = input.nextInt();
        System.out.println(a + " " + b + " " + c);
    }
    public void printList(){
        Node move = Head;
        while(move != null){
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println("null");
    }
    public void createList(){
        Head = new Node(1);
        Head.next = new Node(2);
        Head.next.next = new Node(3);
        Head.next.next.next = new Node(4);
        Head.next.next.next.next = new Node(5);
    }
    public void isMiddleNodeDeleted(){
        Head = deleteMiddleNode();
    }
    public Node deleteMiddleNode(){
        Node previous = null, slow = Head, fast = Head;
        if(Head == null || Head.next == null)
            return null;
        while(fast.next != null && fast.next.next != null){
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next != null){           //for even number of nodes
            previous = slow.next;
            slow.next = previous.next;
            previous.next = null;
        }
        else{
            previous.next = slow.next;
            slow.next = null;
        }
        return Head;
    }
}