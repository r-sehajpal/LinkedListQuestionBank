class Linked_List_58 {
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
        Linked_List_58 list = new Linked_List_58();
        list.insertElement();
        list.printList();
        list.addOneToList();
        list.printList();
    }
    public void insertElement(){
        Head = new Node(1);
        Head.next = new Node(9);
        Head.next.next = new Node(9);
        Head.next.next.next = new Node(9);
    }
    public void printList(){
        Node move = Head;
        while(move!=null){
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println();
    }
    public void addOneToList(){
        //Reverse the list
        Node prev = null,curr = Head,forw;
        while(curr != null)
        {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        Head = prev;

        //Add one

        Node move = Head;
        int carry = 0,tempv;
        carry = (move.data + 1) / 10;
        move.data = (move.data + 1) % 10;
        while(move.next != null){
            move = move.next;
            tempv = (move.data + carry) % 10;
            carry = (move.data+carry) / 10;
            move.data = tempv;
        }
        if(carry != 0){
            Node temp = new Node(carry);
            move.next = temp;
        }

        //reverse List
        curr = Head;
        prev = null;
        while(curr != null){
             forw = curr.next;
             curr.next = prev;
             prev = curr;
             curr = forw;
        }
        Head = prev;
    }
}