@FunctionalInterface
interface FunDD{
    double fun(double x);
    static double xminim(FunDD f, double a, double b){
        double ymin = f.fun(a);
        double xmin = a;
        for(double i = a;i>=a && i <=b; i+=1e-5){
            if(f.fun(i) < ymin){
                ymin = f.fun(i);
                xmin = i;
            }
        }
        return xmin;
    }
}

class Parabola implements FunDD{
    double a;
    double b;
    double c;
    public Parabola(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    @Override
    public double fun(double x) {
        return (a*(x*x))+(b*x)+c;
    }
}

public class Main {
    public static void main(String[] args) {
        Parabola p1 = new Parabola(1,-1,5/4);
        System.out.println(FunDD.xminim(p1,0,1));

        System.out.println(
                FunDD.xminim(new Parabola(1,0.76,1){
                    @Override
                    public double fun(double x){
                        return Math.sqrt(Math.pow((a*x-b),2)+c);
                    }
                },0,2));
        System.out.println(
                FunDD.xminim((x->(Math.pow(x,2))*(x-2)),0,2)
        );
    }
}
