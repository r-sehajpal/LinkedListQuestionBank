import java.util.Scanner;

class Linked_List_37 {
    Node Number1,Number2,Number3;
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
        Linked_List_37 list = new Linked_List_37();
        list.insertElement();
        list.printList();
        list.sumOfElements();
        list.printSum();
    }
    public void insertElement()
    {
        Scanner obj = new Scanner(System.in);
        boolean choice = true;
        while(choice)
        {
            int value = obj.nextInt();
            Node temp = new Node(value);
            if(Number1 != null)
            {
                temp.next = Number1;
            }
            Number1 = temp;
            choice = obj.nextBoolean();
        }
        choice = true;
        while(choice)
        {
            int value = obj.nextInt();
            Node temp = new Node(value);
            if(Number2 != null)
            {
                temp.next = Number2;
            }
            Number2 = temp;
            choice = obj.nextBoolean();
        }
    }
    public void printList()
    {
        Node move = Number1;
        while(move != null)
        {
            System.out.print(move.data+ "->");
            move = move.next;
        }
        System.out.print("NULL");
        move = Number2;
        while(move != null)
        {
            System.out.print(move.data+ "->");
            move = move.next;
        }
        System.out.print("NULL");
    }
    public void sumOfElements()
    {
        int carry=0,remainder,digit1,digit2;
        Node move1 = Number1, move2 = Number2,move3=null;
        while(move1 != null || move2 != null)
        {
            digit1 = move1 == null ? 0 : move1.data;
            digit2 = move2 == null ? 0 : move2.data;
            remainder = (digit1 + digit2 + carry)%10;
            carry = (digit1 + digit2 + carry)/10;
            Node temp = new Node(remainder);
            if(move3 == null)
            {
                Number3 = move3 = temp;
            }
            else
            {
                move3.next = temp;
                move3 = temp;
            }
            move1 = move1.next;
            move2 = move2.next;
        }
    }
    public void printSum()
    {
        Node move = Number3;
        while(move != null)
        {
            System.out.print(move.data+"->");
            move = move.next;
        }
        System.out.print("NULL");
    }
}