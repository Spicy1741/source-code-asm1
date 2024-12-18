import java.util.Random;

class AnalysisAlgorithmDemo {

    // Bubble Sort
    public static void bubbleSort(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getMarks() > students[j + 1].getMarks()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Student[] students, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(students, low, high);
            quickSort(students, low, pivotIndex - 1);
            quickSort(students, pivotIndex + 1, high);
        }
    }

    private static int partition(Student[] students, int low, int high) {
        double pivot = students[high].getMarks();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (students[j].getMarks() <= pivot) {
                i++;
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;
        return i + 1;
    }

    // Merge Sort
    public static void mergeSort(Student[] students, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(students, left, mid);
            mergeSort(students, mid + 1, right);
            merge(students, left, mid, right);
        }
    }

    private static void merge(Student[] students, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = students[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = students[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getMarks() <= rightArray[j].getMarks()) {
                students[k] = leftArray[i];
                i++;
            } else {
                students[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            students[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            students[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Generate random students
    public static Student[] generateRandomStudents(int size) {
        Random random = new Random();
        Student[] students = new Student[size];
        for (int i = 0; i < size; i++) {
            String id = "S" + (i + 1);
            String name = "Student" + (i + 1);
            double marks = random.nextDouble() * 100;
            students[i] = new Student(id, name, marks);
        }
        return students;
    }
}

class StudentSortingDemo {
    public static void main(String[] args) {
        int size = 10000; // Size of the student array

        // Generate random students
        Student[] bubbleStudents = AnalysisAlgorithmDemo.generateRandomStudents(size);
        Student[] quickStudents = bubbleStudents.clone();
        Student[] mergeStudents = bubbleStudents.clone();

        // Measure Bubble Sort
        long startBubble = System.nanoTime();
        AnalysisAlgorithmDemo.bubbleSort(bubbleStudents);
        long endBubble = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endBubble - startBubble) + " ns");

        // Measure Quick Sort
        long startQuick = System.nanoTime();
        AnalysisAlgorithmDemo.quickSort(quickStudents, 0, quickStudents.length - 1);
        long endQuick = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endQuick - startQuick) + " ns");

        // Measure Merge Sort
        long startMerge = System.nanoTime();
        AnalysisAlgorithmDemo.mergeSort(mergeStudents, 0, mergeStudents.length - 1);
        long endMerge = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endMerge - startMerge) + " ns");

        // Existing student management functionality can be added here
        StudentManagement management = new StudentManagement();
        // Add code to interact with the management system if needed.
    }
}