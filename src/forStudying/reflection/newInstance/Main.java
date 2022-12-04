package forStudying.reflection.newInstance;

import forStudying.reflection.newInstance.rr.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getSubClassOne());
    }

    public SubClassOne getSubClassOne() {
//        return new InstanceProvider<SubClassOne>().giveName(); // does not work
        return new InstanceProvider<SubClassOne>(){
            @Override
            public SubClassOne getGenericTypeObject() {
                return super.getGenericTypeObject();
            }
        }.giveName();

    }
}
