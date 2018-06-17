/*Design a temperature class for nurses to store patient temperature and the method of taking the temperature.
How would you handle different units of temperature? Write a function to determine if a patient has a fever.*/

class Temperature3
{
    private double temperature;

    public void setTemperature(double temp)
    {
        temperature=temp;
    }

    public double getTemperature()
    {
        return temperature;
    }

}

class Celsius3 extends Temperature3
{
    public Celsius3(double temp)
    {
        setTemperature(temp);
    }

    public double toFahrenheit()
    {
        return ((double)9/5)*getTemperature()+32;
    }
}

class Fahrenheit3 extends Temperature3
{
    public Fahrenheit3(double temp)
    {
        setTemperature(temp);
    }

    public double toCelsius()
    {
        return ((double)5/9)*(getTemperature()-32);
    }
}

class Thermometer3
{
    public Temperature3 checkTemperature(Patient3 p)
    {
        return p.getTemperature();
    }
}

class Nurse3
{
    private String name;
    private Thermometer3 thermometer;

    public Nurse3(String n)
    {
        name=n;
        thermometer=new Thermometer3();
    }

    public Temperature3 measureTemperature(Patient3 p) // here also we will pass location as a parameter
    {
        return thermometer.checkTemperature(p);
    }

    public boolean patientHasFever(Patient3 p)  // we will pass additional location as a parameter
    {
        Temperature3 t=measureTemperature(p);   // switch case on location and depending on various locations we can have different threshold values
        if(t instanceof Celsius3)
        {
            if(t.getTemperature()>38.0)
                return true;
            return false;
        }
        else
        {
            if(t.getTemperature()>100.0)
                return true;
            return false;
        }
    }
}

class Patient3
{
    private Temperature3 temperature;

    public Patient3(Temperature3 temp)
    {
        temperature=temp;
    }

    public void setTemperature(Temperature3 temp)
    {
        temperature=temp;
    }

    public Temperature3 getTemperature()
    {
        return temperature;
    }

}

public class Hospital {

    public static void main(String[] args) {
        Nurse3 nurse=new Nurse3("Alisha");
        Patient3 patient=new Patient3(new Celsius3(28));
        System.out.println(nurse.patientHasFever(patient));

    }

}


/* For location we can declare an enum, and use it in the patientHasFever() method, along with patient as a parameter. and for patient we can create 3 different temperature variables for different body part*/