import java.util.Scanner;

import entity.Faculty;
import entity.InServiceStudent;
import entity.Student;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        UniversityManager universityManager = new UniversityManager();

        universityManager.addFaculty(new Faculty("School of Mathematics"));
        universityManager.addFaculty(new Faculty("School of Information Technology"));
        universityManager.addFaculty(new Faculty("School of Electric"));

        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Show all");
            System.out.println("3. Total number of regular students of each faculty");
            System.out.println("4. Student with the highest entry score in each faculty");
            System.out.println("5. List of in-service students at the specific place of training association");
            System.out.println("6. List of students with average grade point average in the latest semester of 8.0 or higher");
            System.out.println("7. Students with the highest semester GPA in each faculty");
            System.out.println("8. Sort the list of students ascending by type and descending by school year in each faculty");
            System.out.println("9. Statistics on the number of students by year of admission in each faculty");

            String function = scanner.nextLine();

            switch (function) {
                case "1":
                    Student student = new Student();
                    System.out.println("Choose student type (1 - regular, 2 - In-service): ");
                    String type = scanner.nextLine();
                    
                    if (type.equals("1")) {
                        student.input(scanner);
                        System.out.println("Choose faculty: ");
                        System.out.println("1. School of Mathematics");
                        System.out.println("2. School of Information Technology");
                        System.out.println("3. School of Electric");

                        String option = scanner.nextLine();
                        switch (option) {
                            case "1":
                                universityManager.getFaculty().get(0).addStudents(student);
                                break;
                            case "2":
                                universityManager.getFaculty().get(1).addStudents(student);
                                break;
                            case "3":
                                universityManager.getFaculty().get(2).addStudents(student);
                                break;
                            default:
                                System.out.println("invalid faculty");
                                break;
                        }
                    } else if (type.equals("2")) {
                        InServiceStudent inServiceStudent = (InServiceStudent) student;
                        inServiceStudent.input(scanner);
                        System.out.println("Choose faculty: ");
                        System.out.println("1. School of Mathematics");
                        System.out.println("2. School of Information Technology");
                        System.out.println("3. School of Electric");

                        String option = scanner.nextLine();
                        switch (option) {
                            case "1":
                                universityManager.getFaculty().get(0).addStudents(inServiceStudent);
                                break;
                            case "2":
                                universityManager.getFaculty().get(1).addStudents(inServiceStudent);
                                break;
                            case "3":
                                universityManager.getFaculty().get(2).addStudents(inServiceStudent);
                                break;
                            default:
                                System.out.println("Invalid faculty");
                                break;
                        }
                    } else {
                        System.out.println("Invalid input");
                    }
                    break;
                case "2":
                    universityManager.showAllStudent();
                    break;
                case "3":
                    universityManager.getTotalRegularStudentsOfEachFaculty().forEach((faculty, count) -> {
                        System.out.println(faculty.getName() + " " + count);
                    });
                    break;
                case "4":
                    universityManager.getStudentWithHighestEntranceScoreOfEachFaculty().forEach((faculty, studentItem) -> {
                        System.out.println(faculty.getName() + " id:" + studentItem.getId() + " fullname:" + studentItem.getFullname());
                    });
                    break;
                case "5":
                    System.out.println("Enter location training: ");
                    String location = scanner.nextLine();
                    universityManager.getInServiceStudentsByLocationTrainingOfEachFaculty(location).forEach((faculty, listStudent) -> {
                        System.out.println(faculty.getName());
                        listStudent.forEach(System.out::println);
                    });
                    break;
                case "6":
                    universityManager.getStudentWithLastGPAGreaterThan8OfEachFaculty().forEach((faculty, listStudent) -> {
                        System.out.println(faculty.getName());
                        listStudent.forEach(System.out::println);
                    });
                    break;
                case "7":
                    universityManager.getStudentWithHighestGPAOfEachFaculty().forEach((faculty, studentItem) -> {
                        System.out.println(faculty.getName() + " " + studentItem.getFullname());
                    });
                    break;
                case "8":
                    universityManager.sortInEachFaculty().forEach((faculty, listStudent) -> {
                        System.out.println(faculty.getName());
                        listStudent.forEach(System.out::println);
                    });
                case "9":
                    universityManager.countStudentsByAdmissionYearOfEachFaculty().forEach((faculty, map) -> {
                        System.out.println(faculty.getName());
                        map.forEach((year, count) -> {
                            System.out.println(year + ": " + count);
                        });
                    });
                default:
                    break;
            }

        }
    }
}
