package arraylist;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Integer nextId = 1;

    public void addTask(String title, String description) {
        var task = new Task(nextId++, title, description, false);
        tasks.add(task);
    }

    public  void removeTask(Integer id) {
        var task = getTaskById(id);
        if (task == null) {
            System.out.println("Task " + id + " not found");
        } else tasks.remove(task);

    }

    public void updateTask(Integer id, String title, String description) {
        var task = getTaskById(id);
        if (task == null) {
            System.out.println("Task " + id + " not found");
        } else {
            task.setTitle(title);
            task.setDescription(description);
        }
    }

    public void markAsCompleted(Integer id) {
        var task = getTaskById(id);
        if (task == null) {
            System.out.println("Task " + id + " not found");
        } else {
            task.markAsCompleted();
            System.out.println("Task " + id + " marked as completed");
        }
    }
    public void showAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
    public void search(String keyword) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching tasks found.");
        }
    }
    public void clearAll() {
        tasks.clear();
        System.out.println("All tasks cleared.");
    }

    private Task getTaskById(Integer id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }
}