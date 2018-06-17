import java.util.HashMap;
import java.util.Scanner;
public class RomanToInteger {

    public int romanToInt(String s) {
        s=s.toUpperCase();
        String[] splits=s.split("");
        int[] numbers=new int[splits.length];
        for(int i=0;i<splits.length;i++)                        // for every roman numeral in the string array make its corresponding int array that stores integers for those specific indices
        {
            if(splits[i].equalsIgnoreCase("M"))
            {
                numbers[i]=1000;
            }
            else if(splits[i].equalsIgnoreCase("D"))
            {
                numbers[i]=500;
            }
            else if(splits[i].equalsIgnoreCase("C"))
            {
                numbers[i]=100;
            }
            else if(splits[i].equalsIgnoreCase("L"))
            {
                numbers[i]=50;
            }
            else if(splits[i].equalsIgnoreCase("X"))
            {
                numbers[i]=10;
            }
            else if(splits[i].equalsIgnoreCase("V"))
            {
                numbers[i]=5;
            }
            else if(splits[i].equalsIgnoreCase("I"))
            {
                numbers[i]=1;
            }
            else
            {
                continue;
            }
        }

        int romanToInt=0;

        for(int i=0;i<numbers.length;i++)
        {
            if(i==numbers.length-1)         // if i is the last index then add the number as it is to our result
            {
                romanToInt=romanToInt+numbers[i];
            }
            else if(i<=numbers.length-2)    // for every other index check if the element in its successor index is greater than the current element
            {
                if(numbers[i]<numbers[i+1])
                {
                    romanToInt=romanToInt-numbers[i];  // if the next element is greater than previous then reduce the value of current element from the result
                }
                else
                {
                    romanToInt=romanToInt+numbers[i];  // if the next element is smaller than the current element then simply add the current element's value to the result
                }
            }
        }
        return romanToInt;
    }

    public int improvedRomanToInt(String s)
    {
        if(s==null ||s.length()==0)  // empty string
        {
            return 0;
        }
        else
        {
            HashMap<Character,Integer> map=new HashMap<>();  // store the mappings of roman to integer in a hashmap
            map.put('M',1000);
            map.put('D',500);
            map.put('C',100);
            map.put('L',50);
            map.put('X',10);
            map.put('V',5);
            map.put('I',1);

            int answer=0;
            s=s.toUpperCase();

            for(int i=0;i<s.length();i++)
            {
                if(i==s.length()-1)                // if it's the last element in the numeral, add it as it is to the answer
                {
                    answer+=map.get(s.charAt(i));
                }
                else
                {
                    if(map.get(s.charAt(i))>=map.get(s.charAt(i+1)))
                    {
                        answer+=map.get(s.charAt(i));        // if the current element is greater than next element then add it in the answer
                    }
                    else
                    {
                        answer-=map.get(s.charAt(i));  // if the next element is greater than the current element then subtract the current element from the answer
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
    RomanToInteger r2i=new RomanToInteger();

    Scanner scan=new Scanner(System.in);
    System.out.println("Enter a roman number: ");
    String input=scan.next();
    int result=r2i.romanToInt(input);
    System.out.println(result);
    int result2=r2i.improvedRomanToInt(input);
    System.out.println(result2);
    }
}
