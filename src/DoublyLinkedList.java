import java.util.Scanner;


interface DLL {
    void addAtLast(int data);
    void addAtBeginning(int data);
    void delete(int data);
    void insert(int pos,int data);
    boolean isEmpty();
    void display();
    void revDisplay();
}


class Node  {
    int data;
    Node next;
    Node prev;
    Node(int data){
       this.data = data;
    }
}
public class DoublyLinkedList implements DLL {
    Node head;
    Node tail;
    @Override
    public void addAtLast(int data) {
        Node f = new Node(data);
        if(!isEmpty()){
            Node temp = head;
            while (temp.next !=null){
                temp = temp.next;
            }
            temp.next = f;
            f.prev = temp;
            tail = f;
        }
        else{
            head = f;
        }
    }
    @Override
    public void addAtBeginning(int data) {
        Node f = new Node(data);
        if(!isEmpty()){
            Node temp = head;
            f.next = temp;
            temp.prev = f;
        }
        head = f;
    }

    @Override
    public void delete(int data) {
        if(!isEmpty()){
            Node temp = head;
            while(temp.next.data != data){
                temp = temp.next;
            }
            temp.next.next.prev = temp;
            temp.next = temp.next.next;
        }
        else{
            System.out.println("List already empty");
        }
    }

    @Override
    public void insert(int pos,int data) {
        Node f = new Node(data);
        if(!isEmpty()){
            int c=1;
            Node temp = head;
            while(c<pos-1 && temp.next!=null){
                temp = temp.next;
                c++;
            }
            f.next = temp.next;
            temp.next.prev = f;
            temp.next = f;
            f.prev = temp;
        }
        else{
            System.out.println("List empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void display() {
        if(!isEmpty()) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }
        else{
            System.out.println("List is empty");
        }
    }
    @Override
    public void revDisplay(){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+"<-");
            temp = temp.prev;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList List1 = new DoublyLinkedList();
        List1.addAtLast(5);
        List1.addAtLast(17);
        List1.addAtLast(16);
        List1.addAtLast(19);
        List1.addAtLast(4);
        List1.addAtLast(3);
        List1.addAtLast(7);
        List1.addAtLast(1);
        List1.display();
        DoublyLinkedList List2 = new DoublyLinkedList();
        copyPrime(List1,List2);
        List2.display();

    }
    public static boolean isPrime(Node isit){
        if(isit.data==2 || isit.data==1) return true;
        for(int i=2;i<=(isit.data/2);i++){
            if(isit.data%i==0)
                return false;
        }
        return true;
    }
    public static void copyPrime(DoublyLinkedList List1,DoublyLinkedList List2){
        Node temp1 = List1.head;
        while(temp1!=null){
            if(isPrime(temp1)){
                List2.addAtLast(temp1.data);
            }
            temp1 = temp1.next;
        }
    }
}
