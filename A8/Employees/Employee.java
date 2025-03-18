package A8.Employees;

public abstract class Employee {
    public String name;
    protected int baseSalary;
    protected int bonus;
    protected int compensation;
    public String department = null;

    public Employee(String name, int baseSalary, int bonus, int compensation) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.compensation = compensation;
    }

    abstract int getBasicSalary();

    abstract int getBonus();

    abstract int getCompensation();

    public abstract void getPaySlip();
}
