interface Func{
    double apply(double x);
    static Func compose(Func f, Func g){
        return new Function(f,g);
    }
}

class Function implements Func{
    private Func f1;
    private Func f2;
    Function(Func f1, Func f2){
        this.f1=f1;
        this.f2=f2;
    }
    public double apply(double x){
        return f1.apply(f2.apply(x));
    }
}

public class InterF {
    public static void main(String[] args) {
        Func f = x -> x*x;
        Func g = x -> x+1;
        Func cmp1 = Func.compose(f, g);
        Func cmp2 = Func.compose(g, f);
        System.out.println("Res1: " + cmp1.apply(3));
        System.out.println("Res2: " + cmp2.apply(3));
    }
}
