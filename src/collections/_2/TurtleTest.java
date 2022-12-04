package collections._2;

import java.util.LinkedHashSet;

class Turtle {
    int size;

    public Turtle(int s) {
        size = s;
    }

    public boolean equals(Object o) {
        return (this.size == ((Turtle) o).size);
    }
    // insert code here
    public int hashCode() { return size/5; }    // var 1 (2 objects in set)

    // метод hashCode не переопределен          // var 2 (3 objects in set)
}

public class TurtleTest {
    public static void main(String[] args) {
        LinkedHashSet<Turtle> t = new LinkedHashSet<Turtle>();
        t.add(new Turtle(1));
        t.add(new Turtle(2));
        t.add(new Turtle(1));
        System.out.println(t.size());
    }
}