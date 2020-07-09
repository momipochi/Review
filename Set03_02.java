import java.util.Comparator;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MyColor extends Color implements Comparable<MyColor>{

    public MyColor(int r, int g, int b){
        super(r,g,b);
    }
    public int compareTo(MyColor a){
        return
                (getRed() + getGreen() + getBlue())
                        -
                        (a.getRed() + a.getGreen() + a.getBlue());
    }
    public String toString(){
        return super.toString();
    }
}
enum ColComponent{RED,GREEN,BLUE};
class MyColorCompar implements Comparator<Color>{
    ColComponent col;
    public MyColorCompar(ColComponent col){
        this.col = col;
    }

    @Override
    public int compare(Color o1, Color o2) {
        switch(col){
            case RED:
                return o1.getRed()-o2.getRed();
            case GREEN:
                return o1.getGreen()-o2.getGreen();
            case BLUE:
                return o1.getBlue()-o2.getBlue();
            default: throw new IllegalArgumentException();
        }
    }
}

public class ColorComparing {
    public static void main(String[] args) {
        List<MyColor> list = Arrays.asList(
                new MyColor(  1,  2,  3),
                new MyColor(255,  0,  0),
                new MyColor( 55, 55,100),
                new MyColor( 10,255, 10)
        );
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(
                list, new MyColorCompar(ColComponent.RED));
        System.out.println(list);
        Collections.sort(
                list, new MyColorCompar(ColComponent.GREEN));
        System.out.println(list);
        Collections.sort(
                list, new MyColorCompar(ColComponent.BLUE));
        System.out.println(list);
    }
}
