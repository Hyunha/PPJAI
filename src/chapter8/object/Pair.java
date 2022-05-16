package chapter8.object;

public class Pair {
	Object[] r = new Object[2];

    public Pair(Object ob1, Object ob2) {
        r[0] = ob1;
        r[1] = ob2;
    }

    public Object get1st(){
        return r[0];
    }

    public Object get2nd(){
        return r[1];
    }
}
