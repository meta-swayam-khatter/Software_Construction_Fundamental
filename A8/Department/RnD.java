package A8.Department;

import java.util.List;

import A8.Employees.Employee;

public class RnD extends Department {
    public RnD(String departmentName) {
        super(departmentName);
    }

    @Override
    public boolean join(Employee emp) {
        try {
            if(emp.department != null) {
                System.out.println("This employee already exist in a department!!");
                return false;
            }
            emp.department = "RnD";
            employeeList.add(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean relieve(Employee emp) {
        try {
            if(emp.department == null) {
                System.out.println("This employee does not exist in any department!!");
                return false;
            }
            emp.department = null;
            employeeList.remove(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Employee> getEmployees() {
        try {
            return this.employeeList;
        } catch (Exception e) {
            return null;
        }
    }
}
