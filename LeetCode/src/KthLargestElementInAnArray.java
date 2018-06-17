public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int[] answerArray=quickSort(nums,0,nums.length-1);     // call quickSort method to sort the array.
        return answerArray[answerArray.length-k];                     // return the kth largest element. (The 1st largest will b at n-1 th position, so kth largest will be at n-kth position)
    }
    public int[] quickSort(int[] input,int start,int end)
    {
        if(start<end)      // perform sort only if there are more than 2 elements in the array, coz single element array is always sorted
        {
            int pivot_index=partition(input,start,end);  // we get the pivot index based on which we perform the sort
            quickSort(input,start,pivot_index-1);
            quickSort(input,pivot_index+1,end);
        }
        return input;

    }
    public int partition(int[] input,int start,int end)
    {
        int pivot=input[end];  // we consider the last element as our pivot during each partitioning
        int pivot_index=start;
        for(int i=start;i<end;i++)
        {
            if(input[i]<=pivot)  // we put the smaller elements to the left side of the pivot index
            {
                //swap the elements at pivot_index and ith index
                int temp=input[i];
                input[i]=input[pivot_index];
                input[pivot_index]=temp;
                pivot_index++;
            }
        }
        int temp=input[end];             // we swap the element at pivot index so that we get the pivot element at the pivot index
        input[end]=input[pivot_index];
        input[pivot_index]=temp;
        return pivot_index;
    }
}
