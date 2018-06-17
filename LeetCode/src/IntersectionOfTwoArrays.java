import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class IntersectionOfTwoArrays {

    // Brute Force

    public int[] intersection(int[] nums1, int[] nums2) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        if(nums1.length==0||nums2.length==0)
        {
            int[] result=new int[0];
            return result;
        }
        else
        {
            if(nums1.length<nums2.length)
            {

                for(int i=0;i<nums1.length;i++)
                {
                    for(int j=0;j<nums2.length;j++)
                    {
                        if(nums1[i]==nums2[j])
                        {
                            if(!list.contains(nums1[i]))
                            {
                                list.add(nums1[i]);
                            }
                        }
                    }
                }

            }
            else
            {
                for(int i=0;i<nums2.length;i++)
                {
                    for(int j=0;j<nums1.length;j++)
                    {
                        if(nums2[i]==nums1[j])
                        {
                            if(!list.contains(nums2[i]))
                            {
                                list.add(nums2[i]);
                            }
                        }
                    }
                }
            }
            int[] result=new int[list.size()];
            for(int i=0;i<list.size();i++)
            {
                result[i]=list.get(i);
            }
            return result;
        }

    }

    public int[] improvedIntersection(int[] nums1,int[] nums2)
    {
        Set<Integer> firstListSet=new HashSet<Integer>();
        Set<Integer> intersectionSet=new HashSet<Integer>();

        for(int i=0;i<nums1.length;i++)
        {
            firstListSet.add(nums1[i]);  //  add all elements to the first hashset
        }
        for(int i=0;i<nums2.length;i++)
        {
            if(firstListSet.contains(nums2[i]))
            {
                intersectionSet.add(nums2[i]);   // if the value in the firstListSet and nums2[] array match then put this value in the intersectionSet
            }
        }
        int[] result=new int[intersectionSet.size()];
        int i=0;
        for(Integer number:intersectionSet)
        {
           result[i++]=number;        // store the answer in the array and return it
        }
        return result;
    }

    public static void main(String[] args) {
    int[] list1=new int[]{1,2,2,1};
    int[] list2=new int[]{2,2};

    IntersectionOfTwoArrays iota=new IntersectionOfTwoArrays();
    int[] result=iota.intersection(list1,list2);
    for(int i=0;i<result.length;i++)
    {
        System.out.println(result[i]);
    }
    }
}
