public class Worker extends Person {

    double hourlyPayRate;

    @Override
    public String toString() {
        return "Worker{" +
                super.toString() +
                ", hourlyPayRate=" + hourlyPayRate +
                '}';
    }

    public Worker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
        super(IDNum, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    double calculateWeeklyPay(double hoursWorked) {
        // Time and a half for hours worked over 40
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyPayRate;
        } else {
            double regularPay = 40 * hourlyPayRate;
            double overtimePay = (hoursWorked - 40) * hourlyPayRate * 1.5;
            return regularPay + overtimePay;
        }
    }

    void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        if (hoursWorked <= 40) {
            System.out.println("Regular Pay for " + hoursWorked + " hours: $" + String.format("%.2f", weeklyPay));
            System.out.println("Overtime Pay: $0.00");
            System.out.println("Total Weekly Pay: $" + String.format("%.2f", weeklyPay));
        }else  {
            System.out.println("Regular Pay for 40 hours: $" + String.format("%.2f", 40 * hourlyPayRate));
            System.out.println("Overtime Pay for " + (hoursWorked - 40) + " hours: $" + String.format("%.2f", (hoursWorked - 40) * hourlyPayRate * 1.5));
            System.out.println("Total Weekly Pay: $" + String.format("%.2f", weeklyPay));
        }
    }

    public String toXMLString(){
        return "<Person>" +
                "<IDNum>" + super.getIDNum() + "</IDNum>" +
                "<FirstName>" + super.getFirstName() + "</FirstName>" +
                "<LastName>" + super.getLastName() + "</LastName>" +
                "<Title>" + super.getTitle() + "</Title>" +
                "<YOB>" + super.getYOB() + "</YOB>" +
                "<HourlyPayRate>" + hourlyPayRate + "</HourlyPayRate>" +
                "</Person>";
    }

    public String toCSVString(){
        return super.toCSVString() + "," + hourlyPayRate;
    }

    public String toJSONString(){
        return "{" +
                "\"IDNum\":\"" + super.getIDNum() + "\"," +
                "\"firstName\":\"" + super.getFirstName() + "\"," +
                "\"lastName\":\"" + super.getLastName() + "\"," +
                "\"title\":\"" + super.getTitle() + "\"," +
                "\"YOB\":" + super.getYOB() + "\"," +
                "\"hourlyPayRate\":" + this.hourlyPayRate +
                "}";
    }
}
