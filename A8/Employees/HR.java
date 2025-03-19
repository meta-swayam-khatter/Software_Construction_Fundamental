package A8.Employees;

public class HR extends Employee {
    public HR(String name, int baseSalary, int bonus, int compensation) {
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
            int total = this.baseSalary+this.bonus+this.compensation;
            double netTotal = total;
            System.out.println("Payslip of " + this.name + ": ");
            System.out.println("\tBase Salary: " + this.baseSalary);
            System.out.println("\tBonus: " + this.bonus);
            System.out.println("\tCompensation: " + this.compensation + "\n");
            System.out.println("\tTotal: " + total);
            System.out.println("\nAfter Tax: ");
            if(total<=1200000) {
                netTotal = total;
            } else if(total>1200000 && total<=1600000) {
                netTotal = total - (total-1200000)*0.15;
            } else if(total>1600000 && total<=2000000) {
                netTotal = total - (total-1600000)*0.2 - 60000;
            } else if(total>2000000 && total<=2400000) {
                netTotal = total - (total-2000000)*0.25 - 60000 - 80000;
            } else {
                netTotal = total - (total-2400000)*0.3 - 60000 - 80000 - 100000;
            }
            System.out.println("\tNet Total: " + netTotal);
        } catch (Exception e) {
            return;
        }
    }
}
