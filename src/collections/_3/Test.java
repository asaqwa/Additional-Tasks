package collections._3;

import java.util.List;

public class Test {
    static <E extends Number> List<E> process(List<E> nums) {return nums;}

    public static void main(String[] args) {
//        ArrayList<Integer> input = null; List<Integer> output = null;
//        List<Integer> input = null; List<Integer> output = null;
        List<Number> input = null; List<Number> output = null;

        output = process(input);
    }
}
