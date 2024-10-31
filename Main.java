// Queue implementation
class Queue {
    private int[] elements;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        elements = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == elements.length) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = value;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int value = elements[front];
        front = (front + 1) % elements.length;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        return elements[front];
    }
}

// Stack implementation
class Stack {
    private int[] elements;
    private int top;

    public Stack(int capacity) {
        elements = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == elements.length - 1) {
            System.out.println("Stack is full");
            return;
        }
        elements[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return elements[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

// Dijkstra's Algorithm implementation
class Dijkstra {
    private int vertices;
    private int[][] graph;

    public Dijkstra(int vertices) {
        this.vertices = vertices;
        graph = new int[vertices][vertices];
    }

    public void addEdge(int src, int dest, int weight) {
        graph[src][dest] = weight;
        graph[dest][src] = weight; // For undirected graph
    }

    public void findShortestPath(int start) {
        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = selectMinVertex(distance, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !visited[v] && distance[u] != Integer.MAX_VALUE) {
                    int newDist = distance[u] + graph[u][v];
                    if (newDist < distance[v]) {
                        distance[v] = newDist;
                    }
                }
            }
        }

        printShortestPath(distance);
    }

    private int selectMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    private void printShortestPath(int[] distance) {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t" + distance[i]);
        }
    }
}

// Prim-Jarnik Algorithm implementation
class PrimJarnik {
    private int vertices;
    private int[][] graph;

    public PrimJarnik(int vertices) {
        this.vertices = vertices;
        graph = new int[vertices][vertices];
    }

    public void addEdge(int src, int dest, int weight) {
        graph[src][dest] = weight;
        graph[dest][src] = weight; // For undirected graph
    }

    public void findMinimumSpanningTree(int start) {
        boolean[] inMST = new boolean[vertices];
        int[] parent = new int[vertices];
        int[] key = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
        }

        key[start] = 0;
        parent[start] = -1;

        for (int count = 0; count < vertices - 1; count++) {
            int u = selectMinVertex(key, inMST);
            inMST[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent);
    }

    private int selectMinVertex(int[] key, boolean[] inMST) {
        int minVertex = -1;
        for (int i = 0; i < vertices; i++) {
            if (!inMST[i] && (minVertex == -1 || key[i] < key[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    private void printMST(int[] parent) {
        System.out.println("Edge\tWeight");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }
}

// Sorting algorithms
class Sorting {
    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

// Main class to run the project
public class Main {
    public static void main(String[] args) {
        // Queue example
        System.out.println("Queue Example:");
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());

        // Stack example
        System.out.println("\nStack Example:");
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Peek: " + stack.peek());

        // Dijkstra's Algorithm example
        System.out.println("\nDijkstra's Algorithm Example:");
        Dijkstra dijkstra = new Dijkstra(5);
        dijkstra.addEdge(0, 1, 10);
        dijkstra.addEdge(0, 2, 3);
        dijkstra.addEdge(1, 2, 1);
        dijkstra.addEdge(1, 3, 2);
        dijkstra.addEdge(2, 1, 4);
        dijkstra.addEdge(2, 3, 8);
        dijkstra.addEdge(2, 4, 2);
        dijkstra.addEdge(3, 4, 7);
        dijkstra.findShortestPath(0);

        // Prim-Jarnik Algorithm example
        System.out.println("\nPrim-Jarnik Algorithm Example:");
        PrimJarnik primJarnik = new PrimJarnik(5);
    }
}
