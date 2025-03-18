package A8.Organization;

import java.util.ArrayList;
import java.util.List;

import A8.Department.Department;
import A8.Employees.Employee;

public class Organization {
    protected String organizationName;
    protected List<Department> departmentList = new ArrayList<>();

    public Organization(String organizationName) {
        this.organizationName = organizationName;
    }

    public boolean addDepartment(Department dept) {
        try {
            if(departmentList.contains(dept)) {
                System.out.println("This department already exists in the organization!!");
                return false;
            }
            departmentList.add(dept);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Employee> getAllEmployees() {
        try {
            List<Employee> employees = new ArrayList<>();
            for(Department dept : departmentList) {
                for(Employee emp : dept.employeeList) {
                    employees.add(emp);
                }
            }
            return employees;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
