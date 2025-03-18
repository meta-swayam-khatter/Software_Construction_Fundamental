package A8.Organization;

import java.util.List;

import A8.Employees.Employee;

public class Payroll {
    Organization org;

    public Payroll(Organization org) {
        this.org = org;
    }

    public void getAllPaySlips() {
        List<Employee> employees = org.getAllEmployees();
        for(Employee emp : employees) {
            emp.getPaySlip();
            System.out.println(".................................\n");
        }
    }
}
