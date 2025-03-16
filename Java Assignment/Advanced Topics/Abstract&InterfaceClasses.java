// Q1 Explain the concept of interfaces and abstract classes with examples.

//    Abstract Class
// 1) An abstract class is a class that cannot be instantiated.
// 2) It can have both abstract (unimplemented) and concrete (implemented) methods.
// 3) It is used when multiple related classes share common behavior but also have some differences.
// 4)It supports constructors.

// Example of Abstract Class

abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract void makeSound(); // Abstract method (must be implemented by subclasses)

    public void displayInfo() { // Concrete method (already implemented)
        System.out.println("Animal Name: " + name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " barks.");
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy");
        myDog.displayInfo(); // Calls concrete method
        myDog.makeSound();   // Calls overridden method
    }
}

//    InterFace Class 
// 1) An interface is a collection of abstract methods (default methods are allowed from Java 8).
// 2) It cannot contain instance variables (only constants final static variables).
// 3) It is used to achieve 100% abstraction.
// 4) A class can implement multiple interfaces (but can only extend one abstract class).

// Example of Interface Class

interface Animal {
    void makeSound(); // Abstract method (must be implemented)
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows.");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Cat myCat = new Cat();
        myCat.makeSound(); // Calls implemented method
    }
}
