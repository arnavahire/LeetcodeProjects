public class ReverseString {
    public String reverseString(String s) {
        int i=0,j=s.length()-1;
        char[] word=s.toCharArray();
        while(i<j)
        {
            char temp=word[i];
            word[i]=word[j];
            word[j]=temp;
            i++;
            j--;
        }
        return String.valueOf(word);
    }
}
