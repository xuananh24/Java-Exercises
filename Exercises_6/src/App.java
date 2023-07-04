import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("1.Addd student");
            System.out.println("2.Show all student");
            System.out.println("3.Show 20 year-old students.");
            System.out.println("4.The number of students is 23 years old and comes from DN.");
            System.out.println("5.Exit");

            String function = scanner.nextLine();

            switch(function) {
                case "1":
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter hometown: ");
                    String hometown = scanner.nextLine();
                    System.out.println("Enter class: ");
                    String clazz = scanner.nextLine();
                    studentManager.addStudent(new Student(name, age, hometown, clazz));
                    break;
                case "2":
                    studentManager.showAllStudent();
                    break;
                case "3":
                    System.out.println("Show student 20 year old:");
                    studentManager.getStudent20YearOld().forEach(System.out::println);
                    break;
                case "4":
                    System.out.println("Show number of students is 23 years old and comes from DN: " + studentManager.getNumStudent20YearOldDN());
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
                
            }
        }
        
    }
}
