import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Starting Employee Payroll System Test ===\n");

        // 1. Create a Manager (MonthlyEmployee)
        Employee manager = new MonthlyEmployee(
                1, "Alice Smith", Gender.female, LocalDate.of(2018, 5, 12),
                5000.0, 15, 0.10, true
        );

        // 2. Create a Department and assign the manager
        Department dept = new Department(101, "Engineering", manager, new ArrayList<>());

        // 3. Create various types of employees
        Employee emp1 = new MonthlyEmployee(
                2, "Bob Jones", Gender.male, LocalDate.of(2020, 3, 1),
                3000.0, 10, 0.05, true
        );

        // Hourly employee with 45 hours worked (40 standard hours + 5 overtime hours at a 37.5 rate)
        Employee emp2 = new HourlyEmployee(
                3, "Charlie Brown", Gender.male, LocalDate.of(2021, 6, 15),
                25.0, 45.0, 37.5
        );

        Employee emp3 = new CommissionEmployee(
                4, "Diana Prince", Gender.female, LocalDate.of(2022, 1, 10),
                2000.0, 0.15, 10000.0
        );

        // 4. Add employees to the department (this automatically links them back to the department)
        dept.addEmployee(manager);
        dept.addEmployee(emp1);
        dept.addEmployee(emp2);
        dept.addEmployee(emp3);

        // 5. Test Department Information & Listing
        System.out.println("--- Department Overview ---");
        System.out.println(dept);
        System.out.println();

        System.out.println("--- All Department Employees ---");
        dept.printAllEmployees();
        System.out.println();

        // 6. Test Individual Salary Calculations
        System.out.println("--- Individual Salaries ---");
        System.out.println(manager.getName() + " (Monthly): $" + manager.calculateSalary());
        System.out.println(emp1.getName() + " (Monthly): $" + emp1.calculateSalary());
        System.out.println(emp2.getName() + " (Hourly + Overtime): $" + emp2.calculateSalary());
        System.out.println(emp3.getName() + " (Base + Commission): $" + emp3.calculateSalary());
        System.out.println();

        // 7. Test Total Payroll Calculation
        System.out.println("--- Total Payroll ---");
        System.out.println("Initial Total Department Payroll: $" + dept.calculateTotalPayroll());
        System.out.println();

        // 8. Test Finding an Employee
        System.out.println("--- Search Test ---");
        int searchId = 3;
        Employee found = dept.findEmployee(searchId);
        System.out.println("Found Employee (ID " + searchId + "): " + (found != null ? found.getName() : "Not found"));
        System.out.println();

        // 9. Test Removing an Employee
        System.out.println("--- Removal Test ---");
        int removeId = 2; // Removing Bob Jones
        System.out.println("Removing employee with ID " + removeId + " (" + dept.findEmployee(removeId).getName() + ")...");
        dept.removeEmployee(removeId);

        System.out.println("Total Payroll after removal: $" + dept.calculateTotalPayroll());
        System.out.println("\nRemaining Employees:");
        dept.printAllEmployees();

        System.out.println("\n=== Test Completed Successfully ===");
    }
}
