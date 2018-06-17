import java.util.Scanner;

public class TemperatureExample {
    public static void main(String[] args)
    {
        System.out.println("Enter a temperature value in Fahrenheit:");
        Scanner scan=new Scanner(System.in);
        Temperature temp=null;
        if(scan.hasNextDouble())
            temp=new Temperature(scan.nextDouble());
        double celsius=temp.getCelsius();
        System.out.println("Temperature in Celsius: "+celsius);
        System.out.printf("Temp in Celsius(rounded to 2 decimal places): %.2f\n",celsius);
        double kelvin=temp.getKelvin();
        System.out.println("Temperature in Kelvin: "+kelvin);
        System.out.printf("Temp in Kelvin(rounded to 2 decimal places): %.2f\n",kelvin);

    }
}

class Temperature
{
    private double ftemp;

    public Temperature(double temperature)
    {
        this.ftemp=temperature;
    }

    public void setFahrenheit(double temperature)
    {
        this.ftemp=temperature;
    }

    public double getFahrenheit()
    {
        return this.ftemp;
    }

    public double getCelsius()
    {
        double celsius=(5.0/9.0)*(this.getFahrenheit()-32.0);
        return celsius;
    }

    public double getKelvin()
    {
        double kelvin=((5.0/9.0)*(this.getFahrenheit()-32.0))+273.0;
        return kelvin;
    }


}
