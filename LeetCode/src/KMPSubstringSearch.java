public class KMPSubstringSearch {
    int[] computeTemporaryArray(char[] pattern)
    {
        int[] temporaryArray=new int[pattern.length];
        int j=0;
        temporaryArray[j]=0;                      // the first index will always have a 0 value
        for(int i=1;i<temporaryArray.length;)
        {
            if(pattern[i]==pattern[j])       // if both the characters in the pattern are same, then temporary array's ith position will have j+1 value stored, indicating that we already have a match till jth index of the pattern
            {
                temporaryArray[i]=j+1;
                j++;
                i++;
            }
            else              // if characters do not match
            {
                if(j!=0)          // if the index j is not 0, then we go to the previous index of temporaryArray and assign the vaue at that index to j
                {
                    j=temporaryArray[j-1];
                }
                else              // if index j = 0 then we set the value at the ith index of temprary array as 0 and increment i
                {
                    temporaryArray[i]=0;
                    i++;
                }
            }
        }
        return temporaryArray;
    }

    public boolean KMPSearch(char[] text,char[] pattern)
    {
        int[] tempArray=computeTemporaryArray(pattern);   // get the temporary array which we will use in the KMP search
        int i=0;
        int j=0;
        while(i<text.length && j<pattern.length)
        {
            if(pattern[j]==text[i])      // if characters match then increment both i and j
            {
                i++;
                j++;
            }
            else           // if characters dont match
            {
                if(j!=0)              // if j is not 0 then we set j as the value present at j-1 th index of temporary array
                    j=tempArray[j-1];
                else
                    i++;             // if j = 0 then we simply increment i
            }
        }
        if(j==pattern.length)     // if we reach beyond the end of pattern array, it means that we found out pattern in the text
            return true;
        return false;

    }

    public static void main(String[] args) {
        KMPSubstringSearch kmp=new KMPSubstringSearch();
        char[] text="abxabcabcaby".toCharArray();
        char[] pattern="abcaby".toCharArray();

        int[] tempArray=kmp.computeTemporaryArray(pattern);
        for(int i=0;i<tempArray.length;i++)
            System.out.println(tempArray[i]);

        boolean result=kmp.KMPSearch(text,pattern);
        System.out.println(result);

        String str="abcabcaby";
        String Strpattern="abcaby";

        int resultCount=kmp.normalSubstringsearch(str,Strpattern);
        System.out.println("Normal Substring search Result: "+resultCount);

        boolean KMPResult=kmp.KMPSearchAfterArrayCreation(str.toCharArray(),Strpattern.toCharArray());
        System.out.println(KMPResult);
    }

    public int normalSubstringsearch(String text, String pattern)
    {
        int j=0;
        int k=0;
        int count=0;

        for(int i=0;i<text.length();)
        {
            if(j<pattern.length())
            {
                if(text.charAt(i)==pattern.charAt(j))
                {
                    i++;
                    j++;
                }
                else
                {
                    j=0;
                    k++;
                    i=k;
                }
            }
            if(j==pattern.length())
            {
                count++;
                j=0;
            }
        }
        return count;
    }

    public int[] createTempArray(char[] pattern)
    {
        int[] temp=new int[pattern.length];
        temp[0]=0;

        int j=0;

        for(int i=1;i<temp.length;)
        {
            if(pattern[i]!=pattern[j])
            {
                if(!(j<=0))
                j=temp[j-1];
                else
                {
                    temp[i]=0;
                    i++;
                }
            }
            else
            {
                temp[i]=j+1;
                j++;
                i++;
            }

        }

        for(int i=0;i<temp.length;i++)
            System.out.println(temp[i]);

        return temp;
    }

    public boolean KMPSearchAfterArrayCreation(char[] text, char[] pattern)
    {
        int[] tempArray=createTempArray(pattern);

        int j=0;

        for(int i=0;i<text.length;)
        {
            if(text[i]==pattern[j])
            {
                i++;
                j++;
            }
            else
            {
                if(j!=0)
                    j=tempArray[j-1];
                else
                    i++;
            }
            if(j==pattern.length)
                return true;
        }
        return false;
    }


}
