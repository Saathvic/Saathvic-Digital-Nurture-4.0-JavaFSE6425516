package DataStructureAndAlgorthms;

class Employee {
    String employeeId;
    String fullName;
    String jobPosition;
    double monthlySalary;

    Employee(String employeeId, String fullName, String jobPosition, double monthlySalary) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.jobPosition = jobPosition;
        this.monthlySalary = monthlySalary;
    }

    void display() {
        System.out.println(employeeId + " - " + fullName + " - " + jobPosition + " - Rs." + monthlySalary);
    }
}

public class EmployeeManagementSystem {
    static Employee[] employeeDatabase = new Employee[10];
    static int totalEmployees = 0;

    static void addEmployee(Employee employee) {
        if (totalEmployees < employeeDatabase.length) {
            employeeDatabase[totalEmployees++] = employee;
        }
    }

    static void traverseEmployees() {
        for (int index = 0; index < totalEmployees; index++) {
            employeeDatabase[index].display();
        }
    }

    static void searchEmployee(String employeeId) {
        for (int index = 0; index < totalEmployees; index++) {
            if (employeeDatabase[index].employeeId.equals(employeeId)) {
                employeeDatabase[index].display();
                return;
            }
        }
        System.out.println("Employee not found");
    }

    static void deleteEmployee(String employeeId) {
        for (int currentIndex = 0; currentIndex < totalEmployees; currentIndex++) {
            if (employeeDatabase[currentIndex].employeeId.equals(employeeId)) {
                for (int shiftIndex = currentIndex; shiftIndex < totalEmployees - 1; shiftIndex++) {
                    employeeDatabase[shiftIndex] = employeeDatabase[shiftIndex + 1];
                }
                employeeDatabase[--totalEmployees] = null;
                return;
            }
        }
        System.out.println("Employee not found to delete");
    }    public static void main(String[] args) {
        addEmployee(new Employee("EmpAlpha", "Alice", "Developer", 50000));
        addEmployee(new Employee("EmpBeta", "Bob", "Tester", 42000));
        addEmployee(new Employee("EmpGamma", "Charlie", "Support", 38000));
        addEmployee(new Employee("EmpDelta", "David", "HR", 46000));
        addEmployee(new Employee("EmpEpsilon", "Eve", "Designer", 49000));

        System.out.println("All Employees:");
        traverseEmployees();

        System.out.println("\nSearching for EmpGamma:");
        searchEmployee("EmpGamma");

        System.out.println("\nDeleting EmpBeta:");
        deleteEmployee("EmpBeta");

        System.out.println("\nEmployees after deletion:");
        traverseEmployees();
    }
}

