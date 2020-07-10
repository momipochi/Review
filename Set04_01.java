abstract class Singer{
    private String name;
    private int num;
    private static int singers;

    public Singer(String n){
        name = n;
        num= ++singers;
    }
    abstract String sing();
    public static Singer loudest(Singer[] s){
        Singer max = s[0];
        int loudest = countCap(max.sing());
        for(int i = 0;i<s.length; i++){
            if(loudest < countCap(s[i].sing())){
                max = s[i];
            }
        }
        return max;
    }
    private static int countCap(String s){
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                count++;
            }
        }
        return count;
    }
    public String toString(){
        return "("+num+") "+name +" "+ sing();
    }
}

public class Main {
    public static void main(String[] args) {
        Singer s1 = new Singer("Martin"){
            String sing(){
                return "Arrivederci, Roma...";
            }
        };

        Singer s2 = new Singer("Joplin"){
            String sing(){
                return "...for me and my Bobby MacGee";
            }
        };

        Singer s3 = new Singer("Houston"){
            String sing(){
                return "I will always love youuuu";
            }
        };

        Singer sng[] = {s1, s2, s3};
        for (Singer s : sng) System.out.println(s);
        System.out.println("\n" + Singer.loudest(sng));
    }
}
