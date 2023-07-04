import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("Employee Manager");
            System.out.println("1. Add employee");
            System.out.println("2. Search by name");
            System.out.println("3. Show employees information");
            System.out.println("4. Exit");
            
            String function = scanner.nextLine();

            switch (function) {
                case "1":
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.println("Enter gender: ");
                    scanner.nextLine();
                    String gender = scanner.nextLine();
                    System.out.println("Enter address: ");
                    String address = scanner.nextLine();
                    
                    System.out.println("1. Add Engineer");
                    System.out.println("2. Add Worker");
                    System.out.println("3. Add Staff");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "1":
                            System.out.println("Enter major: ");
                            String major = scanner.nextLine();
                            employeeManager.addEmployee(new Engineer(name, age, gender, address, major));
                            break;
                        case "2":
                            System.out.println("Enter level: ");
                            int level = scanner.nextInt();
                            if (level < 1 && level > 10) {
                                System.out.println("Input Invalid");
                            } else {
                                employeeManager.addEmployee(new Worker(name, age, gender, address, level));
                            }
                            break;
                        case "3":
                            System.out.println("Enter task: ");
                            String task = scanner.nextLine();
                            employeeManager.addEmployee(new Staff(name, age, gender, address, task));
                            break;
                        default:
                            System.out.println("Input invalid");
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Enter name: ");
                    String nameSearch = scanner.nextLine();
                    List<Employee> result = employeeManager.searchByName(nameSearch);
                    if (!result.isEmpty()) {
                        result.forEach(employee -> System.out.println(employee.toString()));
                    } else {
                        System.out.println("No result");
                    }
                    break;

                case "3":
                    employeeManager.showInfor();
                    break;

                case "4":
                    scanner.close();
                    return;

                default:
                    System.out.println("Input invalid");
                    break;
            }
        }
    }
}
