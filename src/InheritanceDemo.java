import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {

        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(new Worker("000001", "Myles", "Garrett", "Mr.", 1995, 20.0));
        workers.add(new Worker("000002", "John", "Doe", "Mr.", 1990, 25.0));
        workers.add(new Worker("000003", "Jane", "Doe", "Ms.", 1992, 30.0));
        workers.add(new SalaryWorker("000004", "Alice", "Smith", "Ms.", 1985, 104000.0));
        workers.add(new SalaryWorker("000005", "Bob", "Johnson", "Mr.", 1980, 78000.0));
        workers.add(new SalaryWorker("000006", "Charlie", "Brown", "Mr.", 1975, 52000.0));

        System.out.println("Weekly Pay");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-5s %-15s %-11s %-11s %-10s%n", "Title", "Last Name", "Week 1", "Week 2", "Week 3");
        System.out.println("---------------------------------------------------");

        int[] hours = {40, 50, 40};

        for (Worker w : workers) {
            System.out.printf("%-5s %-15s", w.getTitle(), w.getLastName());
            for (int h : hours) {
                double pay = w.calculateWeeklyPay(h);
                System.out.printf(" $%-10.2f", pay);
            }
            System.out.println();
        }
    }
}
