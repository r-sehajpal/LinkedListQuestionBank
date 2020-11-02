class Linked_List_48 {
    Node Head,copyList;
    class Node{
        int data;
        Node next,arbt;
        Node(int value){
            data = value;
            next = arbt = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_48 list = new Linked_List_48();
        list.insertElement();
        list.cloneList();
        list.printCloneList();
    }
    public void printCloneList(){
        Node print  = copyList;
        while(print != null){
            System.out.println(print.data + " " + print.arbt.data);
            print = print.next;
        }
    }
    public void insertElement(){
        Head = new Node(1);
        Head.next = new Node(2);
        Head.next.next = new Node(3);
        Head.next.next.next = new Node(4);
        Head.next.next.next.next = new Node(5);
        Head.arbt = Head.next.next;
        Head.next.arbt = Head;
        Head.next.next.arbt = Head.next.next.next.next;
        Head.next.next.next.arbt = Head.next.next;
        Head.next.next.next.next.arbt = Head.next;
    }
    public void cloneList(){

        //Insert Elements in list
        Node insert = Head;
        while(insert != null){
            Node temp = new Node(insert.data);
            temp.next = insert.next;
            insert.next = temp;
            insert = temp.next;
        }

        //Adjusting arbitrary pointers

        Node move = Head;
        while(move != null){
            move.next.arbt = move.arbt;
            move = move.next.next;
        }

        //cloning linked list by removing copied nodes from original list

        copyList = Head.next;
        move = Head.next;
        while(move.next != null){
            move.next = move.next.next;
            move = move.next;
        }
    }
}