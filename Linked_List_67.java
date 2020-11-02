class Linked_List_67 {
    Node Head,FlattenList = null,FlattenListLast = null;
    class Node{
        int data;
        Node next,down;
        Node(int value){
            data = value;
            next = down = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_67 list = new Linked_List_67();
        list.insertElement();
        list.callFlattenList();
        list.printList();
    }
    public void insertElement(){
        Head = new Node(1);
        Head.next = new Node(2);
        Head.next.next = new Node(3);
        Head.next.next.next = new Node(4);
        Head.next.down = new Node(7);
        Head.next.down.next = new Node(8);
        Head.next.down.next.next = new Node(10);
        Head.next.down.next.next.next = new Node(12);
        Head.next.down.next.down = new Node(16);
        Head.next.down.next.next.down = new Node(11);
        Head.next.down.next.down.down = new Node(17);
        Head.next.down.next.down.down.next = new Node(18);
        Head.next.down.next.down.down.next.next = new Node(19);
        Head.next.down.next.down.down.next.next.next = new Node(20);
        Head.next.down.next.down.down.next.next.next.next = new Node(21);
        Head.next.down.down = new Node(9);
        Head.next.down.down.down = new Node(14);
        Head.next.down.down.down.down = new Node(15);
        Head.next.down.down.down.down.next = new Node(23);
        Head.next.down.down.down.down.next.down = new Node(24);
    }
    public void callFlattenList(){
        flattenList(Head);
    }
    public void flattenList(Node move){
        if(move == null)
            return;
        while(move != null){
            Node temp = new Node(move.data);
            if(FlattenList == null)
                FlattenList = FlattenListLast = temp;
            else{
                FlattenListLast.next = temp;
                FlattenListLast = FlattenListLast.next;
            }
            if(move.down != null)
                flattenList(move.down);
            move = move.next;
        }
    }
    public void printList(){
        Node move = FlattenList;
        while(move != null){
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println("/");
    }
}