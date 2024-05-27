/*
 *@Auther: Siyanda S Ntuli
 *Email: siyandasec25@gmail.com
 *Topic: 88. Merge Sorted Array
*/

class HelloWorld {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        int[] arr = merge(nums1,m,nums2,n);
        
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
    
    /*
    Step 1: Create temp array
    Step 2: find first m number in array 1, and first n numbers in array 2
    Step 3: store those number from these arrays into temp array
    Step 4: Arrange those numbers in temp array (ascending order)
    Step 5: return the array (for testing purposes)
    */
    
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
         int [] tempArray = new int[m+n];
        //nums1
         for(int i=0; i<m; i++){
            tempArray[i] = nums1[i];
         }

         //nums2
         for(int i=0; i<n; i++){
            tempArray[i+m] = nums2[i];
         }
         
         //Arrange tempArray elements
         int[] arrSort = new int[tempArray.length];
         
         for(int i=0; i<tempArray.length; i++){
             int min=tempArray[i];
             for(int j=i; j<tempArray.length; j++){
                 if(tempArray[i]<=tempArray[j]){
                 }else{
                     min = tempArray[j];
                     int temp = tempArray[i];
                     tempArray[j] = temp;
                 }
             }
             arrSort[i] = min;
         }
         return arrSort;
    }
}








