import java.util.*;
class Linked_List_40 {
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
        Linked_List_40 list = new Linked_List_40();
        list.insertElement();
        list.printList();
        list.rotateList();
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
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println("NULL");
    }
    public void rotateList()
    {
        Scanner obj = new Scanner(System.in);
        int toBeRotated = obj.nextInt();
        Node lastNode = Head;
        while(lastNode.next != null)
        {
            lastNode = lastNode.next;
        }
        while(toBeRotated != 0)
        {
            Node temp = Head;
            Head = Head.next;
            temp.next = null;
            lastNode.next = temp;
            lastNode = lastNode.next;
            toBeRotated--;
        }
    }
}