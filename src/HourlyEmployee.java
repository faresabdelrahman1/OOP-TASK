import java.time.LocalDate;

public class HourlyEmployee extends Employee     {
    private double hourlyRate;
    private double hoursWorked;
    private double overTimeRate;

    public HourlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                          double hourlyRate, double hoursWorked, double overTimeRate) {
        super(id, name, gender, hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overTimeRate = overTimeRate;
    }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }

    public double getOverTimeRate() { return overTimeRate; }
    public void setOverTimeRate(double overTimeRate) { this.overTimeRate = overTimeRate; }

    @Override
    public double calculateSalary() {
        double standardHours = 40;
        if (hoursWorked <= standardHours) {
            return hoursWorked * hourlyRate;
        } else {
            return (standardHours * hourlyRate) + ((hoursWorked - standardHours) * overTimeRate);
        }
    }

    @Override
    public String toString() {
        return "HourlyEmployee [" + super.toString() + ", hourlyRate=" + hourlyRate +
                ", hoursWorked=" + hoursWorked + ", overTimeRate=" + overTimeRate + "]";
    }
}
