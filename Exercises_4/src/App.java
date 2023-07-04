import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        TownManager townManager = new TownManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Enter family infor");

            List<Person> persons = new ArrayList<>();
            System.out.println("Enter number of person");
            int num = scanner.nextInt();
            for (int j = 0; j < num; j++) {
                System.out.println("Enter name person " + j + ":");

                System.out.print("Id: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Job: ");
                String job = scanner.nextLine();
                
                persons.add(new Person(id, name, age, job));
            }

            System.out.println("Enter address:");
            String address = scanner.nextLine();

            townManager.addFamily(new Family(address,persons));


        }

        townManager.showInfor();

        scanner.close();
    }
}
