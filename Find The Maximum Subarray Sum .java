/*
 *@Auther: Siyanda S Ntuli
 *Email: siyandasec25@gmail.com
 *Topic: Find The Maximum Subarray Sum (Chadane's Algorithm) and nested for loops
*/

class HelloWorld {
    public static void main(String[] args) {
        int[] arr = {-1, 3, 4, -2};
        
        System.out.println(funct1(arr));
        
        HelloWorld hw = new HelloWorld();
        System.out.print(hw.funct2(arr)); //Non static method
    }
    
    //Chadane's Algorithm
    private static int funct1(int[] arr){
        int maxSum = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum+arr[i];
            
            if(sum<0){
                sum=0;
            }else if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
    
    //Nested for loops
    private int funct2(int[] arr){
        int maxSum = 0;
        
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum += arr[j];
                
                if(sum>maxSum){
                    maxSum = sum;
                }
            }
        }
        
        return maxSum;
    }
}