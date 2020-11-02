class Linked_List_77 {
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
        Linked_List_77 list = new Linked_List_77();
        list.createList();
        list.moveKeyElement(6);
        list.printList();
    }
    public void printList(){
        Node move = Head;
        while(move != null){
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println("null");
    }
    public void createList(){
        Head = new Node(6);
        Head.next = new Node(6);
        Head.next.next = new Node(7);
        Head.next.next.next = new Node(6);
        Head.next.next.next.next = new Node(3);
        Head.next.next.next.next.next = new Node(10);
    }
    public void moveKeyElement(int key){
        Node prev = null,curr = Head,last = Head,lastMove;
        while(last.next != null){
            last = last.next;
        }
        lastMove = last;
        while(prev != last){
            if(curr.data == key){
                if(prev == null){
                    Head = Head.next;
                    curr.next = null;
                    lastMove.next = curr;
                    lastMove = lastMove.next;
                    curr = Head;
                }
                else{
                    prev.next = curr.next;
                    curr.next = null;
                    lastMove.next = curr;
                    lastMove = lastMove.next;
                    curr = prev.next;
                }
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
    }
}