/*
 @Author: Siyanda Ntuli
 @Email: siyandasec25@gmail.com
 @Topic: Stack data structure (Integers)
*/


public class StackDS {
    public static void main(String args[]) {
        Stack stack = new Stack(5);
        
        
    }
}

class Stack{
    private stackSize; //Stack size (Number pf elements can be inserted)
    private int[] stack; //Stack itself
    private int pointer = -1;  //Pointer to point at the top of the stack
    
    public Stack(int stackSize){
        this.stackSize = stackSize;
        stack = new int[this.stackSize];
    }
    
    public void push(int element){ 
        if(isFull()){ //A
            System.err.print("Stack overflow");
            return;
        }else{
            stack[pointer+1] = element; //B
            pointer++; //C
        }
    }
    
    public int pop(){
        if(isEmpty()){ //Check if the stack is not empty;
            System.err.print("Empty Stack");
            return 0;
        }else{
            int value = stack[pointer];
            stack[pointer]=0; //Since in java the integer (primitive data type) can not be null, then we need to set to 0
            pointer--;
            return value;
        }
    }
    
    //Get the last inserted element in a stack (but do not delete it)
    public int peek(){
        return stack[pointer];
    }
    
    public boolean isEmpty(){
        if(pointer<=-1){
            return true;
        }
        
        return false;
    }
    
    public boolean isFull(){
        if(pointer+1 >= stackSize){
            return true;
        }
        
        return false;
    }
    
    //Display the data structure
    public string display(){
        String strDisplay = "[";
        for(int element: stack){
            strDisplay += element +","
        }
        strDisplay+="]";
        
        return strDisplay;
    }
}