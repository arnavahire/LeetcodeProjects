/*
Design a class to record a new born's birth date and time reflecting the time zone.
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* NOTE: Although Date data type shows us the timeZone, there is no timeZone field for date.
        It attaches the JVM's timeZone to each date that is returned. So no matter what timeZone you choose,
        Date will return only that timezone which is attached to your JVM.
        You should either use SimpleDateFormat or Java.time framework to print the date in your timeZone

 */

public class NewBorn
{
    String name;
    Date birthDate;
    String continent;
    String city;

    public NewBorn(String name,int year,int month,int date,String continent,String city)
    {
        this.name=name;

        Calendar cal=Calendar.getInstance();
        cal.set(year,month,date);
        this.birthDate=cal.getTime();

        this.continent=continent;
        this.city=city;
    }

    /******* GETTERS AND SETTERS *****************/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBirthDate(int year,int month,int date)
    {
        Calendar cal=Calendar.getInstance();
        cal.set(year,month,date);
        birthDate=cal.getTime();
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    /*********** CONVERT TO DIFF. TIMEZONE FUNCTION **************/

    public String getBirthInDifferentTimeZone(String continent,String city)
    {
        TimeZone tz=TimeZone.getTimeZone(continent+"/"+city);

        Calendar cal=Calendar.getInstance();
        cal.setTime(birthDate);

        SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        sdf.setCalendar(cal);
        sdf.setTimeZone(tz);
        return sdf.format(cal.getTime());
    }

    public String getBirthInBirthPlaceTimeZone()
    {
        TimeZone tz=TimeZone.getTimeZone(this.continent+"/"+this.city);

        Calendar cal=Calendar.getInstance();
        cal.setTime(birthDate);

        SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy HH:mm::ss");
        sdf.setCalendar(cal);
        sdf.setTimeZone(tz);
        return sdf.format(cal.getTime());
    }

    public static void main(String[] args)
    {
        NewBorn nb=new NewBorn("Arnav",1992,1,2,"America","Los_Angeles");
        System.out.println(nb.getBirthDate());
        System.out.println(nb.getBirthInBirthPlaceTimeZone());
        System.out.println(nb.getBirthInDifferentTimeZone("Africa","Casablanca"));

    }


}