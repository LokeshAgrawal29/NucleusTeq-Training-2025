// Q2 Implement inheritance to create a "GraduateStudent" class that extends the "Student" class with additional features.

class Student {
    String name;
    int rollNumber;
    double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}

class GraduateStudent extends Student {
    String researchTopic;

    public GraduateStudent(String name, int rollNumber, double marks, String researchTopic) {
        super(name, rollNumber, marks);
        this.researchTopic = researchTopic;
    }

    public void displayGraduateDetails() {
        displayDetails();
        System.out.println("Research Topic: " + researchTopic);
    }

    public static void main(String[] args) {
        GraduateStudent gradStudent = new GraduateStudent("Lokesh", 502, 95, "Machine Learning");
        gradStudent.displayGraduateDetails();
    }
}
