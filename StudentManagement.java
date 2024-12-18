public class StudentManagement {
    private StudentStack students;

    public StudentManagement() {
        this.students = new StudentStack();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.push(student);
    }

    // Update an existing student's details
    public void updateStudent(int id, String newName, double newMarks) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() == id) {
                tempStack.push(new Student(id, newName, newMarks));
                found = true;
            } else {
                tempStack.push(student);
            }
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        StudentStack tempStack = new StudentStack();

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() != id) {
                tempStack.push(student);
            }
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
    }

    // Search for a student by ID
    public Student searchStudent(int id) {
        StudentStack tempStack = new StudentStack();
        Student foundStudent = null;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() == id) {
                foundStudent = student;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        return foundStudent;
    }

    // Display all students
    public void displayStudents() {
        StudentStack tempStack = new StudentStack();
        while (!students.isEmpty()) {
            Student student = students.pop();
            System.out.println(student);
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
    }
}
