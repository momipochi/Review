interface Reversible {
    Reversible revers();
}

class ReversibleString implements Reversible{
    private String str;
    ReversibleString(String str){
        this.str=str;
    }
    public String toString(){
        return str;
    }
    public Reversible revers(){
        String tmp = "";
        for(int i = 0;i<str.length();i++){
            tmp = str.charAt(i) + tmp;
        }
        str = tmp;
        return this;
    }
}
class ReversibleDouble implements Reversible{
    private double d;
    ReversibleDouble(double d){
        this.d=d;
    }

    public String toString(){
        return ""+d;
    }
    @Override
    public Reversible revers() {
        d = 1/d;
        return this;
    }
}
public class ReversibleTest {
    public static void main(String[] args) {
        Reversible[] revers = new Reversible[] {
                new ReversibleString("Cat"),
                new ReversibleDouble(2),
                new ReversibleDouble(3),
                new ReversibleString("Dog"),
                new ReversibleString("Alice in Wonderland"),
                new ReversibleDouble(10),
        };

        System.out.println("Original:");
        for (Reversible r : revers) System.out.println(r);

        for (Reversible r : revers) { r.revers(); }

        System.out.println("Reversed:");
        for (Reversible r : revers) System.out.println(r);

        System.out.println("Reversed again and modified:");
        for (Reversible r : revers) {
            r.revers();
            System.out.println(r);
        }
    }
}
