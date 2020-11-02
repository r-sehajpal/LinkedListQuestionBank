class Linked_List_75 {
    Node Poly1,Poly2,Result;
    class Node{
        int data,coef;
        Node next;
        Node(int value,int valueCoef){
            data = value;
            coef = valueCoef;
            next = null;
        }
    }
    public static void main(String[] args) {
        Linked_List_75 list = new Linked_List_75();
        list.createPolynomials();
        list.addPolynomials();
        list.displayResult();
    }
    public void displayResult(){
        Node move = Result;
        while(move != null){
            System.out.print(move.data + "^" + move.coef + "->");
            move = move.next;
        }
        System.out.println("null");
    }
    public void createPolynomials(){
        Poly1 = new Node(5,2);
        Poly1.next = new Node(3,1);
        Poly2 = new Node(2,2);
        Poly2.next = new Node(1,0);
    }
    public void addPolynomials(){
        Node temp,move1 = Poly1, move2 = Poly2,last = null;
        while(move1 != null && move2 != null){
            if(move1.coef == move2.coef){
                temp = new Node(move1.data + move2.data, move1.coef);
                move1 = move1.next;
                move2 = move2.next;
            }
            else if(move1.coef > move2.coef){
                temp = new Node(move1.data , move1.coef);
                move1 = move1.next;
            }
            else{
                temp = new Node(move2.data , move2.coef);
                move2 = move2.next;
            }
            if(Result == null)
                Result = last = temp;
            else{
                last.next = temp;
                last = temp;
            }
        }
        if(move1 != null){
            while(move1 != null){
                temp = new Node(move1.data,move1.coef);
                if(Result == null)
                    Result = last = temp;
                else{
                    last.next = temp;
                    last = temp;
                }
                move1 = move1.next;
            }
        }
        if(move2 != null){
            while(move2 != null){
                temp = new Node(move2.data,move2.coef);
                if(Result == null)
                    Result = last = temp;
                else{
                    last.next = temp;
                    last = temp;
                }
                move2 = move2.next;
            }
        }
    }
}