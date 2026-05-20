import java.util.ArrayList;

/**
 * Base abstract class representing a generic Employee.
 * Demonstrates Abstraction and Encapsulation.
 */
abstract class Employee {
    // Private fields to restrict direct access (Encapsulation)
    private String name;
    private int id;

    // Constructor to initialize base employee details
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter method for employee name
    public String getName() {
        return name;
    }

    // Getter method for employee ID
    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses (Polymorphism)
    abstract public double calculateSalary();

    // Overriding toString() to display custom employee details
    @Override
    public String toString() {
        return "Employee[name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

/**
 * Subclass representing a Full-Time Employee.
 * Inherits from the Employee class.
 */
class FullTimeEmployee extends Employee {
    private double monthlySalary = 0.0;

    // Constructor for Full-Time Employee
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id); // Calling the parent class constructor
        this.monthlySalary = monthlySalary;
    }

    // Implementing the abstract method to return full-time salary
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

/**
 * Subclass representing a Part-Time Employee.
 * Inherits from the Employee class.
 */
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    // Constructor for Part-Time Employee
    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id); // Calling the parent class constructor
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Implementing the abstract method based on hours worked and rate
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

/**
 * PayrollSystem class to manage the collection of employees.
 */
class PayrollSystem {
    // List to store all types of employees using Polymorphism
    private ArrayList<Employee> employeeList;

    // Constructor initializing the ArrayList
    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    // Method to add a new employee to the system
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Method to remove an employee by their unique ID
    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        
        // Iterating through the list to find the matching employee ID
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }

        // If employee is found, remove them from the list
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    // Method to display details of all employees
    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee); // Automatically calls toString()
        }
    }
}

/**
 * Main class to run and test the Employee Management System.
 */
class Employee_Management_System {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        // Creating full-time and part-time employee objects
        FullTimeEmployee emp1 = new FullTimeEmployee("Sagar", 3322, 60000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Rahul", 2233, 150, 300);

        // Adding employees to the payroll system
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        // Displaying initial list
        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();
        System.out.println(); // Adding a blank line for clean output

        // Removing an employee by ID
        System.out.println("Removing employee with ID 2233...");
        payrollSystem.removeEmployee(2233);
        System.out.println();

        // Displaying final remaining list
        System.out.println("Remaining Employee Details:");
        payrollSystem.displayEmployees();
    }
}