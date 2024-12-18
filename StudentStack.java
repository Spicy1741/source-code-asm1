public class StudentStack {
    private Node top;

    public StudentStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    public Student pop() {
        if (isEmpty()) return null;
        Student student = top.student;
        top = top.next;
        return student;
    }

    public Student peek() {
        if (isEmpty()) return null;
        return top.student;
    }

    public void display() {
        Node current = top;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
}
