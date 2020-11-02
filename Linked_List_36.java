import java.util.*;
class Linked_List_36 {
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
    public static void main(String[] args){
        Linked_List_36 list = new Linked_List_36();
        list.insertElement();
        list.printList();
        list.deleteRightElement();
        list.printList();
    }
    public void insertElement()
    {
        Scanner obj = new Scanner(System.in);
        boolean choice = true;
        while(choice)
        {
            int value = obj.nextInt();
            Node temp = new Node(value);
            if(Head != null)
            {
                temp.next = Head;
            }
            Head = temp;
            choice = obj.nextBoolean();
        }
    }
    public void printList()
    {
        Node move = Head;
        while(move != null)
        {
            System.out.print(move.data+ " ");
            move = move.next;
        }
        System.out.println();
    }
    public void deleteRightElement()
    {
        Node previous=null,current = Head,forward = Head.next;
        while(current.next != null)
        {
            if(forward.data > current.data)
            {
                if(current == Head)
                {
                    Head = Head.next;
                    current.next = null;
                    current = Head;
                    forward = forward.next;
                }
                else
                {
                    previous.next = forward;
                    current.next = null;
                    current = forward;
                    forward = forward.next;
                }
            }
            else {
                previous = current;
                current = forward;
                forward = forward.next;
            }
        }
    }
}