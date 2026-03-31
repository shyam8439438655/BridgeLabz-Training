interface Worker {
    void performDuties();
}
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is preparing " + specialty + " dishes.");
    }
}
class Waiter extends Person implements Worker {
    String section;

    Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving customers in the " + section + " section.");
    }
}
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 1, "Italian");
        Waiter waiter = new Waiter("John Doe", 2, "A1");

        chef.performDuties();
        waiter.performDuties();
    }
}
