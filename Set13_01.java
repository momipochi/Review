import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Letters implements Iterable<Thread>{
    List<Thread> ll;
    boolean suspended;
    Letters(String letters){
        ll = new ArrayList<Thread>();
        for(int i =0;i<letters.length();i++){
            int finalI = i;
            ll.add(new Thread(()->{
                suspended = false;
                char c = letters.charAt(finalI);
                while(true){
                    try{
                        System.out.print(c+"");
                        Thread.sleep(1000);
                        while(suspended){
                            synchronized (this){
                                wait();
                            }
                        }
                    }catch (InterruptedException e){
                        return;
                    }
                }
            },"Thread " +letters.charAt(i)));
        }
    }

    @Override
    public Iterator<Thread> iterator(){
        return ll.iterator();
    }


    public void start() {
        for(Thread l:ll){
            l.start();
        }
    }

    public void stop() {
        for(Thread l:ll){
            l.interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Letters l = new Letters("ABCD");
        for(Thread t:l){
            System.out.println(t.getName() + "starting");
        }
        l.start();
        try { Thread.sleep(5000); }
        catch(InterruptedException e){ }
        l.stop();
        System.out.println("\nProgram completed.");
    }
}
