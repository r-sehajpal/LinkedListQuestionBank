class Linked_List_51 {
    Node Head,Small;
    class Node
    {
        int data;
        Node next,arbitrary;
        Node(int value)
        {
            data = value;
            next = arbitrary = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_51 list = new Linked_List_51();
        list.insertElement();
        list.pointToNextBigger();
        list.printArbitraryList();
    }
    public void insertElement()
    {
        Head = new Node(5);
        Head.next = new Node(10);
        Head.next.next = new Node(2);
        Head.next.next.next = new Node(3);
        Head.next.next.next.next = new Node(8);
        Head.next.next.next.next.next = new Node(1);
    }
    public void pointToNextBigger()
    {
        Node move = Head;
        Small = Head;
        while(move != null)
        {
            Node greater = null, temp = move.next;
            if(temp == null)
                temp = Head;
            while(temp != move)
            {
                if(temp.data > move.data)
                {
                    if(greater == null || greater.data > temp.data)
                        greater = temp;
                }
                temp = temp.next;
                if(temp == null)
                    temp = Head;
            }
            move.arbitrary = greater;
            if(Small.data > move.data)
                Small = move;
            move = move.next;
        }
    }
    public void printArbitraryList()
    {
        Node move = Small;
        while(move != null)
        {
            System.out.print(move.data + "->");
            move = move.arbitrary;
        }
        System.out.println("null");
    }
}