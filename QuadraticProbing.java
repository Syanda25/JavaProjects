/*
 *@Auther: Siyanda S Ntuli
 *Email: siyandasec25@gmail.com
 *Topic: Quadratic Probing
*/


public class QuadraticProbing {
    public static void main(String args[]){

    }
    
    public static int[] hashTable(int[] myArray){
        int[] table = new int[myArray.length]; //Hash table
        
        for(int i=0; i<=myArray.length; i++){
            //Step 1: find index
            int index = myArray[i]%myArray.length;
            
            //Step 2: Check if the bucket is empty or not at that index
            if(table[index]==0){ //Step 2.1: Bucket is empty (No collision)
                table[index] = myArray[i]; //Insert the new entry
            }else{ //Step 2.1: Collision Occured
                int tracker = 1; //j
                boolean isEmpty = false; //tracker, to check if the new bucket is empty or not
                while(!(isEmpty)){ // While we can't find an empty bucket, try to find new index, with an empty bucket
                    index = (myArray[i]+tracker^2)%myArray.length; //h(x) = (x+j^2)%size
                    if(table[index]==0){ //Check if the newly found bucket is empty or not
                        isEmpty = true; //Empty bucket
                        table[index] = myArray[i]; //insert entry
                    }else{
                        tracker++; //Increment j as we can't find an empty bucket
                    }
                }
            }
        }
        
        return table;
    }
}