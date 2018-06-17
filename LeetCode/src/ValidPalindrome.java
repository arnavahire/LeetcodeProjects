public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String stripped=s.replaceAll("\\W","").toLowerCase();  // [^\w] matches a non-word character, so the above regular expression will match and remove all non-word characters.
        System.out.println(stripped);  // we convert all the letters to lowercase
        if(stripped.length()==0)      // if empty string is found then return as palindrome
            return true;

        int i=0,j=stripped.length()-1;  // begin from start and end

        while(i<j)
        {
            if(stripped.charAt(i)==stripped.charAt(j))  // if matched then go to the next set of characters else return not a palindrome
            {
                i++;
                j--;
                continue;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp=new ValidPalindrome();
        String str="race a car";
        boolean result=vp.isPalindrome(str);
        System.out.println(result);
    }
}
