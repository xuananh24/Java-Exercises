import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudent20YearOld() {
        return students.stream().filter(student -> student.getAge() == 20).collect(Collectors.toList());
    }

    public long getNumStudent20YearOldDN() {
        return students.stream().filter(student -> student.getAge() == 20 && student.getHomeTown().equals("DN")).count();
    }

    public void showAllStudent() {
        students.forEach(student -> System.out.println(student.toString()));
    }
}
