
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
    private String name;
    Person(String n){name = n;}
    public String toString(){return name;}
}

public class StreamNames {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "john","al","KENNY","jenny","noemi"
        );
        System.out.println(getPersons(list));
    }
    static List<Person> getPersons(List<String> list){
        return list.stream()
                .filter(x->x.length()>3)
                .map(x->x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase())
                .sorted(String::compareToIgnoreCase)
                .map(Person::new)
                .limit(3)
                .collect(Collectors.toList());
    }
}
