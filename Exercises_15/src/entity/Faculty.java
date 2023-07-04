package entity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Faculty {
    private String name;
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        this.students.add(student);
    }

    public long getTotalRegularStudents() {
        return students.stream().filter(o -> o.isRegularStudent() == true).count();
    }
    
    public Student getStudentWithHighestEntranceScore() {
        return students.stream()
            .max(Comparator.comparingDouble(Student::getEntranceScore))
            .orElse(null);
    }

    public List<Student> getInServiceStudentsByLocationTraining(String location) {
        return students.stream()
            .filter(o -> o instanceof InServiceStudent)
            .filter(o -> ((InServiceStudent) o).getTrainingLocation().equals(location))
            .toList();
    }

    public List<Student> getStudentWithLastGPAGreaterThan8() {
        return students.stream().filter(o -> {
            int size = o.getTranscripts().size();
            return size > 0 && o.getTranscripts().get(size - 1).getGpa() > 8.0;
        }).toList();
    }

    public Student getStudentWithHighestGPA() {
        return students.stream()
            .sorted(Comparator.comparingDouble(Student::getHighestGPA).reversed())
            .toList()
            .get(0);
    }

    public List<Student> sort() {
        return students.stream()
            .sorted(Comparator.comparing(Student::isRegularStudent).thenComparing(Student::getAdmissionYear).reversed())
            .toList();
    }

    public Map<String, Integer> countStudentsByAdmissionYear() {
        Map<String, Integer> result = new HashMap<>();
        students.forEach(student -> {
            String year = student.getAdmissionYear();
            result.put(year, result.getOrDefault(year, 0) + 1);
        });
        return result;
    }
}
