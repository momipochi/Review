import java.util.Arrays;
import java.util.Comparator;

class MyComp implements Comparator<Integer>{
    public static final int BY_VAL=0, BY_VAL_REV=1,
                            BY_NUM_OF_DIVS=2,BY_SUM_OF_DIGS=3;
    int val;
    MyComp(int val){
        this.val=val;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        switch (val){
            case BY_VAL:
                return o1-o2;
            case BY_VAL_REV:
                return o2-o1;
            case BY_NUM_OF_DIVS:
                int counto1 =0;
                for(int i = 1;i<o1;i++){
                    if(o1%i==0){
                        counto1++;
                    }
                }
                int counto2 = 0;
                for(int i = 1;i<o2;i++){
                    if(o2%i==0){
                        counto2++;
                    }
                }
                int result = counto1-counto2;
                if(result == 0){
                    return o1-o2;
                }
                return result;
            case BY_SUM_OF_DIGS:
                int out=0, tmpo1=0,tmpo2=0;
                while(o1>0){
                    tmpo1+=o1%10;
                    o1/=10;
                }
                while(o2>0){
                    tmpo2+=o2%10;
                    o2/=10;
                }
                out = tmpo1-tmpo2;
                if(out == 0){
                    return o1-o2;
                }
                return out;
            default: throw new IllegalArgumentException();
        }
    }
}

public class Compars {
    public static void main(String[] args) {
        Integer[] a = {1,5,33,12,98,15};
        printTable("Original    ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_VAL));
        printTable("ByVal       ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_VAL_REV));
        printTable("ByValRev    ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_NUM_OF_DIVS));
        printTable("ByNumOfDivs ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_SUM_OF_DIGS));
        printTable("BySumOfDigs ", a);
    }

    static void printTable(String mess, Integer[] a) {
        System.out.print(mess + "[ ");
        for (int d : a) System.out.print(d + " ");
        System.out.print("]\n");
    }

}
