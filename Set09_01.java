import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMod {
    public static void main(String[] args) {
        Random r = new Random();
        final int N = 10_000_000, M = 4;
        Stream.generate(r::nextInt)
                .limit(N)
                .collect(Collectors.groupingBy(e->Math.abs(e)%M))
                .entrySet()
                .stream()
                .forEach(e-> System.out.println(e.getKey()+"->"+e.getValue().size()/(double)N));
    }
}
