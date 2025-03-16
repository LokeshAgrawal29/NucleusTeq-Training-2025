// Q3 Demonstrate polymorphism by creating methods with the same name but different parameters in a parent and child class.

class Student {
    String name;
    int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }

    public void displayDetails(String course) { 
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
    }
}

class GraduateStudent extends Student {
    double marks;

    public GraduateStudent(String name, int rollNumber, double marks) {
        super(name, rollNumber);
        this.marks = marks;
    }

    @Override
    public void displayDetails() { 
        super.displayDetails();
        System.out.println("Marks: " + marks);
    }

    public static void main(String[] args) {
        Student student1 = new Student("Lokesh", 502);
        GraduateStudent gradStudent = new GraduateStudent("Lokesh", 502, 95);

        student1.displayDetails(); 
        student1.displayDetails("Computer Science"); 

        gradStudent.displayDetails(); 
    }
}
