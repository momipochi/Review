import java.util.Iterator;

class Roll implements Iterable<Integer>, Iterator<Integer> {
    Integer a,b,c,sum;
    int count;
    boolean timer = false;
    public Roll(){
        a = (int)(Math.random()*6)+1;
        b = 0;
        c = 0;
        sum = 0;
        count = 1;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            c=b;
            b=a;
            a=(int)(Math.random()*6)+1;
            sum = a+b+c;
            if(count == 3){
                timer = true;
            }
            count++;
        }
        return a;
    }

    @Override
    public boolean hasNext() {
        if(sum == 11 && timer){
            return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }
}

public class RollDice {
    public static void main(String[] args) {
        for(int turn = 0; turn < 10; turn++){
            for(Integer i : new Roll()){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
