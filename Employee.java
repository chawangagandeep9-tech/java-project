public class Employee {
    int empId;
    double basicSalary;
    double hra;
    double da;
    double pf;
    double tax;

    public Employee(int empId, double basicSalary){
        this.empId = empId;
        this.basicSalary = basicSalary;
        this.hra = basicSalary * 0.2;
        this.da = basicSalary * 0.1;
        this.pf = basicSalary * 0.12;
        this.tax = basicSalary * 0.1;
    }
    public double calculateEmployeeSalary(){
        return basicSalary + hra + da - pf - tax;
    }
}
class Manager extends Employee {
    double bonus;

    public Manager(int empId, double basicSalary, double bonus) {
        super(empId, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateEmployeeSalary() {
        return super.calculateEmployeeSalary() + bonus;
    }
}
class Main {
    public static void main(String[] args) {
        Employee emp = new Employee(101, 3000);
        System.out.println("Employee Salary: " + emp.calculateEmployeeSalary());
        Manager mgr = new Manager(102, 5000, 1000);
        System.out.println("Manager Salary: " + mgr.calculateEmployeeSalary());
    }
}