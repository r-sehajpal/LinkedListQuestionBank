class Linked_List_79 {
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
        Linked_List_79 list = new Linked_List_79();
        list.createList();
        list.removeKthNode(1);
        list.printList();
    }
    public void createList(){
        Head = new Node(1);
        Head.next = new Node(2);
        Head.next.next = new Node(3);
        Head.next.next.next = new Node(4);
        Head.next.next.next.next = new Node(5);
        Head.next.next.next.next.next = new Node(6);
        Head.next.next.next.next.next.next = new Node(7);
        Head.next.next.next.next.next.next.next = new Node(8);
    }
    public void removeKthNode(int key){
        int temp = key;
        Node tempList = null, last = null, move = Head;
        while(Head != null){
            Head = Head.next;
            move.next = null;
            temp--;
            if(temp == 0)
                temp = key;
            else{
                if(tempList == null)
                    tempList = last = move;
                else{
                    last.next = move;
                    last = last.next;
                }
            }
            move = Head;
        }
        Head = tempList;
    }
    public void printList(){
        Node move = Head;
        while(move != null){
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println("null");
    }
}