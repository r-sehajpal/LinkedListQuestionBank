class Linked_List_42 {
    Node Number1,Number2,Head;
    class Node{
        int data;
        Node next;
        Node(int value)
        {
            data = value;
            next = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_42 list = new Linked_List_42();
        list.insertElement();
        list.addList();
        list.showResult();
    }
    public void showResult()
    {
        Node move = Head;
        while(move != null)
        {
            System.out.print(move.data+"->");
            move = move.next;
        }
        System.out.println("null");
    }
    //To get the size of the passed list
    public int getSize(Node move)
    {
        int size = 0;
        while(move != null)
        {
            size ++;
            move = move.next;
        }
        return size;
    }
    int carry;
    Node cur;

    public void pushElement(int nodeData)
    {
        Node temp = new Node(nodeData);
        if(Head != null)
        {
            temp.next = Head;
        }
        Head = temp;
    }
    public void addSameSize(Node a, Node b)
    {
        if(a == null)
            return;

        //Recursively call till we reach end of both list
        addSameSize(a.next, b.next);

        //Calculate carry
        int number = a.data + b.data + carry;
        carry = number/10;
        pushElement(number%10);
    }
    public void addList()
    {
        int size1 = getSize(Number1);
        int size2 = getSize(Number2);
        if(size1 == size2)
        {
            addSameSize(Number1, Number2);
        }
        else
        {
            if(size1 < size2)
            {
                Node temp = Number1;
                Number1 = Number2;
                Number2 = temp;
            }
            int diff = Math.abs(size1-size2);
            Node temp = Number1;
            while(diff-- >0)
            {
                   cur = temp;
                   temp = temp.next;
            }

            //Add two lists with same size
            addSameSize(cur.next,Number2);

            addPropogatoryNodes(Number1);

        }
    }
    public void addPropogatoryNodes(Node a)
    {
        if(a == cur.next)
            return;

        //Add remaining nodes in bigger linked list
        addPropogatoryNodes(a.next);

        //use carry form addSameSize() function in order to add remaining nodes
        int number = a.data + carry;
        carry = number/10;
        pushElement(number%10);

    }
    public void insertElement()
    {
        //Insert Elements for first number
        Number1 = new Node(4);
        Number1.next = new Node(6);
        Number1.next.next = new Node(9);
        Number1.next.next.next = new Node(7);
        Number1.next.next.next.next = new Node(8);

        //Insert element for second number
        Number2 = new Node(5);
        Number2.next = new Node(6);
        Number2.next.next = new Node(3);
    }
}