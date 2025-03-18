package A8.Department;

import java.util.ArrayList;
import java.util.List;

import A8.Employees.Employee;

public abstract class Department {
    protected String departmentName;
    public List<Employee> employeeList = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    abstract boolean join(Employee emp);

    abstract boolean relieve(Employee emp);

    abstract List<Employee> getEmployees();
}
