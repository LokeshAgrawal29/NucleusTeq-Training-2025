// Q4 Explain the concept of encapsulation with a suitable example.

// Encapsulation is one of the four fundamental Object-Oriented Programming (OOP) principles, 
// which means hiding the internal details of a class and restricting direct access to it.

// It is implemented using:

// 1) Private variables (Data hiding)
// 2) Public getter and setter methods (Controlled access)

class Student {
    private String name;  // Private variables (data hiding)
    private int rollNumber;
    private double marks;

    // Constructor
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Getter methods (to access private data)
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getMarks() {
        return marks;
    }

    // Setter methods (to modify private data with validation)
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) { // Validating marks before setting
            this.marks = marks;
        } else {
            System.out.println("Invalid marks! Must be between 0 and 100.");
        }
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }

    public static void main(String[] args) {
        // Creating a Student object
        Student student = new Student("Lokesh", 502, 95);

        // Accessing data using getters
        System.out.println("Student Name (Using Getter): " + student.getName());

        // Modifying data using setters
        student.setMarks(98);
        student.setName("Rahul");

        // Display updated details
        student.displayDetails();
    }
}
