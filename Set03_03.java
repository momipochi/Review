import java.util.Arrays;

@FunctionalInterface
interface SFilter{
    boolean test(String str);
    public static String[] filter(String[] arr, SFilter filt){
        int count=0;
        for(int i = 0;i<arr.length;i++){
            if(filt.test(arr[i])){
                count++;
            }
        }
        String[] str = new String[count];
        int k = 0;
        for(int i = 0;i<arr.length;i++){
            if(filt.test(arr[i])){
                str[k] = arr[i];
                k++;
            }
        }
        return str;
    }
}

class LenFilter implements SFilter{
    int minLen;
    public LenFilter(int len){
        this.minLen = len;
    }

    @Override
    public boolean test(String str) {
        return str.length() >= minLen;
    }
}

public class StringFilter {
    public static void main(String[] args) {
        String[] arr = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(arr));

        String[] a1 = SFilter.filter(arr, new LenFilter(4));
        System.out.println(Arrays.toString(a1));

        String[] a2 = SFilter.filter(arr, new SFilter() {
            @Override
            public boolean test(String str) {
                return str.charAt(0) <= 'D' && str.charAt(0) >= 'A';
            }
        });
        System.out.println(Arrays.toString(a2));

        String[] a3 = SFilter.filter(arr, x->x.charAt(0) >= 'H' && x.charAt(0) <= 'Z');
        System.out.println(Arrays.toString(a3));
    }
}
