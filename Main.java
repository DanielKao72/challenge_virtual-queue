import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Reto para el desarrollador:
        // 1. Implementar la clase 'Person' con atributos 'name' (String), 'age' (int) y 'hasDisability' (boolean).
        // 2. Implementar la clase 'QueueManager' que gestione dos colas: 'priorityQueue' y 'regularQueue'.
        // 3. El método 'addPerson' debe añadir personas a la cola correcta según su edad (>= 60) o si tiene discapacidad.
        // 4. El método 'processQueue' debe atender primero a las personas en 'priorityQueue' y luego a las de 'regularQueue'.
        // 5. Crear instancias de 'Person' y añadirlas a la cola usando 'QueueManager'.
        // 6. Llamar a 'processQueue' para simular la atención.
        // 7. Imprimir en consola el estado de cada persona al ser añadida y atendida.

        // Pista: Usar las clases Queue y LinkedList de Java.

        System.out.println("Reto: Simulación de cola de atención prioritaria");

        // Ejemplo de uso (a completar por el desarrollador):
        QueueManager queueManager = new QueueManager();
        queueManager.addPerson("Persona 1", 30, false);
        queueManager.addPerson("Adulto Mayor 1", 70, false);
        System.out.println("Atendiendo a las personas en la cola...");
        queueManager.processQueue();
    }
}

// Implementar la clase Person aquí (reto)
class Person {
    private String name;
    private int age;
    private boolean hasDisability;

    public Person(String name, int age, boolean hasDisability) {
        this.name = name;
        this.age = age;
        this.hasDisability = hasDisability;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasDisability() {
        return hasDisability;
    }
}

// Implementar la clase QueueManager aquí (reto)
class QueueManager {
    private Queue<Person> priorityQueue;
    private Queue<Person> regularQueue;

    public QueueManager() {
        this.priorityQueue = new java.util.LinkedList<>();
        this.regularQueue = new java.util.LinkedList<>();
    }

    public void addPerson(String name, int age, boolean hasDisability) {
        Person person = new Person(name, age, hasDisability);

        if (age >= 60 || hasDisability) {
            priorityQueue.add(person);
            System.out.println("Añadiendo a la cola prioritaria: " + person.getName());
        }
        else {
            regularQueue.add(person);
            System.out.println("Añadiendo a la cola regular: " + person.getName());
        }

        return;
    }

    public void processQueue() {
        while (!priorityQueue.isEmpty()) {
            Person person = priorityQueue.poll();
            System.out.println("Atendiendo a: " + person.getName() + " (Prioridad)");
        }

        while (!regularQueue.isEmpty()) {
            Person person = regularQueue.poll();
            System.out.println("Atendiendo a: " + person.getName() + " (Regular)");
        }
    }
}