/*
PS1:

Design a Temperature class to know whether patient has fever or not and in what location is the reading taken such as mouth, armpit, ear.
Default temperatures: 0.0º or 32.0F.
Convert Celsius to Fahrenheit.
Convert Fahrenheit to Celsius.
Update default temperature.

PS2:

Design a temperature class for nurses to store patient temperature and the method of taking the temperature.
How would you handle different units of temperature? Write a function to determine if a patient has a fever.
*/

import java.util.Scanner;

public class Temperature {

    private enum Location{
        MOUTH,EAR,ARMPIT;
    }
    private Location location;
    private double temperature;

    public  Temperature()
    {
        temperature=0;
    }

    public void setLocation(String location)
    {
        this.location=Location.valueOf(location);
    }

    public double getDefaultTemperature()
    {

        return temperature;
    }

    public void updateDefaultTemperatureInCelsius(double celsius)
    {
        temperature=celsius;
    }

    public Location getLocation()
    {
        return location;
    }

    public double getCelsiusToFahrenheit(double celsius)
    {
        return ((double)9/5)*celsius+32;
    }

    public double getFahrenheitToCelsius(double fahrenheit)
    {
        return ((double)5/9)*(fahrenheit-32);
    }

    public String hasFever(double celsius)
    {
        if(celsius>38.0)
            return "Fever present";
        return "No Fever";
    }

    public static void main(String[] args)
    {
        Temperature temp=new Temperature();
        while(true)
        {
            System.out.println("MENU:");
            System.out.println("Default Temperature: "+temp.getDefaultTemperature()+"C OR "+temp.getCelsiusToFahrenheit(temp.getDefaultTemperature())+"F");
            System.out.printf("1.Convert celsius to Fahrenheit \n2.Convert Fahrenheit to Celsius \n3.Update default temperature (In Celsius) \n");
            System.out.println("Enter choice");
            Scanner scan=new Scanner(System.in);
            int choice=scan.nextInt();
            switch(choice)
            {
                case 1: System.out.println("Enter temperature in Celsius ");
                        double celsius=scan.nextDouble();
                        double result=temp.getCelsiusToFahrenheit(celsius);
                        System.out.println("Result : "+result);
                        System.out.println(temp.hasFever(celsius));
                        break;

                case 2: System.out.println("Enter temperature in Fahrenheit ");
                        double fahrenheit=scan.nextDouble();
                        result=temp.getFahrenheitToCelsius(fahrenheit);
                        System.out.println("Result : "+result);
                        System.out.println(temp.hasFever(result));
                        break;

                case 3: System.out.println("Enter temperature in Celsius ");
                        celsius=scan.nextDouble();
                        temp.updateDefaultTemperatureInCelsius(celsius);
                        result=temp.getDefaultTemperature();
                        System.out.println("Result : "+result);
                        break;

                default:System.out.println("Invalid Input");
                        System.exit(0);
            }

        }


    }


}
