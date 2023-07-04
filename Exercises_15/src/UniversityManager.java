import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Faculty;
import entity.Student;

public class UniversityManager {
    private List<Faculty> faculty;

    public UniversityManager() {
        this.faculty = new ArrayList<>();
    }

    public List<Faculty> getFaculty() {
        return faculty;
    }

    public void addFaculty(Faculty faculty) {
        this.faculty.add(faculty);
    }

    public Map<Student, Double> getGPABySemester(String semester) {
        Map<Student, Double> results = new HashMap<>();
        faculty.forEach(facultyItem -> {
            facultyItem.getStudents().forEach(student -> {
                results.put(student, student.getGPABySemester(semester));
            });
        });
        return results;
    }
    
    public Map<Faculty, Long> getTotalRegularStudentsOfEachFaculty() {
        Map<Faculty, Long> results = new HashMap<>();
        faculty.forEach(facultyItem -> {
            results.put(facultyItem, facultyItem.getTotalRegularStudents());
        });
        return results;
    }

    public Map<Faculty, Student> getStudentWithHighestEntranceScoreOfEachFaculty() {
        Map<Faculty, Student> results = new HashMap<>();
        faculty.forEach(facultyItem -> {
            results.put(facultyItem, facultyItem.getStudentWithHighestEntranceScore());
        });
        return results;
    }

    public Map<Faculty, List<Student>> getInServiceStudentsByLocationTrainingOfEachFaculty(String location) {
        Map<Faculty, List<Student>> results = new HashMap<>();
        faculty.forEach(facultyItem -> {
            results.put(facultyItem, facultyItem.getInServiceStudentsByLocationTraining(location));
        });
        return results;
    }

    public Map<Faculty, List<Student>> getStudentWithLastGPAGreaterThan8OfEachFaculty() {
        Map<Faculty, List<Student>> results = new HashMap<>();
        faculty.forEach(facultyItem -> {
            results.put(facultyItem, facultyItem.getStudentWithLastGPAGreaterThan8());
        });
        return results;
    }

    public Map<Faculty, Student> getStudentWithHighestGPAOfEachFaculty() {
        Map<Faculty, Student> results = new HashMap<>();
        faculty.forEach(facultyItem -> {
            results.put(facultyItem, facultyItem.getStudentWithHighestGPA());
        });
        return results;
    }

    public Map<Faculty, List<Student>> sortInEachFaculty() {
        Map<Faculty, List<Student>> results = new HashMap<>();
        faculty.forEach(facultyItem -> {
            results.put(facultyItem, facultyItem.sort());
        });
        return results;
    }
    
    public Map<Faculty, Map<String, Integer>> countStudentsByAdmissionYearOfEachFaculty() {
        Map<Faculty, Map<String, Integer>> results = new HashMap<>();
        faculty.forEach(facultyItem -> {
            results.put(facultyItem, facultyItem.countStudentsByAdmissionYear());
        });
        return results;
    }

    public void showAllStudent() {
        this.faculty.forEach(faculty -> {
            System.out.println(faculty.getName());
            faculty.getStudents().forEach(student -> {
                System.out.println(student.toString());
                System.out.println("Transcript: ");
                student.getTranscripts().forEach(System.out::println);
            });
        });
    }
}
