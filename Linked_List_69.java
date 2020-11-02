class Linked_List_69 {
    Node List1,List2;
    static Node answer;
    class Node{
        int data;
        Node next;
        Node(int value){
            data = value;
            next = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_69 list = new Linked_List_69();
        list.insertElement();
        answer = list.subtractLists();
    }
    public void insertElement(){
        List1 = new Node(1);
        List1.next = new Node(2);
        List1.next.next = new Node(3);
        List2 = new Node(3);
        List2.next = new Node(1);
        List2.next.next = new Node(2);
    }
    public int getLength(Node move){
        int count = 0;
        while(move != null){
            count ++;
            move = move.next;
        }
        return count;
    }
    public Node paddZeroes(Node move,int zeroCount){
        while(zeroCount != 0){
            Node temp = new Node(0);
            temp.next = move;
            move = temp;
            zeroCount--;
        }
        return move;
    }
    public Node subtractListsHelper(Node large, Node small){

    }
    public Node subtractLists(){
        Node lNode = null,sNode = null;
        int length1 = getLength(List1);
        int length2 = getLength(List2);
        if(length1 != length2){
            lNode = length1 > length2 ? List1 : List2;
            sNode = length1 > length2 ? List2 : List1;
            sNode = paddZeroes(sNode,Math.abs(length1 - length2));
        }
        else{
            Node l1 = List1, l2 = List2;
            while(l1 != null && l2 != null){
                if(l1.data != l2.data){
                    lNode = l1.data > l2.data ? l1 : l2;
                    sNode = l1.data > l2.data ? l2 : l1;
                    break;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            boolean borrow = false;
            return subtractListsHelper(lNode, sNode);
        }
    }
}