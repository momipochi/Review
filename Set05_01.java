import java.util.Arrays;
import java.util.Comparator;

enum Sex{F,M};
enum Size{XS,S,M,L,XL};
enum Country{PL{
    @Override
    public String toString() {
        return "Polska";
    }
},NL{
    @Override
    public String toString() {
        return "Nederland";
    }
},DE{
    @Override
    public String toString() {
        return "Deutschland";
    }
}}

class Person{
     String name;
     Sex sex;
     Size size;
     Country country;
    public Person(String n, Sex s, Size sz, Country ct){
        name = n; sex = s; size = sz; country = ct;
    }
    public String toString(){
        return name+"("+sex+", "+size+", "+country+")";
    }
}
public class EnumsLamdas {
    static<T> void printArray(String s, T[] p){
        System.out.println("***"+s+"***");
        for(int i = 0;i<p.length;i++){
            System.out.println(p[i]);
        }
    }
    public static void main(String[] args) {
        Person[] persons = {
                new Person("Max",  Sex.M, Size.XL, Country.NL),
                new Person("Jan",  Sex.M, Size.S,  Country.PL),
                new Person("Eva",  Sex.F, Size.XS, Country.NL),
                new Person("Lina", Sex.F, Size.L,  Country.DE),
                new Person("Mila", Sex.F, Size.S,  Country.DE),
                new Person("Ola",  Sex.F, Size.M,  Country.PL),
        };

        Comparator<Person> sexThenSize = (p1,p2)->{
            int result = p1.sex.ordinal() - p2.sex.ordinal();
            if(result == 0){
                return p1.size.ordinal()-p2.size.ordinal();
            }
            return result;
        };
        Arrays.sort(persons, sexThenSize);
        printArray("Persons by sex and then size", persons);

        Arrays.sort(persons, (p1,p2)->{
            int result = p1.size.ordinal()-p2.size.ordinal();
            if(result == 0){
                return p1.name.compareTo(p2.name);
            }
            return result;
        });
        printArray("Persons by size and then name", persons);

        Country[] countries = Country.values();
        Arrays.sort(countries, (c1,c2)->{
            return c1.toString().compareTo(c2.toString());
        });
        printArray("Countries by name", countries);
    }
}
