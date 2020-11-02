import java.util.Scanner;
class Linked_List_26 {
    Node Head;

    class Node {
        int data;
        Node next;

        Node(int value) {
            data = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        Linked_List_26 list = new Linked_List_26();
        list.insertElement();
        list.printList();
        list.printReverse();
    }

    public void insertElement() {
        Scanner obj = new Scanner(System.in);
        boolean choice = true;
        while (choice) {
            int data = obj.nextInt();
            Node temp = new Node(data);
            if (Head == null)
                Head = temp;
            else {
                temp.next = Head;
                Head = temp;
            }
            choice = obj.nextBoolean();
        }
    }

    public void printList() {
        Node move = Head;
        while (move != null) {
            System.out.print(move.data + " ");
            move = move.next;
        }
        System.out.println();
    }

    public void printReverse()
    {
        printReverseList(Head);
    }
    public void printReverseList(Node move)
    {
        if(move.next != null)
            printReverseList(move.next);
        System.out.print(move.data+" ");
    }
}