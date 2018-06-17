import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> fizzBuzzList=new LinkedList<String>();
        for (int i=1;i<=n;i++)
        {
            if(i%3==0 && i%5==0)
            {
                fizzBuzzList.add("FizzBuzz");
            }
            else if(i%5==0)
            {
                fizzBuzzList.add("Buzz");
            }
            else if(i%3==0)
            {
                fizzBuzzList.add("Fizz");
            }
            else
            {
                fizzBuzzList.add(String.valueOf(i));
            }
        }
        return fizzBuzzList;
    }

    public static void main(String[] args) {
        FizzBuzz fb=new FizzBuzz();
        int number=30;
        List<String> result;
        result=fb.fizzBuzz(number);
        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }

    }
}
