import java.time.LocalDate;

public class MonthlyEmployee extends Employee{
    private double monthlySalary;
    private int vacationDays;
    private double bonousPercentage;
    private boolean hasHealthInsurance;

    public MonthlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                           double monthlySalary, int vacationDays, double bonousPercentage, boolean hasHealthInsurance) {
        super(id, name, gender, hireDate);
        this.monthlySalary = monthlySalary;
        this.vacationDays = vacationDays;
        this.bonousPercentage = bonousPercentage;
        this.hasHealthInsurance = hasHealthInsurance;
    }

    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary; }

    public int getVacationDays() { return vacationDays; }
    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays; }

    public double getBonousPercentage() { return bonousPercentage; }
    public void setBonousPercentage(double bonousPercentage) {
        this.bonousPercentage = bonousPercentage;
    }

    public boolean isHasHealthInsurance() { return hasHealthInsurance; }
    public void setHasHealthInsurance(boolean hasHealthInsurance) {
        this.hasHealthInsurance = hasHealthInsurance;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + (monthlySalary * bonousPercentage);
    }



    @Override
    public String toString() {
        return "MonthlyEmployee [" + super.toString() + ", monthlySalary=" + monthlySalary +
                ", vacationDays=" + vacationDays + ", bonousPercentage=" + bonousPercentage +
                ", hasHealthInsurance=" + hasHealthInsurance + "]";
    }
}
