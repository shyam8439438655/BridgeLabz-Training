class Person{
    String name;
    int age;
    
    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // copy constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

}
public class PersonInfo {
    public static void main(String[] args) {
        // Create an object using parameterized constructor
        Person person1 = new Person("Alice", 30);
        System.out.println("Person 1 Info:");
        person1.displayInfo();

        System.out.println(); // Just for better readability

        // Create another object using copy constructor
        Person person2 = new Person(person1);
        System.out.println("Person 2 Info :");
        person2.displayInfo();
    }
}
