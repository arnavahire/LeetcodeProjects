import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.util.regex.Pattern;

public class Temp {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        double temp=0;
        if(scan.hasNextDouble())
        {
            temp=scan.nextDouble();
            System.out.println(temp);
        }


        /*String a = "My name is  Ashwin";
        StringTokenizer tokenizer = new StringTokenizer(a);
        String answer = "";
        String[] array = a.split("\\s+");
        for(String s : array) {
            answer += reverseWord(s.toCharArray()) + " ";
        }

        System.out.print(answer);


        Calendar birthDate=Calendar.getInstance();
        birthDate.set(1994,11,20);
        Date dt=new Date();
        dt=birthDate.getTime();
        System.out.println(dt);*/
        //cal.set(2018,4,9,20,01,01);
        //System.out.println(cal.get(Calendar.DATE)+" "+cal.get(Calendar.MONTH)+" "+cal.get(Calendar.YEAR)+" "+cal.get(Calendar.HOUR)+" "+cal.get(Calendar.MINUTE)+" "+cal.get(Calendar.SECOND));


    }

    public static String reverseWord(char[] array) {
        int p1 = 0, p2 = array.length - 1;
        while(p1 < p2)
        {
            array[p1] ^= array[p2];
            array[p2] ^= array[p1];
            array[p1] ^= array[p2];
            p1++;
            p2--;
        }
        return new String(array);
    }

}

class Person
{
    private String name;
    private int age;

    public String getName() {
        if(isName(name))
            return name;
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isName(String name)
    {
        return Pattern.matches("[a-zA-z]+",name);
    }




}