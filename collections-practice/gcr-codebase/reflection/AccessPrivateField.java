import java.lang.reflect.*;

public class AccessPrivateField {

    static class Person {
        private int age = 18; // private field
        @Override public String toString() { return "Person{age=" + age + "}"; }
    }

    public static void main(String[] args) throws Exception {

        Person p = new Person();
        System.out.println("Before: " + p);

        // reflection to access private field
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        // read current value
        int currentAge = (int) ageField.get(p);
        System.out.println("Read private age via reflection: " + currentAge);

        // modify
        ageField.set(p, 25);
        System.out.println("After: " + p);

        // read again
        System.out.println("Read again: " + ageField.get(p));
    }
}
