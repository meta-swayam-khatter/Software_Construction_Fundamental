package A8.Employees;

public class Developer extends Employee {

    public Developer(String name, int baseSalary, int bonus, int compensation) {
        super(name, baseSalary, bonus, compensation);
    }

    @Override
    public int getBasicSalary() {
        try {
            return this.baseSalary;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int getBonus() {
        try {
            return this.bonus;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int getCompensation() {
        try {
            return this.compensation;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public void getPaySlip() {
        try {
            System.out.println("Payslip of " + this.name + ": ");
            System.out.println("\tBase Salary: " + this.baseSalary);
            System.out.println("\tBonus: " + this.bonus);
            System.out.println("\tCompensation: " + this.compensation + "\n");
            System.out.println("\tTotal: " + (this.baseSalary+this.bonus+this.compensation));
        } catch (Exception e) {
            return;
        }
    }
}
