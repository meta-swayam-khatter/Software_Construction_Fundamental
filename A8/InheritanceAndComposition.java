package A8;

import A8.Department.Management;
import A8.Employees.HR;
import A8.Organization.Organization;
import A8.Organization.Payroll;

public class InheritanceAndComposition {
    public static void main(String[] args) {
        Organization org = new Organization("Metacube");
        Management dept1 = new Management("Manage");
        HR hr1 = new HR("Nikita", 10000, 2000, 1200);
        HR hr2 = new HR("Nikki", 10000, 2000, 1200);

        org.addDepartment(dept1);
        dept1.join(hr1);
        dept1.join(hr2);

        Payroll pr = new Payroll(org);
        pr.getAllPaySlips();
    }
}
