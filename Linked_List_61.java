class Linked_List_61 {
    Node Head;
    class Node{
        String data;
        Node next;
        Node(String value){
            data = value;
            next = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_61 list = new Linked_List_61();
        list.insertElement();
        list.printList();
        list.isPalindrome();
    }
    public void insertElement(){
        Head = new Node("a");
        Head.next = new Node("bc");
        Head.next.next = new Node("d");
        Head.next.next.next = new Node("dcb");
        Head.next.next.next.next = new Node("a");
    }
    public void printList(){
        Node move = Head;
        while(move != null){
            System.out.print(move.data + "->");
            move = move.next;
        }
        System.out.println();
    }
    public void isPalindrome(){
        String givenString = "";
        Node move = Head;
        while(move != null){
            givenString = givenString.concat(move.data);
            move = move.next;
        }

        //Check given string is pallindrome
        int length = givenString.length();
        int start = 0, end = length - 1;
        while(start <= end){
            if(givenString.charAt(start) != givenString.charAt(end)){
                System.out.println("False");
                return;
            }
            start ++;
            end --;
        }
        System.out.println("True");
    }
}