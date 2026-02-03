import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {

    SalaryWorker w1;

    @BeforeEach
    void setUp() {
        w1 = new SalaryWorker("000002", "Alice", "Smith", "Ms.", 1985,104000.0);
    }

    @Test
    void calculateWeeklyPay() {
        double weeklyPay = w1.calculateWeeklyPay(0);
        assertEquals(2000.0, weeklyPay);
    }

    @Test
    void displayWeeklyPay() {
    }

    @Test
    void testToString() {
        String expected = "SalaryWorker{" +
                "Worker{" +
                "Person{" +
                "IDNum='000002', " +
                "firstName='Alice', " +
                "lastName='Smith', " +
                "title='Ms.', " +
                "YOB=1985}" +
                ", hourlyPayRate=50.0" +
                "}, annualSalary=104000.0" +
                '}';
        assertEquals(expected, w1.toString());
    }

    @Test
    void toJSONString() {
        String expected = "{" +
                "\"IDNum\":\"000002\"," +
                "\"firstName\":\"Alice\"," +
                "\"lastName\":\"Smith\"," +
                "\"title\":\"Ms.\"," +
                "\"YOB\":1985," +
                "\"WeeklySalary\":2000.0," +
                "\"annualSalary\":104000.0" +
                "}";
        assertEquals(expected, w1.toJSONString());
    }

    @Test
    void toCSVString() {
        String expected = "000002,Alice,Smith,Ms.,1985,50.0,104000.0";
        assertEquals(expected, w1.toCSVString());
    }

    @Test
    void toXMLString() {
        String expected = "<Person>" +
                "<IDNum>000002</IDNum>" +
                "<FirstName>Alice</FirstName>" +
                "<LastName>Smith</LastName>" +
                "<Title>Ms.</Title>" +
                "<YOB>1985</YOB>" +
                "<WeeklySalary>2000.0</WeeklySalary>" +
                "<AnnualSalary>104000.0</AnnualSalary>" +
                "</Person>";
        assertEquals(expected, w1.toXMLString());
    }
}