import java.util.Scanner;
class Linked_List_33 {
    Node Head;
    class Node
    {
        int data;
        Node next;
        Node(int value)
        {
            data = value;
            next = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_33 list = new Linked_List_33();
        list.insertElement();
        list.printList();
        list.deleteAlternate();
        list.printList();
    }
    public void insertElement()
    {
        Scanner obj = new Scanner(System.in);
        boolean choice = true;
        while(choice) {
            int data = obj.nextInt();
            Node temp = new Node(data);
            if (Head != null)
                temp.next = Head;
            Head = temp;
            choice = obj.nextBoolean();
        }
    }
    public void printList()
    {
        Node move = Head;
        while(move !=  null)
        {
            System.out.print(move.data + " ->");
            move = move.next;
        }
    }
    public void deleteAlternate()
    {
        Node move = Head, curr = Head.next;
        while(move != null && curr != null)
        {
            move.next = curr.next;
            move = move.next;
            curr = null;
            if(move != null)
                curr = move.next;
        }
    }
}