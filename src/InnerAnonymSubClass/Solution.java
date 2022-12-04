package InnerAnonymSubClass;

/* 
Напряги извилины!
package com.javarush.task.task23.task2310;
*/

public class Solution {
    private String name;

    Solution(String name) {
        System.out.println("Object: " + Integer.toHexString(this.hashCode()) + "  in constructor " + getClass());
        this.name = name;
    }

    private String getName() {
        System.out.println("Object: " + Integer.toHexString(this.hashCode()) + "  in private String getName()");
        return name;
    }

    protected String getProtectedName() {
        System.out.println("Object: " + Integer.toHexString(this.hashCode()) + "  in protected String getProtectedName()");
        return name;
    }

    private void sout() {
        /*
        * У нас классы находятся сразу в 2 связях - внешний/внутренний, родитель/наследник
Благодаря тому что он внутренний, анонимный класс видит приватные методы/поля родителя.
* */
        new Solution("The Darkside Hacker") {
            void printName() {
                System.out.println(getName());
                System.out.println(super.getName());
                System.out.println(getProtectedName());
                System.out.println(super.getProtectedName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("Риша").sout();
    }
}
