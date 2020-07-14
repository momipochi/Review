
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class ByteReader implements Runnable{
    int i;
    ByteThreads bt;
    ByteReader(int i, ByteThreads bt){
        this.i=i;
        this.bt=bt;
    }

    @Override
    public void run() {
        try{
            InputStream is = Files.newInputStream(Paths.get(ByteThreads.iFileName));
            int n;
            while((n = is.read()) != -1){
                if(n == this.i){
                    System.out.println("Threads for: "+ i + " completed with count: " + bt.countAll);
                    bt.countAll++;
                }
            }
            bt.counter--;
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

public class ByteThreads extends Thread {
    final static String iFileName = "Majas.jpg";

    int countAll = 0;
    int counter = 256;

    public static void main(String[] args) {
        new ByteThreads().start();
    }
    ByteThreads(){
        for(int i = 0;i<256;i++){
            new Thread(new ByteReader(i,this)).start();
        }
    }
    public void run(){
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        if(counter == 0){
            try{
                System.out.println("CountAll: " + countAll);
                System.out.println("FileSize: "+ Files.size(Paths.get(iFileName)));
            }catch(IOException e){
                e.printStackTrace();
            }
            return;
        }
    }
}
