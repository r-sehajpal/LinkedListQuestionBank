import java.util.Scanner;
class Linked_List_32 {
    Node Head,Odd,Even;
    class Node{
        int data;
        Node next;
        Node(int value)
        {
            data = value;
            next = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_32 list = new Linked_List_32();
        list.createList();
        list.printList();
        list.alternateOddEven();
        list.printList();
    }
    public void createList()
    {
        Scanner obj = new Scanner(System.in);
        boolean choice = true;
        while(choice)
        {
            int data = obj.nextInt();
            Node temp = new Node(data);
            if(Head!=null)
                temp.next = Head;
            Head = temp;
            choice = obj.nextBoolean();
        }
    }
    public void printList()
    {
        Node move = Head;
        while(move != null)
        {
            System.out.print(move.data + " ");
            move = move.next;
        }
        System.out.println();
    }
    public void alternateOddEven()
    {
        Node current = head, prev;
        while(current != null)
        {
            if(current.data % 2 != 0)
            {
                if(current != head)
                {
                    prev.next = current.next;
                    current.next = Head;
                    Head = current;
                    current = prev.next;
                }
                else
                {
                    prev = current;
                    current = current.next;
                }
            }
            else
            {
                prev = current;
                current = current.next;
            }
        }
        Node move2,move1 = Head;
        while(move1.data %2 != 0)
        {
            move2 = move1;
            move1 = move1.next;
        }
        Node Odd = Head,Even = move1;
        move2.next = null;
        while(Odd != null && Even != null)
        {
            Node temp = Even;
            Even = Even.next;
            temp.next = Odd.next;
            Odd = temp.next;
        }
        if(Even != null)
        {
            move2.next = Even;
        }
    }
}