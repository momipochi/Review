import java.util.Iterator;

class Hailstone implements Iterator<Integer>, Iterable<Integer> {
    int a;
    Hailstone(int ini){
        a = ini*2;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return a != 1;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            if(a % 2 == 0){
                a/=2;
            }else{
                a=3*a+1;
            }
        }
        return a;
    }
}
public class Main {
    public static void main(String[] args) {
        int ini = 10, count = -1, maxel = 0;
        Hailstone hailstone = new Hailstone(ini);
        for(int h : hailstone){
            if(h > maxel){
                maxel = h;
            }
            ++count;
        }
        System.out.println(ini+" "+count+" "+maxel);
    }
}
