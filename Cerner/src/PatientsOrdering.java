/*
Given a list of streamed patients (consisting of names, briths, date last seen),
return the 3 most recently seen patients from that list.
Assume the list of incoming patients is not ordered in any particular order.
*/

import java.util.*;

class Patient
{
    private String name;
    private Date birthDate;
    private Date lastSeen;

    public Patient(String name,int birthYear,int birthMonth,int birthDate,int visitYear,int visitMonth,int visitDate)
    {
        this.name=name;

        Calendar cal1=Calendar.getInstance();
        cal1.set(birthYear,birthMonth,birthDate);
        this.birthDate=cal1.getTime();

        Calendar cal2=Calendar.getInstance();
        cal2.set(visitYear,visitMonth,visitDate);
        this.lastSeen=cal2.getTime();
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setBirthDate(int year,int month,int date)
    {
        Calendar cal=Calendar.getInstance();
        cal.set(year,month,date);
        this.birthDate=cal.getTime();
    }

    public void setLastSeen(int year,int month,int date)
    {
        Calendar cal=Calendar.getInstance();
        cal.set(year,month,date);
        this.lastSeen=cal.getTime();
    }

    public String getName()
    {
        return name;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public Date getLastSeen()
    {
        return lastSeen;
    }

}

class dateComparator implements Comparator
{
    @Override
    public int compare(Object o1,Object o2)
    {
        Date d1=((Patient)o1).getLastSeen();
        Date d2=((Patient)o2).getLastSeen();

        return d2.compareTo(d1);
    }

}

public class PatientsOrdering {

    public static void main(String[] args)
    {
        List<Patient> list=new ArrayList<Patient>();
        Patient p1=new Patient("Arnav",1992,10,02,2016,12,21);
        Patient p2=new Patient("Ashwin",1992,10,28,2016,12,22);
        Patient p3=new Patient("Akshay",1992,1,02,2015,12,21);
        Patient p4=new Patient("Prasad",1992,2,02,2014,12,21);
        Patient p5=new Patient("Robin",1992,5,02,2012,21,21);
        Patient p6=new Patient("Kedar",1992,6,02,2013,12,21);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        Collections.sort(list,new dateComparator());

        for(Patient p:list)
        {
            System.out.println(p.getName()+" "+p.getLastSeen());
        }

    }

}
