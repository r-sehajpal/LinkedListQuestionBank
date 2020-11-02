class Linked_List_83 {
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
        Linked_List_83 list = new Linked_List_83();
        list.createList();
        list.mergeSort();
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
        Head.next = new Node(1);
        Head.next.next = new Node(2);
        Head.next.next.next = new Node(5);
        Head.next.next.next.next = new Node(3);
        Head.next.next.next.next.next = new Node(4);
    }
    public void mergeSort(){
        Node sortedList = mergeSortList(Head);
        Head = sortedList;
    }
    public Node mergeSortList(Node h){
        if(h == null || h.next == null)
            return h;
        Node middle = findMiddle(h);
        Node nextToMiddle = middle.next;
        middle.next = null;

        Node left = mergeSortList(h);
        Node right = mergeSortList(nextToMiddle);

        Node sortedList = mergeSortedList(left,right);
        return sortedList;
    }
    public Node findMiddle(Node move){
        Node slow = move, fast = move;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node mergeSortedList(Node a, Node b){
        Node sortedList = null,last = null,temp = null;
        while(a != null && b != null){
            if(a.data < b.data) {
                temp = a;
                a = a.next;
                temp.next = null;
            }
            else if(b.data <= a.data){
                temp = b;
                b = b.next;
                temp.next = null;
            }
            if(sortedList == null)
                sortedList = last = temp;
            else{
                last.next = temp;
                last = last.next;
            }
        }
        if(a != null)
            last.next = a;
        if(b != null)
            last.next = b;
        last = last.next;
        last.next = null;
        return sortedList;
    }
}