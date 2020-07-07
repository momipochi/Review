public class SimpleArrayList {
    private final static int INITIAL_CAPACITY = 5;
    private int cap = INITIAL_CAPACITY;
    private int size = 0;
    private int[] arr = new int[cap];

    public SimpleArrayList(){
        this.size = size;
        this.cap = INITIAL_CAPACITY;
        this.arr = new int[cap];
    }

    public SimpleArrayList(int a){
        this.size=1;
        this.cap = INITIAL_CAPACITY;
        this.arr = new int[cap];
        this.arr[0] = a;
    }

    public SimpleArrayList(int[] a){
        this.size = a.length;
        this.cap = size*2;
        this.arr = new int[cap];
        System.arraycopy(a,0,this.arr,0,a.length);
    }

    public SimpleArrayList(SimpleArrayList a){
        this.size = a.size;
        this.cap = a.cap;
        this.arr = new int[a.cap];
        System.arraycopy(a.arr,0,this.arr,0,a.size);
    }

    int size(){return this.size;}
    void clear(){
        this.size = 0;
        this.cap = INITIAL_CAPACITY;
        this.arr = new int[cap];
    }
    void trim(){
        this.cap = this.size;
        int[] tmp = this.arr;
        this.arr = new int[cap];
        System.arraycopy(tmp,0,this.arr,0,this.arr.length);
    }
    public SimpleArrayList insert(int ind, int[] other){
        if(ind > this.size || ind < 0){
            throw new IndexOutOfBoundsException("Out of bound");
        }
        if((this.size+other.length) >= this.cap){
            this.cap = (size+other.length)*2;
            int[] tmp = new int[cap];
            System.arraycopy(this.arr,0,tmp,0,this.arr.length);
            this.arr = new int[cap];
            System.arraycopy(tmp,0,this.arr,0,cap);
        }
        int[] tmp = new int[other.length];
        System.arraycopy(this.arr,ind,tmp,0,other.length);
        System.arraycopy(other,0,this.arr,ind,other.length);
        System.arraycopy(tmp,0,this.arr,ind+other.length, other.length);
        this.size += other.length;
        return this;
    }
    public SimpleArrayList insert(int ind, int e){
        return insert(ind, new int[]{e});
    }
    public SimpleArrayList append(int e){
        return insert(this.size, e);
    }
    public SimpleArrayList append(int[] a){
        return insert(this.size,a);
    }
    public SimpleArrayList append(SimpleArrayList a){

        int[] tmp = new int[a.size];
        for(int i=0;i<size;i++){
            tmp[i] = a.arr[i];
        }
        return insert(this.size,tmp);
    }

    public int get(int ind){
        if(ind > this.size || ind < 0){
            throw new IndexOutOfBoundsException("Out of bound");
        }
        return this.arr[ind];
    }

    public SimpleArrayList set(int ind, int val){
        if(ind > this.size || ind < 0){
            throw new IndexOutOfBoundsException("Out of bound");
        }
        this.arr[ind] = val;
        return this;
    }

    public String toString(){
        String str = "";

        for(int i = 0; i<size; i++){
            str+=" " +arr[i];
        }
        return "Cap= " +this.cap+", size=" +this.size+": [" +str+" ]";
    }

    public static void main(String[] args) {
        SimpleArrayList a =
                new SimpleArrayList()
                        .append(new int[]{1,3}).insert(1,2)
                        .append(6).insert(3,new int[]{4,5});

        SimpleArrayList b = new SimpleArrayList(a);
        for (int i = 0; i < a.size(); ++i)
            a.set(i,a.get(i)+6);
        b.append(a).append(13).trim();
        System.out.println("a -> " + a);
        System.out.println("b -> " + b);
    }
}
