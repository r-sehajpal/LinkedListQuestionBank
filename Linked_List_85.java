class Linked_List_85 {
    Node List1, List2, result;
    class Node{
        int data;
        Node next;
        Node(int value){
            data = value;
            next = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_85 list = new Linked_List_85();
        list.createLists();
        list.mergeLists();
        list.printList();
    }
    public void printList(){
        Node move = result;
        while(move != null){
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println("null");
    }
    public void createLists(){
        List1 = new Node(2);
        List1.next = new Node(4);
        List1.next.next = new Node(6);
        List2 = new Node(1);
        List2.next = new Node(3);
        List2.next.next = new Node(5);
        List2.next.next.next = new Node(7);
    }
    public void mergeLists(){
        Node last = null,temp = null;
        while(List1 != null && List2 != null){
            if(List1.data < List2.data){
                temp = List1;
                List1 = List1.next;
                temp.next = null;
            }
            else if(List1.data >= List2.data){
                temp = List2;
                List2 = List2.next;
                temp.next = null;
            }
            if(result == null)
                result = last = temp;
            else{
                last.next = temp;
                last = last.next;
            }
        }
        last.next = List1 != null ? List1 : List2;
    }
}