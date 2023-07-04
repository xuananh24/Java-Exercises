import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        CandidateManager candidateManager = new CandidateManager();
        Scanner scanner =  new Scanner(System.in);

        while (true) {
            System.out.println("1. Add candidate");
            System.out.println("2. Show candidate's information");
            System.out.println("3. Find candidate by Id");
            System.out.println("4. Exit");

            String function = scanner.nextLine();
            switch (function) {
                case "1":
                    Candidate candidate = createCandidate(scanner);
                    candidateManager.addCandidate(candidate);
                    break;
                case "2":
                    candidateManager.showInfor();
                    break;
                case "3":
                    System.out.println("Enter Id:");
                    String id = scanner.nextLine();
                    Optional<Candidate> result = candidateManager.findById(id);
                    result.ifPresent(c -> System.out.println(c.toString()));
                    break;
                case "4":
                    scanner.close();
                    return;
                default:
                    System.out.println("Input Invalid");
                    break;
            }
        }
    }

    public static Candidate createCandidate(Scanner scanner) {
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        System.out.println("Enter priority: ");
        String priority = scanner.nextLine();
        while (true) {
            System.out.println("Enter group (A or B or C): ");
            String group = scanner.nextLine();
            switch (group) {
                case "A":
                    return new Candidate(id, name, address, priority, Group.A);
                case "B":
                    return new Candidate(id, name, address, priority, Group.B);
                case "C":
                    return new Candidate(id, name, address, priority, Group.C);
                default:
                    System.out.println("Input invalid, try again (A/B/C)");
                    break;
            }
        }

    }
}
