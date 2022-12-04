package forStudying.reflection.newInstance;

import forStudying.reflection.newInstance.rr.SuperClass;

import java.lang.reflect.ParameterizedType;

public class InstanceProvider<T extends SuperClass> {
    public T giveName(){
        T result = null;
        try {
            result = getNewInstanceOfGenericType();
            result.name = "name from InstantProvider";
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public T getGenericTypeObject() {
        T obj = null;
        try {
            obj = getNewInstanceOfGenericType();
//            obj.name = giveName();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public T getNewInstanceOfGenericType() throws InstantiationException, IllegalAccessException {
        return (T) ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
    }
}
