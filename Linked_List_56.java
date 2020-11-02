class Linked_List_56 {
    Node Head;
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
        Linked_List_56 list = new Linked_List_56();
        list.insertElement();
        list.printList();
        list.rearrangeList();
        list.printList();
    }
    public void insertElement()
    {
        Head = new Node(1);
        Head.next = new Node(2);
        Head.next.next = new Node(3);
        Head.next.next.next = new Node(4);
        Head.next.next.next.next = new Node(5);
        Head.next.next.next.next.next = new Node(6);
    }
    public void printList()
    {
        Node move = Head;
        while(move != null)
        {
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println();
    }
    public void rearrangeList()
    {
        Node even,odd,evenLast,oddLast;
        even = odd = oddLast = evenLast = null;
        boolean check = true;
        if(Head == null || Head.next == null || Head.next.next == null)
            return;
        else {
            while (Head != null) {
                Node temp = Head;
                Head = Head.next;
                temp.next = null;
                if (check) {
                    if (odd == null) {
                        odd = oddLast = temp;
                    } else {
                        oddLast.next = temp;
                        oddLast = oddLast.next;
                    }
                    check = false;
                } else {
                    if (even == null) {
                        even = evenLast = temp;
                    } else {
                        evenLast.next = temp;
                        evenLast = evenLast.next;
                    }
                    check = true;
                }
            }
            oddLast.next = even;
            Head = odd;
        }
    }
}