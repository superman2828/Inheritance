import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    Worker w1;
    @BeforeEach
    void setUp() {
        w1 = new Worker("000001", "Myles", "Garrett", "Mr.", 1995, 20.0);
    }

    @Test
    void testToString() {
        String expected = "Worker{" +
                "Person{" +
                "IDNum='000001', " +
                "firstName='Myles', " +
                "lastName='Garrett', " +
                "title='Mr.', " +
                "YOB=1995}" +
                ", hourlyPayRate=20.0" +
                '}';
        assertEquals(expected, w1.toString());
    }

    @Test
    void calculateWeeklyPay() {
        double pay1 = w1.calculateWeeklyPay(35); // No overtime
        assertEquals(700.0, pay1);

        double pay2 = w1.calculateWeeklyPay(45); // With overtime
        assertEquals(950.0, pay2);
    }

    @Test
    void displayWeeklyPay() {
    }

    @Test
    void toXMLString() {
        String expected="<Person>" +
                "<IDNum>000001</IDNum>" +
                "<FirstName>Myles</FirstName>" +
                "<LastName>Garrett</LastName>" +
                "<Title>Mr.</Title>" +
                "<YOB>1995</YOB>" +
                "<HourlyPayRate>20.0</HourlyPayRate>" +
                "</Person>";
        assertEquals(expected, w1.toXMLString());
    }

    @Test
    void toCSVString() {
        String expected="000001,Myles,Garrett,Mr.,1995,20.0";
        assertEquals(expected, w1.toCSVString());
    }

    @Test
    void toJSONString() {
        String expected="{" +
                "\"IDNum\":\"000001\"," +
                "\"firstName\":\"Myles\"," +
                "\"lastName\":\"Garrett\"," +
                "\"title\":\"Mr.\"," +
                "\"YOB\":1995\"," +
                "\"hourlyPayRate\":20.0" +
                "}";
        assertEquals(expected, w1.toJSONString());
    }
}