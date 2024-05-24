public class CharacterToIndexExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.insertEnd("Hello");
        list.insertEnd("World");
        list.insertEnd("World2");
        list.insertAtPosition(3,"Hola");
        
        System.out.print(list.displayData());
    }
}

class LinkedList<T>{

    class Node<T>{
        private Node<T> next;
        private T data;
    
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> root;
    private int size;
    
    public LinkedList(){
        this.root = null;
        this.size = 0;
    }
    
    private boolean positionOutOfBound(int position){
        //position out of bound
        if(position>this.size || position<1){ 
            return true;
        }
        return false;
    }
    //Insert a node in a position(position starts at 0)
    public void insertAtPosition(int position, T data){
        
        if(positionOutOfBound(position)){
            System.out.print("Position out of bounds");
            return;
        }
        Node<T> newNode = new Node<>(data);
        Node<T> temp = root;
        while(position-1 > 0){
            temp = temp.next;
            position--;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        this.size++;
    }
    
    public void insertEnd(T data){
        Node<T> newNode = new Node<>(data);
        
        if(root==null){
            root = newNode;
        }else{
            Node<T> temp = root;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        this.size++;
    }
    
    //Display data inside Linked List
    public String displayData(){
        Node<T> temp = root;
        StringBuilder strDisplay = new StringBuilder();
        while(temp != null){
            strDisplay.append(temp.data);
            strDisplay.append("\n");
            temp = temp.next;
        }
        
        return strDisplay.toString();
    }
}




