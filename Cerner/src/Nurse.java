/* System Design: Notification to a nurse about when to give medication to a patient. */

import java.util.*;

/********************************** FREQUENCY *****************************************/

class Frequency
{
    public enum Reminder
    {
        Hourly,EveryFourHours,Daily;
    }

    private Reminder reminder;

    public Frequency(Reminder reminder)
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

/********************************* ALARMLISTENER *****************************************/

interface AlarmListener
{
    public void notifyNurse(Frequency.Reminder remind);
}

/********************************* NURSE *****************************************/

public class Nurse implements AlarmListener{

    private String name;
    private Set<Frequency.Reminder> noOfTimes=new HashSet<Frequency.Reminder>();

    public Nurse(String name)
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

    public void addTime(Frequency.Reminder reminder)
    {
        this.noOfTimes.add(reminder);
    }

    @Override
    public void notifyNurse(Frequency.Reminder reminder) {
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
                             timer.scheduleAtFixedRate(hourlyTask,01,60*60*1000);
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
                                     timer.scheduleAtFixedRate(everyFourHoursTask,01,4*60*60*1000);
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
                            timer.scheduleAtFixedRate(dailyTask,01,24*60*60*1000);
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
        for(Frequency.Reminder time:noOfTimes)
        {
            sb.append(time).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Nurse alice=new Nurse("Alice");
        alice.addTime(Frequency.Reminder.Hourly);
        alice.addTime(Frequency.Reminder.Daily);

        Nurse bob=new Nurse("Bob");
        bob.addTime(Frequency.Reminder.Hourly);
        bob.addTime(Frequency.Reminder.EveryFourHours);

        Scheduler scheduler=new Scheduler();
        scheduler.addNurse(alice);
        scheduler.addNurse(bob);

        scheduler.RollCall();

        scheduler.notifyNurses(Frequency.Reminder.Hourly);
        scheduler.notifyNurses(Frequency.Reminder.EveryFourHours);
        scheduler.notifyNurses(Frequency.Reminder.Daily);

        //------ After notifying each nurse

        Medicine med1=new Medicine("Paracetamol","32g","For Fever");
        List<Frequency> med1Frequency=new ArrayList<Frequency>();
        med1Frequency.add(new Frequency(Frequency.Reminder.Hourly));
        med1Frequency.add(new Frequency(Frequency.Reminder.Daily));
        med1.setFrequencyList(med1Frequency);

        Medicine med2=new Medicine("Ibuprufen","32g","For Swelling");
        List<Frequency> med2Frequency=new ArrayList<Frequency>();
        med2Frequency.add(new Frequency(Frequency.Reminder.EveryFourHours));
        med2Frequency.add(new Frequency(Frequency.Reminder.Daily));
        med2.setFrequencyList(med2Frequency);

        List<Medicine> medicinesList=new ArrayList<>();
        medicinesList.add(med1);
        medicinesList.add(med2);

        Disease d1=new Disease();
        d1.setName("Malaria");

        Disease d2=new Disease();
        d2.setName("Filaria");

        List<Disease> diseaseList=new ArrayList<>();
        diseaseList.add(d1);
        diseaseList.add(d2);

        Patient1 p=new Patient1("Arnav");
        p.setDiseases(diseaseList);
        p.setMedicines(medicinesList);

        List<Patient1> PatientList=new ArrayList<>();
        PatientList.add(p);
        for(Patient1 patient:PatientList)
        {
            System.out.println("Patient: "+patient.getName());

            for(Disease d:patient.getDiseases())
            {
                System.out.println("Disease: "+d.getName());
            }

            for(Medicine m:patient.getMedicines())
            {
                System.out.print("Medicine: "+m.getName()+" ");
                for(Frequency f:m.getFrequencyList())
                {
                    Frequency.Reminder r=f.getReminder();
                    System.out.println(r);
                }
            }
        }

    }
}

/********************************** SCHEDULER *****************************************/

class Scheduler
{
    List<Nurse> nursesList=new ArrayList<>();

    public void addNurse(Nurse nurse)
    {
        nursesList.add(nurse);
    }

    public AlarmListener removeNurse(Nurse nurse)
    {
        nursesList.remove(nurse);
        return nurse;
    }

    public void RollCall()
    {
        System.out.println("Roll Call:");
        for(Nurse nurse:nursesList)
        {
            System.out.println(nurse.toString());
        }
    }

    public void notifyNurses(Frequency.Reminder time)
    {
        for(Nurse nurse:nursesList)
        {
            nurse.notifyNurse(time);
        }
    }
}

/********************************* MEDICINE *****************************************/

class Medicine
{
    private String name;
    private String composition;
    private String description;
    private List<Frequency> frequencyList;

    public Medicine(String name,String composition,String description)
    {
        this.name=name;
        this.composition=composition;
        this.description=description;
        frequencyList=new ArrayList<>();
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setComposition(String composition)
    {
        this.composition=composition;
    }

    public void setDescription(String description)
    {
        this.description=description;
    }

    public String getName()
    {
        return name;
    }

    public String getComposition()
    {
        return composition;
    }

    public String description()
    {
        return description;
    }

    public void setFrequencyList(List<Frequency> freqList)
    {
        frequencyList=freqList;
    }

    public List<Frequency> getFrequencyList()
    {
        return frequencyList;
    }
}

/********************************* PATIENT *****************************************/

class Patient1
{
    private String name;
    private List<Disease> diseases;
    private List<Medicine> medicines;

    public Patient1(String name)
    {
        this.name=name;
        diseases=new ArrayList<Disease>();
        medicines=new ArrayList<Medicine>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

}

/********************************* DISEASE *****************************************/

class Disease
{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
