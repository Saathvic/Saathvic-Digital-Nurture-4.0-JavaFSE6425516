package DataStructureAndAlgorthms;
class Task {
    String taskId;
    String taskName;
    String taskStatus;
    Task nextTask;

    Task(String taskId, String taskName, String taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.nextTask = null;
    }

    void show() {
        System.out.println(taskId + " | " + taskName + " | " + taskStatus);
    }
}

public class TaskList {
    Task headTask = null;

    void add(String taskId, String taskName, String taskStatus) {
        Task newTask = new Task(taskId, taskName, taskStatus);
        if (headTask == null) {
            headTask = newTask;
        } else {
            Task currentTask = headTask;
            while (currentTask.nextTask != null) {
                currentTask = currentTask.nextTask;
            }
            currentTask.nextTask = newTask;
        }
    }

    void viewAll() {
        Task currentTask = headTask;
        while (currentTask != null) {
            currentTask.show();
            currentTask = currentTask.nextTask;
        }
    }

    void find(String taskId) {
        Task currentTask = headTask;
        while (currentTask != null) {
            if (currentTask.taskId.equals(taskId)) {
                currentTask.show();
                return;
            }
            currentTask = currentTask.nextTask;
        }
        System.out.println("Task not found");
    }

    void remove(String taskId) {
        if (headTask == null) return;

        if (headTask.taskId.equals(taskId)) {
            headTask = headTask.nextTask;
            return;
        }

        Task currentTask = headTask;
        while (currentTask.nextTask != null) {
            if (currentTask.nextTask.taskId.equals(taskId)) {
                currentTask.nextTask = currentTask.nextTask.nextTask;
                return;
            }
            currentTask = currentTask.nextTask;
        }
        System.out.println("Task not found to remove");
    }    public static void main(String[] args) {
        TaskList taskManager = new TaskList();

        taskManager.add("TaskAlpha", "Submit DSA Assignment", "Pending");
        taskManager.add("TaskBeta", "Complete Java Project", "In Progress");
        taskManager.add("TaskGamma", "Database PPT Prep", "Pending");
        taskManager.add("TaskDelta", "Cloud Lab Writeup", "Completed");
        taskManager.add("TaskEpsilon", "AI Paper Submission", "Pending");

        System.out.println("All Tasks:");
        taskManager.viewAll();

        System.out.println("\nSearch for TaskGamma:");
        taskManager.find("TaskGamma");

        System.out.println("\nRemoving TaskBeta:");
        taskManager.remove("TaskBeta");

        System.out.println("\nUpdated Task List:");
        taskManager.viewAll();
    }
}

