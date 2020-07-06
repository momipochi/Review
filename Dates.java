public class Dates {
    public static void main(String[] args) {
        int period = pack(2000,2,3,2127,11,29);
        showPeriod(period);
    }

    private static int pack(int fromy,int fromm, int fromd,
                            int toy, int tom, int tod){
        int out = fromy-2000;
        out<<=4;
        out |= fromm;
        out<<=5;
        out |= fromd;
        out<<=7;
        out |= (toy-2000);
        out<<=4;
        out |= tom;
        out<<=5;
        out |= tod;
        return out;
    }
    private static void showPeriod(int period){
        int print = period;
        System.out.println(print & 0b11111);
        print >>=5;
        System.out.println(print & 0b1111);
        print >>=4;
        System.out.println((print & 0b1111111)+2000);
        print >>=7;
        System.out.println(print & 0b11111);
        print >>=5;
        System.out.println(print & 0b1111);
        print >>= 4;
        System.out.println((print & 0b11111)+2000);
    }
}
