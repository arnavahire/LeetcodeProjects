/*
Person Demographic Problem to store information about every person.
*/
public class Person {
    private String name;
    private int age;
    private String gender;
    private Address address;
    private static int population=0;

    public Person(String name,int age,String gender,String address)
    {
        this.name=name;
        this.age=age;
        this.gender=gender;
        String[] splits=address.split("\\s+");
        Address add=new Address(splits[0],splits[1],splits[2],splits[3],splits[4],Long.parseLong(splits[5]));
        this.address=add;
        population++;
    }

    public String getName() {
        return name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(Address address)
    {
        this.address=address;
    }

    public Address getAddress()
    {
        return address;
    }

    public int getPopulation()
    {
        return population;
    }


}

class Address
{
    private String country;
    private String state;
    private String city;
    private String street;
    private String zipCode;
    private long phoneNo;

    public Address(String country,String state,String city,String street,String zipCode,long phoneNo)
    {
        this.country=country;
        this.state=state;
        this.city=city;
        this.zipCode=zipCode;
        this.phoneNo=phoneNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipCode;
    }

    public void setZipcode(String zipcode) {
        this.zipCode = zipcode;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }


    public static void main(String[] args)
    {
        Person p=new Person("Arnav",25,"Male","US NY Buffalo Maple 123456 987654321 ");
        Person p2=new Person("Malika",25,"Female","US NY Buffalo Merrimac 123411 987654334 ");
        Person p3=new Person("Shruti",25,"Female","US NY Buffalo Englewood 123336 987654355 ");

        System.out.println(p3.getName()+" "+p3.getAddress().getCity());

    }
}
