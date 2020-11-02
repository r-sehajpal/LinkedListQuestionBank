class Linked_List_71 {
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
        Linked_List_71 list = new Linked_List_71();
        list.insertElement();
        list.printList();
        list.partitionList(3);
        list.printList();
    }
    public void insertElement(){
        Head = new Node(1);
        Head.next = new Node(4);
        Head.next.next = new Node(3);
        Head.next.next.next = new Node(2);
        Head.next.next.next.next = new Node(5);
        Head.next.next.next.next.next = new Node(2);
        Head.next.next.next.next.next.next = new Node(3);
    }
    public void printList(){
        Node move = Head;
        while(move != null){
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println("null");
    }
    public void partitionList(int key){
        Node greaterHead,greaterTail,equalHead,equalTail,smallerHead,smallerTail;
        greaterHead =greaterTail = equalHead = equalTail = smallerHead = smallerTail = null;
        while(Head != null){
            Node temp = Head;
            Head = Head.next;
            temp.next = null;
            if(temp.data > key){
                if(greaterHead == null)
                    greaterHead = greaterTail = temp;
                else{
                    greaterTail.next = temp;
                    greaterTail = greaterTail.next;
                }
            }
            if(temp.data == key){
                if(equalHead == null)
                    equalHead = equalTail = temp;
                else{
                    equalTail.next = temp;
                    equalTail = equalTail.next;
                }
            }
            if(temp.data < key) {
                if (smallerHead == null)
                    smallerHead = smallerTail = temp;
                else {
                    smallerTail.next = temp;
                    smallerTail = smallerTail.next;
                }
            }
        }

        //Merging of Lists
        if(smallerHead == null){
            if(equalHead == null){
                Head = greaterHead;
                return;
            }
            equalTail.next = greaterHead;
            Head = equalHead;
            return;
        }
        if(equalHead == null){
            smallerTail.next = greaterHead;
            Head = smallerHead;
            return;
        }

        smallerTail.next = equalHead;
        equalTail.next = greaterHead;
        Head = smallerHead;
    }
}