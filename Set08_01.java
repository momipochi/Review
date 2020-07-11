import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Person{
    private String name;
    private int yob;
    private Car car;
    public Person(String n, int yob){
        name = n;
        this.yob=yob;
        car = null;
    }
    public Person(String n, int yob, Car c){
        name = n;
        this.yob=yob;
        car = c;
    }
    public static List<Car> findAllCars(List<Person> lp){
        List<Car> lc = new ArrayList<>();
        for(Person p:lp){
            if(p.car != null){
                lc.add(p.car);
            }
        }
        return lc;
    }
    public static List<Person> findOwners(List<Person> list, String cn){
        List<Person> lp= new ArrayList<>();
        int count = 0;
        for(Person p:list){
            if(p.car!= null && p.car.getName().equalsIgnoreCase(cn)){
                lp.add(p);
                count++;
            }
        }
        return lp.subList(0,count);
    }
    public static Color findColor(List<Person> list, String name, int year){
        Color c = new Color(0,0,0);
        for(Person p:list){
            if(p.car != null
                    && p.name.equalsIgnoreCase(name)
                    && p.yob == year){
                c = p.car.getColor();
            }
        }
        return c;
    }
    public String toString(){
        return name + yob + car;
    }
}
class Car{
    private String name;
    private Color color;
    public Car(String n, Color c){
        name = n;
        color = c;
    }
    String getName(){return this.name;}
    Color getColor(){return this.color;}
    public String toString(){
        return name + color.getRed() +" "+color.getGreen()+" "+color.getBlue();
    }
}
public class Main {
    public static void main(String[] args) {
        try{
            File file = new File("note.txt");
            Scanner sc = new Scanner(file);
            List<Person> lp = new ArrayList<Person>();
            while(sc.hasNextLine()){
                String[] str = sc.nextLine().split("\\s");
                if(str.length == 6){
                    lp.add(
                            new Person(str[0]
                            ,Integer.parseInt(str[1])
                            ,new Car(str[2],
                                    new Color(Integer.parseInt(str[3]),
                                    Integer.parseInt(str[4]),
                                    Integer.parseInt(str[5]))))
                    );
                }else{
                    lp.add(new Person(str[0],Integer.parseInt(str[1])));
                }
            }
            System.out.println(Person.findAllCars(lp));
            System.out.println(Person.findOwners(lp,"Skoda"));
            System.out.println(Person.findColor(lp, "Alice", 1993));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
