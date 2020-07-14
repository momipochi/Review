import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

class Student{
    String n;
    String id;
    int num;
    Student(String n, String id, int num){
        this.n=n;
        this.id=id;
        this.num=num;
    }
    public String toString(){
        return n + id + num;
    }
}

public class Main {
    public static void main(String[] args) {
        try{
            Files.lines(Paths.get("students.txt"))
                    .map(x->{
                                String[] str = x.split("\\s");
                                return new Student(str[0],str[1],Integer.parseInt(str[2]));
                            }
                    )
                    .collect(Collectors.groupingBy(x->x.id))
                    .entrySet()
                    .stream()
                    .forEach(x-> System.out.println(x.getKey()+""+x.getValue()));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
