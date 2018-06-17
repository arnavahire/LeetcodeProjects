import java.util.ArrayList;
import java.util.List;

class Allergy {

    private enum Severity
    {
        HIGH,MEDIUM,LOW;
    }

    private String allergyName;
    private Severity severity;

    public void setAllergyName(String allergyName)
    {
        this.allergyName=allergyName;
    }

    public void setSeverity(String severity)
    {
        this.severity=Severity.valueOf(severity);
    }

    public String getAllergyName()
    {
        return allergyName;
    }

    public Severity getSeverity()
    {
        return severity;
    }

    public Allergy(String allergyName,String severity)
    {
        this.allergyName=allergyName;
        this.severity=Severity.valueOf(severity);
    }
}

class Patient
{
    private String name;
    private List<Allergy> allergiesList;

    public Patient()
    {
        allergiesList=new ArrayList<Allergy>();
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void addAllergies(Allergy allergy)
    {
        allergiesList.add(allergy);
    }

    public String getName()
    {
        return name;
    }

    public List<Allergy> getAllergiesList()
    {
        return allergiesList;
    }

}

public class MainClass
{
    public static void main(String[] args)
    {
        Patient p=new Patient();
        p.setName("Arnav");
        Allergy a1=new Allergy("Rashes","HIGH");
        p.addAllergies(a1);
        Allergy a2=new Allergy("Sweat","MEDIUM");
        a2.setAllergyName("Itching");
        a2.setSeverity("MEDIUM");
        p.addAllergies(a2);

        List<Allergy> arnavAllergies=p.getAllergiesList();

        for(int i=0;i<arnavAllergies.size();i++)
        {
            System.out.println(arnavAllergies.get(i).getAllergyName()+" "+arnavAllergies.get(i).getSeverity());
        }

    }
}