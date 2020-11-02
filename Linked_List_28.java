import java.util.Scanner;
class Linked_List_28 {
    Node Head1, Head2,Head3;
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
        Linked_List_28 list = new Linked_List_28();
        list.insertElement();
        list.printList();
        list.mergeList();
        list.printMergedList();
    }
    public void insertElement()
    {
        Scanner obj = new Scanner(System.in);
        boolean choice  = true;
        while(choice)
        {
            int data = obj.nextInt();
            Node temp = new Node(data);
            if(Head1 == null)
            {
                Head1 = temp;
            }
            else
            {
                temp.next = Head1;
                Head1 = temp;
            }
            choice = obj.nextBoolean();
        }
        choice  = true;
        while(choice)
        {
            int data = obj.nextInt();
            Node temp = new Node(data);
            if(Head2 == null)
            {
                Head2 = temp;
            }
            else
            {
                temp.next = Head2;
                Head2 = temp;
            }
            choice = obj.nextBoolean();
        }
    }
    public void printList()
    {
        Node move = Head1;
        System.out.println("List 1: ");
        while(move != null)
        {
            System.out.print(move.data+" ");
            move = move.next;
        }
        move = Head2;
        System.out.println("List 2: ");
        while(move != null)
        {
            System.out.print(move.data+" ");
            move = move.next;
        }
    }
    public void mergeList()
    {
        Node move1 = Head1, move2 = Head2;
        int temp;
        while(move1 != null && move2 != null)
        {
            if(move1.data < move2.data)
            {
                temp =  move1.data;
                move1 = move1.next;
            }
            else if(move1.data > move2.data)
            {
                temp =  move2.data;
                move2 = move2.next;
            }
            else
            {
                temp = move1.data;
                move1 = move1.next;
                move2 = move2.next;
            }
            Node node = new Node(temp);
            if(Head3 != null)
                node.next = Head3;
            Head3 = node;
        }
        if(move1 != null)
        {
            while(move1 != null)
            {
                Node node = new Node(move1.data);
                if(Head3 != null)
                    node.next = Head3;
                Head3 = node;
                move1 = move1.next;
            }
        }
        if(move2 != null)
        {
            while(move2 != null)
            {
                Node node = new Node(move2.data);
                if(Head3 != null)
                    node.next = Head3;
                Head3 = node;
                move2 = move2.next;
            }
        }
    }
    public void printMergedList()
    {
        Node move = Head3;
        System.out.println();
        while(move != null)
        {
            System.out.print(move.data+" ");
            move = move.next;
        }
    }
}