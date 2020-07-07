class Task{
    String descr;
    Task next;
    public Task(String d, Task n){
        this.descr=d;
        this.next=n;
    }
    public Task(String d){
        this.descr=d;
        this.next=null;
    }
    void setNextTask(Task t){this.next = t;}
    void printTasks(){
        Task t = this;
        while(t != null) {
            System.out.println(t);
            t = t.next;
        }
    }
    static void printTasks(Task head){
        Task t = head;
        while(t != null){
            System.out.println(t);
            t = t.next;
        }
    }
    void printTasksRev(){
        printRevRec(this);
    }
    private void printRevRec(Task t){
        if(t != null){
            printRevRec(t.next);
            System.out.println(t);
        }

    }
    static void printTasksRev(Task head){
        printRevRecStat(head);
    }
    private static void printRevRecStat(Task t){
        if(t != null){
            printRevRecStat(t.next);
            System.out.println(t);
        }

    }
    public String toString(){
        return this.descr;
    }
}

public class Main {
    public static void main(String[] args) {
        Task t2 = new Task("Wash the dishes!");
        Task t1 = new Task("Walk the dog!",t2);
        t2.setNextTask(new Task("Clean the room!"));
        Task head = new Task("Get rest!",t1);

        head.printTasks();
        System.out.println();
        head.printTasksRev();
        System.out.println();

        System.out.println();

        Task.printTasks(head);
        System.out.println();
        Task.printTasksRev(head);
        System.out.println();
    }
}
