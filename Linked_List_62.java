class Linked_List_62 {
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
        Linked_List_62 list = new Linked_List_62();
        list.insertElement();
        list.printList();
        list.sortList();
        list.printList();
    }
    public void insertElement(){
        Head = new Node(1);
        Head.next = new Node(2);
        Head.next.next= new Node(3);
        //Head.next.next.next = new Node(4);
        //Head.next.next.next.next = new Node(-5);
    }
    public void printList(){
        Node move = Head;
        while(move != null){
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println();
    }
    public void sortList(){
        Node positive = null,positiveEnd = null,negative = null,negativeEnd = null;
        while(Head != null){
            Node temp = Head;
            Head = Head.next;
            temp.next = null;
            if(temp.data >= 0){
                if(positive == null)
                    positive = positiveEnd = temp;
                else{
                    positiveEnd.next = temp;
                    positiveEnd = positiveEnd.next;
                }
            }
            else{
                if(negative == null)
                    negative = negativeEnd = temp;
                else{
                    temp.next = negative;
                    negative = temp;
                }
            }
        }
        if(negative == null) {
            Head = positive;
            return;
        }
        Head = negative;
        negativeEnd.next = positive;
    }
}