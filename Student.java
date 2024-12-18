class Student {
    private String id; // Keep as String
    private String name;
    private double marks;

    public Student(String id, String name, double marks) { // Constructor remains the same
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Marks=" + marks + "]";
    }
}