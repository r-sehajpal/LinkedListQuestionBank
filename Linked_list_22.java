import java.util.Scanner;
class Linked_List_22
{
    Node head1,head2;
    static class Node
    {
        int data;
        Node next;
        Node(int value)
        {
            data = value;
            next = null;
        }
    }
    public static void main(String args[])
    {
        Linked_List_22 list = new Linked_List_22();
        list.head1=new Node(1);
        list.head1.next = new Node(2);
        list.head1.next.next = new Node(3);
        list.head2 = new Node(4);
        list.head2.next = new Node(5);
        Node temp = new Node(6);
        list.head1.next.next.next = temp;
        list.head2.next.next = temp;
        temp.next = new Node(7);
        temp.next.next = new Node(8);
        Node intersectionPoint = list.findIntersection();
        System.out.println("Intersection Point: "+intersectionPoint.data);
    }
    public Node findIntersection()
    {
        Node move1,move2;
        move1 = head1;
        move2 = head2;
        int countNodes = 0;
        while(move1 != null && move2 != null)
        {
            countNodes++;
            move1 = move1.next;
            move2 = move2.next;
        }
        if(move1 != null)
            return move1;
        else
            return move2;
    }
}