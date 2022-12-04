package InnerAnonymSubClass;

public class Test {
    private String name;

    Test(String name) {
        this.name = name;
        String[] className = this.toString().split("\\.");
        System.out.printf("in the constructor 'Test()' is the object: %-25swith the field 'String name': %s%n",
                className[className.length-1] , name);
    }

    private String getName() {
        return name;
    }

    private void sout() {
        new Test("The Darkside Hacker") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();

        class subTest extends Test {
            subTest(String name) {
                super(name);
                String[] className = this.toString().split("\\.");
                System.out.printf("in the constructor 'Test()' is the object: %-25swith the field 'String name': %s%n",
                        className[className.length-1] , name);
            }
        }
        Test st = new subTest("subtest");
        System.out.println(st.getName());
    }

    public static void main(String[] args) {
        new Test("Риша").sout();
    }
}