/* This class is meant for experimenting. The original problem is solved in the Nurse class*/








import java.util.*;

class Frequency2
{
    public enum Reminder
    {
        Hourly,EveryFourHours,Daily;
    }

    private Reminder reminder;

    public Frequency2(Reminder reminder)
    {
        this.reminder=reminder;
    }

    public void setReminder(Reminder reminder)
    {
        this.reminder=reminder;
    }

    public Reminder getReminder()
    {
        return reminder;
    }

}

interface AlarmListener2
{
    public void notifyNurse(Frequency2.Reminder remind);
}

public class Nurse2 implements AlarmListener2{

    private String name;
    private Set<Frequency2.Reminder> noOfTimes=new HashSet<Frequency2.Reminder>();

    public Nurse2(String name)
    {
        this.name=name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return name;
    }

    public void addTime(Frequency2.Reminder reminder)
    {
        this.noOfTimes.add(reminder);
    }

    @Override
    public void notifyNurse(Frequency2.Reminder reminder) {
        if(noOfTimes.contains(reminder))
        {
            //System.out.println("Nurse "+name+", You are scheduled for "+msg+" for giving medications");

            switch(reminder)
            {
                case Hourly: Timer timer=new Timer();
                    TimerTask hourlyTask=new TimerTask(){
                        @Override
                        public void run()
                        {
                            Calendar cal=Calendar.getInstance();
                            cal.add(Calendar.HOUR,1);
                            System.out.println("Nurse "+name+", You are scheduled for giving medications at "+cal.getTime());
                        }
                    };
                    timer.scheduleAtFixedRate(hourlyTask,01,1*20*1000);
                    break;
                case EveryFourHours: timer=new Timer();
                    TimerTask everyFourHoursTask=new TimerTask(){
                        public void run()
                        {
                            Calendar cal=Calendar.getInstance();
                            cal.add(Calendar.HOUR,4);
                            System.out.println("Nurse "+name+", You are scheduled for giving medications at "+cal.getTime());
                        }
                    };
                    timer.scheduleAtFixedRate(everyFourHoursTask,01,2*20*1000);
                    break;
                case Daily: timer=new Timer();
                    TimerTask dailyTask=new TimerTask()
                    {
                        public void run()
                        {
                            Calendar cal=Calendar.getInstance();
                            cal.add(Calendar.DATE,1);
                            System.out.println("Nurse "+name+", You are scheduled for giving medications at "+cal.getTime());
                        }
                    };
                    timer.scheduleAtFixedRate(dailyTask,01,1*60*1000);
                    break;
                default: System.out.println("Invalid reminder");
                    System.exit(0);
            }
        }
    }

    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append(name).append(": scheduled for : ");
        for(Frequency2.Reminder time:noOfTimes)
        {
            sb.append(time).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Nurse2 alice=new Nurse2("Alice");
        alice.addTime(Frequency2.Reminder.Hourly);
        alice.addTime(Frequency2.Reminder.Daily);

        Nurse2 bob=new Nurse2("Bob");
        bob.addTime(Frequency2.Reminder.Hourly);
        bob.addTime(Frequency2.Reminder.EveryFourHours);

        Scheduler2 scheduler=new Scheduler2();
        scheduler.addNurse(alice);
        scheduler.addNurse(bob);

        scheduler.RollCall();

        scheduler.notifyListeners(Frequency2.Reminder.Hourly);
        scheduler.notifyListeners(Frequency2.Reminder.EveryFourHours);
        scheduler.notifyListeners(Frequency2.Reminder.Daily);
    }
}

class Scheduler2
{
    List<Nurse2> nursesList=new ArrayList<>();

    public void addNurse(Nurse2 nurse)
    {
        nursesList.add(nurse);
    }

    public Nurse2 removeNurse(Nurse2 nurse)
    {
        nursesList.remove(nurse);
        return nurse;
    }

    public void RollCall()
    {
        System.out.println("Roll Call:");
        for(Nurse2 nurse:nursesList)
        {
            System.out.println(nurse.toString());
        }
    }

    public void notifyListeners(Frequency2.Reminder time)
    {
        for(Nurse2 nurse:nursesList)
        {
            nurse.notifyNurse(time);
        }
    }

}
