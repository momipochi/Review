import java.util.ArrayList;
import java.util.List;

class Person{
    private String name;
    private Account acc;
    public Person(String n, Account a){
        name = n;
        acc = a;
    }
    public static List<Person> theRich(Person[] arr,
                                       int threshold){
        List<Person> lp = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            if(arr[i].acc.getBal() >= threshold){
                lp.add(arr[i]);
            }
        }
        return lp;
    }
    public String toString(){
        return name +acc;
    }
}
class Account{
    private String id;
    private int bal;
    public Account(String id, int b){
        this.id = id;
        bal = b;
    }
    int getBal(){return this.bal;}
    public String toString(){
        return "("+id+":"+bal+")";
    }
}

public class PersonList2 {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("John",
                        new Account("jh", 10000)),
                new Person("Mary",
                        new Account("mr", 30000)),
                new Person("Alice",
                        new Account("al", 15000)),
                new Person("Cindy",
                        new Account("ci", 11000))
        };
        System.out.println(
                Person.theRich(arr, 12000));
    }
}
