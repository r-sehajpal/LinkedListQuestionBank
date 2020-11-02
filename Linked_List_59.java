class Linked_List_59 {
    Node Head;
    class Node{
        int data;
        Node next,arb;
        Node(int value){
            data = value;
            next = arb = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_59 list = new Linked_List_59();
        list.insertElement();
        list.printList();
        list.pointArbToMaxNode();
        list.printList();
    }
    public void insertElement(){
        Head = new Node(5);
        Head.next = new Node(10);
        Head.next.next = new Node(2);
        Head.next.next.next = new Node(3);
    }
    public void printList(){
        Node move = Head;
        while(move != null){
            System.out.print(move.data + " - ");
            if(move.arb != null)
                System.out.print(move.arb.data);
            System.out.println();
            move = move.next;
        }
    }
    public void pointArbToMaxNode(){
        Node prev = null,curr = Head,forw;
        //Reverse the list
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        Head = prev;
        Node move = Head.next,maxNde = Head;
        while(move != null) {
            move.arb = maxNde;
            if (move.data > maxNde.data)
                maxNde = move;
            move = move.next;
        }

        //Reverse the list
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