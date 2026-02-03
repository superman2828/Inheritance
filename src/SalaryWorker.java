public class SalaryWorker extends Worker{
    double annualSalary;

    public SalaryWorker(String IDNum, String firstName, String lastName, String title, int YOB, double annualSalary) {
        super(IDNum, firstName, lastName, title, YOB, annualSalary / 2080);
        this.annualSalary = annualSalary;
    }

    @Override
    double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    @Override
    void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.println("Total Weekly Pay: $" + String.format("%.2f", weeklyPay));
    }

    @Override
    public String toString() {
        return "SalaryWorker{" +
                super.toString() +
                ", annualSalary=" + annualSalary +
                '}';
    }

    public String toJSONString(){
        return "{" +
                "\"IDNum\":\"" + super.getIDNum() + "\"," +
                "\"firstName\":\"" + super.getFirstName() + "\"," +
                "\"lastName\":\"" + super.getLastName() + "\"," +
                "\"title\":\"" + super.getTitle() + "\"," +
                "\"YOB\":" + super.getYOB() + "," +
                "\"WeeklySalary\":" + (annualSalary / 52) + "," +
                "\"annualSalary\":" + annualSalary +
                "}";
    }

    public String toCSVString(){
        return super.toCSVString() + "," + annualSalary;
    }

    public String toXMLString(){
        return "<Person>" +
                "<IDNum>" + super.getIDNum() + "</IDNum>" +
                "<FirstName>" + super.getFirstName() + "</FirstName>" +
                "<LastName>" + super.getLastName() + "</LastName>" +
                "<Title>" + super.getTitle() + "</Title>" +
                "<YOB>" + super.getYOB() + "</YOB>" +
                "<WeeklySalary>" + (annualSalary / 52) + "</WeeklySalary>" +
                "<AnnualSalary>" + annualSalary + "</AnnualSalary>" +
                "</Person>";
    }
}
