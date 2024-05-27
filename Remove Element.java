/*
 *@Auther: Siyanda S Ntuli
 *Email: siyandasec25@gmail.com
 *Topic: 27. Remove Element
*/

class HelloWorld {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        
        System.out.print(removeElement(nums,val));
    }
    
    private static int removeElement(int[] nums, int val) {
         int k=nums.length; //initially no number removed
         int[] temp = new int[nums.length]; //To store remain elements
         int counter = 0;  //Track the last element in temp
         for(int i=0; i<nums.length; i++){
            if(nums[i] == val){
                k--; //if encounter number equals val; decrement k
            }else{
                temp[counter] = nums[i]; //if element != k add to temp
                counter++;
            }
         }
         for(int i=0; i<temp.length; i++){
            System.out.print(temp[i]);
        }
        System.out.println("");
         return k; //Step: 5
    }
}








