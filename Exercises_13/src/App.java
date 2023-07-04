import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entity.Employee;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import exception.BirthDayException;
import exception.EmailException;
import exception.FullNameException;
import exception.PhoneException;

public class App {
    public static void main(String[] args) throws Exception {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add employee");
            System.out.println("2. Update info by id");
            System.out.println("3. Delete employee by id");
            System.out.println("4. Find all Intern");
            System.out.println("5. Find all Experience");
            System.out.println("6. Find all Fresher");
            System.out.println("7. Show all");

            String funtion = scanner.nextLine();

            switch(funtion) {
                case "1": 
                    Employee employee = createEmployee(scanner);
                    employeeManager.add(employee);
                    break;
                case "2":
                    update(scanner, employeeManager);
                    break;
                case "3":
                    delete(scanner, employeeManager);
                    break;
                case "4":
                    employeeManager.findIntern().stream().forEach(o -> System.out.println(o.showInfo()));
                    break;
                case "5":
                    employeeManager.findExperience().stream().forEach(o -> System.out.println(o.showInfo()));
                    break;
                case "6":
                    employeeManager.findFresher().stream().forEach(o -> System.out.println(o.showInfo()));
                    break;
                case "7":
                    employeeManager.getEmployees().stream().forEach(o -> System.out.println(o.showInfo()));
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    public static Employee createEmployee(Scanner scanner) {
            System.out.println("Enter id: ");
            String id = scanner.nextLine();

            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            try {
                if (!Validator.isValidName(name)) {
                    throw new FullNameException("invalid name");
                }
            } catch (FullNameException e) {
                System.out.println(e.getMessage());
                name = DefaultValue.NAME;
            }

            System.out.println("Enter date of birth: ");
            String _birthDay = scanner.nextLine();
            try {
                if (!Validator.isValidBirthDay(_birthDay)) {
                    throw new BirthDayException("invalid date of birth");
                }
            } catch (BirthDayException e) {
                System.out.println(e.getMessage());
                _birthDay = DefaultValue.BIRTH_DAY;
            }
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDay = LocalDate.parse(_birthDay, dateTimeFormatter);

            System.out.println("Enter phone number: ");
            String phoneNumber = scanner.nextLine();
            try {
                if (!Validator.isValidEmail(phoneNumber)) {
                    throw new PhoneException("invalid phone number");
                }
            } catch (PhoneException e) {
                System.out.println(e.getMessage());
                phoneNumber = DefaultValue.PHONE;
            }

            System.out.println("Enter email: ");
            String email = scanner.nextLine();
            try {
                if (!Validator.isValidEmail(email)) {
                    throw new EmailException("invalid email");
                }
            } catch (EmailException e) {
                System.out.println(e.getMessage());
                email = DefaultValue.EMAIL;
            }
            
            
            System.out.println("Enter employee type (0 - Experience, 1 - Fresher, 2 - Intern)");
            int employeeType = scanner.nextInt();
            scanner.nextLine();
            while (employeeType != 0 && employeeType != 1 && employeeType != 2) {
                System.out.println("Invalid input");
                employeeType = scanner.nextInt();
                scanner.nextLine();
            }

            switch(employeeType) {
                case 0: 
                    System.out.println("Enter experience year: ");
                    int expInYear;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            expInYear = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid input");
                            scanner.nextLine();
                        }
                    }

                    System.out.println("Enter proSkill: ");
                    String proSkill = scanner.nextLine();

                    Experience experience = new Experience(id, name, birthDay, phoneNumber, email, employeeType, expInYear, proSkill);
                    return experience;
                case 1:
                    System.out.println("Enter graduation date:");
                    String _graduationDate = scanner.nextLine();
                    while (!Validator.isValidBirthDay(_graduationDate)) {
                        System.out.println("Invalid input");
                        _graduationDate = scanner.nextLine();
                    }
                    LocalDate graduationDate = LocalDate.parse(_graduationDate, dateTimeFormatter);

                    System.out.println("Enter graduation rank: ");
                    String graduationRank = scanner.nextLine();

                    System.out.println("Enter education: ");
                    String education = scanner.nextLine();

                    Fresher fresher = new Fresher(id, name, birthDay, phoneNumber, email, employeeType, graduationDate, graduationRank, education);
                    return fresher;
                case 2:
                    System.out.println("Enter majors: ");
                    String major = scanner.nextLine();
                    System.out.println("Enter semester: ");
                    String semester = scanner.nextLine();
                    System.out.println("Enter university name: ");
                    String universityName = scanner.nextLine();
                    
                    Intern intern = new Intern(id, name, birthDay, phoneNumber, email, employeeType, major, semester, universityName);
                    return intern;
                default:
                    return new Employee() {
                        @Override
                        public String showInfo() {return "";}
                    };
            }
    }
    public static void update(Scanner scanner, EmployeeManager employeeManager) {
        System.out.println("Enter id of employee need to update: ");
        String id = scanner.nextLine();
        Employee employee = employeeManager.findById(id);
        if (employeeManager.findById(id) != null) {
            System.out.println("Enter new name: ");
            String name = scanner.nextLine();
            while (!Validator.isValidName(name)) {
                System.out.println("Invalid input");
                name = scanner.nextLine();
            }

            System.out.println("Enter new date of birth: ");
            String _birthDay = scanner.nextLine();
            while (!Validator.isValidBirthDay(_birthDay)) {
                System.out.println("Invalid input");
                _birthDay = scanner.nextLine();
            }
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDay = LocalDate.parse(_birthDay, dateTimeFormatter);

            System.out.println("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            while(!Validator.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid input");
                phoneNumber = scanner.nextLine();
            }

            System.out.println("Enter new email: ");
            String email = scanner.nextLine();
            if (!Validator.isValidEmail(email)) {
                System.out.println("Invalid input");
                email = scanner.nextLine();
            }

            if (employee instanceof Experience) {
                System.out.println("Enter experience year: ");
                int expInYear;
                while (true) {
                    if (scanner.hasNextInt()) {
                        expInYear = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid input");
                        scanner.nextLine();
                    }
                }

                System.out.println("Enter proSkill: ");
                String proSkill = scanner.nextLine();

                // Experience experience = new Experience(id, name, birthDay, phoneNumber, email, 0, expInYear, proSkill);
                Experience experience = (Experience) employee; 
                experience.setName(name);
                experience.setBirthDay(birthDay);
                experience.setPhone(phoneNumber);
                experience.setEmail(email);
                experience.setExpInYear(expInYear);
                experience.setProSkill(proSkill);
                employeeManager.update(id, experience);

            } else if (employee instanceof Fresher) {
                System.out.println("Enter graduation date:");
                String _graduationDate = scanner.nextLine();
                while (!Validator.isValidBirthDay(_graduationDate)) {
                    System.out.println("Invalid input");
                    _graduationDate = scanner.nextLine();
                }
                LocalDate graduationDate = LocalDate.parse(_graduationDate, dateTimeFormatter);

                System.out.println("Enter graduation rank: ");
                String graduationRank = scanner.nextLine();

                System.out.println("Enter education: ");
                String education = scanner.nextLine();

                // Fresher fresher = new Fresher(id, name, birthDay, phoneNumber, email, 1, graduationDate, graduationRank, education);
                Fresher fresher = (Fresher) employee;
                fresher.setName(name);
                fresher.setBirthDay(birthDay);
                fresher.setPhone(phoneNumber);
                fresher.setEmail(email);
                fresher.setGraduationDate(graduationDate);
                fresher.setGraduationRank(graduationRank);
                fresher.setEducation(education);
                employeeManager.update(id, fresher);
            } else if (employee instanceof Intern) {
                System.out.println("Enter majors: ");
                String major = scanner.nextLine();
                System.out.println("Enter semester: ");
                String semester = scanner.nextLine();
                System.out.println("Enter university name: ");
                String universityName = scanner.nextLine();
                
                // Intern intern = new Intern(id, name, birthDay, phoneNumber, email, 2, major, semester, universityName);
                Intern intern = (Intern) employee;
                intern.setName(name);
                intern.setBirthDay(birthDay);
                intern.setPhone(phoneNumber);
                intern.setEmail(email);
                intern.setMajors(major);
                intern.setSemester(semester);
                intern.setUniversityName(universityName);
                employeeManager.update(id, intern);
            }
        }
    }
    public static void delete(Scanner scanner, EmployeeManager employeeManager) {
        System.out.println("Enter id of employee need to delete: ");
        String id = scanner.nextLine();
        
        boolean result = employeeManager.deleteById(id);
        if (result) {
            System.out.println("Success !");
        } else System.out.println("Fail");
    }
}   