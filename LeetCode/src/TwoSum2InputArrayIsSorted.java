public class TwoSum2InputArrayIsSorted {

    // Brute Force

    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        for(int i=0;i<numbers.length-1;i++)
        {
            for(int j=i+1;j<numbers.length;j++)
            {
                if(numbers[i]+numbers[j]==target)
                {
                    result[0]=i+1;
                    result[1]=j+1;
                }
            }
        }
        return result;
    }

    // improved

    public int[] improvedTwoSum(int[] numbers, int target) {
        int[] result=new int[2];
        if(numbers.length==0)
            return result;
        int low=0;
        int high=numbers.length-1;
        int add=0;
        while (low<high)          // till the low pointer has less value than high pointer
        {
            add=numbers[low]+numbers[high];  // add contains the addition
            if(add==target)
            {
                result[0]=low+1;
                result[1]=high+1;  // if add equals target then return the answer without zero-based index
                break;
            }
            else if(add>target)    // if the add has more value than target then reduce high
            {
                high--;
            }
            else                   // if add has less value than target then increase low
            {
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum2InputArrayIsSorted ts2ia=new TwoSum2InputArrayIsSorted();
        int[] arr=new int[]{-1,0};
        int target=-1;
        int[] result=ts2ia.improvedTwoSum(arr,target);
        for(int i=0;i<result.length;i++)
        {
            System.out.println(result[i]);
        }
    }
}
