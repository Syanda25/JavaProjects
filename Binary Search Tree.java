/*
 *@Auther: Siyanda S Ntuli
 *Email: siyandasec25@gmail.com
 *Topic: Binary tree: insertion
*/


class HelloWorld {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(6);
        bst.insert(15);
        bst.insert(3);
        bst.insert(8);
        bst.insert(13);
        bst.insert(20);
        bst.insert(4);
        
        bst.displayPath(4);
    }
}

class BinarySearchTree{
    private class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data = data;
            left = null;
            right= null;
        }
    }
    
    private Node head;
    
    public BinarySearchTree(){
        head = null;
    }
    
    public void insert(int input){
        Node newNode = new Node(input);
        
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            Node parent = null;
            
            while(temp!=null){
                parent = temp;
                if(input >= temp.data){
                    temp = temp.right;
                }else{
                    temp = temp.left;
                }
            }
            
            if(input >= parent.data){
                newNode = parent.right;
            }else{
                newNode = parent.left;
            }
        }
    }
    
    public String displayPath(int nodeData){
        Node temp = head;
        StringBuilder display = new StringBuilder();
        if(temp == null){
            display.append("null");
            return display.toString();
        }
        
        while(temp!=null){
            display.append(temp.data);
            
            if(nodeData > temp.data){
                temp = temp.right;
            }else if(nodeData< temp.data){
                temp = temp.left;
            }else{
                display.append("=> null");
                //teake the first node ecounted that has value of nodeData
                break; 
            }
            display.append("=> null");
        }
        return display.toString();
    }
}