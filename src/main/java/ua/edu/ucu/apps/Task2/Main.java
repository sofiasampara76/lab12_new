package ua.edu.ucu.apps.Task2;

public class Main {
    public static void main(String[] args) {
        Group<Integer> nestedGroup = new Group<>();
        nestedGroup.addTask(new Signature<>(System.out::println))
                   .addTask(new Signature<>(x -> System.out.println("Square: " + (x * x))));

        Group<Integer> group = new Group<>();
        group.addTask(nestedGroup)
             .addTask(new Signature<>(x -> System.out.println("Cube: " + (x * x * x))));

        group.apply(10);

        // Display groupId headers for each task
        System.out.println("\nHeaders Verification:");
        for (Task<Integer> task : group.getTasks()) {
            System.out.println("Task ID: " + task.getId() + ", Group ID: " + task.getHeader("groupId"));
        }
    }
}
