import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Find Student by ID");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    // Add a student
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = scanner.nextDouble();
                    management.addStudent(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    // Find a student by ID
                    System.out.print("Enter Student ID to search: ");
                    id = scanner.nextInt();
                    Student student = management.searchStudent(id);
                    if (student != null) {
                        System.out.println("Student Found: " + student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    // Update a student's information
                    System.out.print("Enter Student ID to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();
                    management.updateStudent(id, newName, newMarks);
                    break;
                case 4:
                    // Delete a student by ID
                    System.out.print("Enter Student ID to delete: ");
                    id = scanner.nextInt();
                    management.deleteStudent(id);
                    System.out.println("Student deleted successfully.");
                    break;
                case 5:
                    // Display all students
                    management.displayStudents();
                    break;
                case 6:
                    // Exit the system
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
