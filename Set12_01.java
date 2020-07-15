

import java.util.ArrayList;
import java.util.List;

class SubThread extends Thread{
    char c;
    boolean sus = false;
    public SubThread(char c){
        this.c=c;
    }
    public void run(){
        while(true){
            try{
                Thread.sleep((int)(Math.random()*900)+100);
                while(sus){
                    synchronized (this){
                        wait();
                    }
                }
                System.out.print("" + this.c);
            }catch(InterruptedException e){
                System.out.println("threads terminated" + this.c);
                return;
            }
        }
    }
    synchronized void pause(){sus=true;}
    synchronized void resumeThread(){sus=false; notify();}
}

public class MainThread extends Thread implements Runnable{
    public static void main(String[] args) {
        new MainThread().start();
    }
    List<SubThread> lst;
    MainThread(){
        lst = new ArrayList<SubThread>();
        lst.add(new SubThread('a'));
        lst.get(0).pause();
        lst.add(new SubThread('b'));
        lst.add(new SubThread('c'));
        lst.add(new SubThread('d'));
        lst.add(new SubThread('e'));
        for(SubThread sb:lst){
            sb.start();
        }
    }
    public void run(){
        int i = 0;
        int count = 1;
        while(true){
            try{
                Thread.sleep(5000);
                System.out.println();
                System.out.print("Resuming " + lst.get(i).c + ", suspending "
                        + lst.get((i+1) %lst.size()).c + ": ");
                lst.get(i).resumeThread();
                i=(i+1)%lst.size();
                lst.get(i).pause();
                if(count == 2){
                    for(SubThread sb:lst){
                        sb.interrupt();
                    }
                    throw new InterruptedException("process finished");
                }
                if(i==0){
                    count++;
                }
            }catch(InterruptedException e){
                System.out.println(e);
                return;
            }
        }
    }
}
