class Linked_List_57 {
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
        Linked_List_57 list = new Linked_List_57();
        list.insertNode();
        list.printList();
        list.arrangeZigZag();
    }
    public void insertNode(){
        Head = new Node(1);
        Head.next = new Node(2);
        Head.next.next = new Node(3);
        Head.next.next.next = new Node(4);
        Head.next.next.next.next = new Node(5);
    }
    public void printList(){
        Node move = Head;
        while(move != null) {
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println();
    }
    public void arrangeZigZag() {
        Node move = Head;
        int temp;
        boolean check = true;
        while(move != null){
            if(check) {
                if (move.data > move.next.data) {
                    temp = move.data;
                    move.data = move.next.data;
                    move.next.data = temp;
                }
            }
            else{
                    if(move.data < move.next.data){
                        temp = move.data;
                        move.data = move.next.data;
                        move.next.data = temp;
                }
            }
            move = move.next;
        }
    }
}