package entity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import exception.AdmissionYearException;
import exception.DateOfBirthException;
import exception.FullNameException;
import utils.DefaultValue;

public class Student {
    protected String id;
    protected String fullname;
    protected String dateOfBirth;
    protected String admissionYear;
    protected double entranceScore;
    protected List<Transcript> transcripts = new ArrayList<>();

    public Student() {}
    
    public Student(String id, String fullname, String dateOfBirth, String admissionYear, double entranceScore) {
        this.id = id;
        this.fullname = fullname;
        this.dateOfBirth = dateOfBirth;
        this.admissionYear = admissionYear;
        this.entranceScore = entranceScore;
        // this.transcripts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public double getEntranceScore() {
        return entranceScore;
    }

    public void setEntranceScore(double entranceScore) {
        this.entranceScore = entranceScore;
    }

    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    public void addTranscripts(Transcript transcripts) {
        this.transcripts.add(transcripts);
    }

    public boolean isRegularStudent() {
        return true;
    }

    public double getGPABySemester(String semester) {
        return transcripts.stream()
            .filter(o -> o.getSemester().equals(semester))
            .findFirst()
            .map(Transcript::getGpa)
            .orElse(0.0);
    }

    public double getHighestGPA() {
        return transcripts.stream()
            .sorted(Comparator.comparingDouble(Transcript::getGpa).reversed())
            .toList()
            .get(0).getGpa();
    }

    public void input(Scanner scanner) {
        System.out.println("Enter id: ");
        this.id = scanner.nextLine();

        System.out.println("Enter name: ");
        this.fullname = scanner.nextLine();
        try {
            if (!utils.Validator.isValidName(fullname)) {
                throw new FullNameException("invalid name");
            }
        } catch (FullNameException e) {
            System.out.println(e.getMessage());
            this.fullname = DefaultValue.NAME;
        }

        System.out.println("Enter date of birth: ");
        this.dateOfBirth = scanner.nextLine();
        try {
            if (!utils.Validator.isValidDateOfBirth(this.dateOfBirth)) {
                throw new DateOfBirthException("invalid date of birth");
            }
        } catch (DateOfBirthException e) {
            System.out.println(e.getMessage());
            this.dateOfBirth = DefaultValue.DATE_OF_BIRTH;
        }

        System.out.println("Enter admission year: ");
        this.admissionYear = scanner.nextLine();
        try {
            if (!utils.Validator.isValidYear(this.admissionYear)) {
                throw new AdmissionYearException("invalid year");
            }
        } catch (AdmissionYearException e) {
            System.out.println(e.getMessage());
            this.admissionYear = DefaultValue.ADMISSION_YEAR;
        }

        System.out.println("Enter entrance score: ");
        try {
            this.entranceScore = scanner.nextDouble();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.entranceScore = DefaultValue.ENNTRANCE_SCORE;
        } 

        System.out.println("Enter transcript: ");
        while (true) {
            System.out.println("Enter semester: ");
            String semester = scanner.nextLine();
            System.out.println("Enter gpa: ");
            Double gpa = 0.0;
            try {
                gpa = scanner.nextDouble();
                scanner.nextLine();
            } catch (Exception e) {
                gpa = 0.0;
            }
            this.transcripts.add(new Transcript(semester, gpa));
            System.out.println("Continue add ? y/n");
            String option = scanner.nextLine();
            if (!option.equals("y")) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", fullname=" + fullname + ", dateOfBirth=" + dateOfBirth + ", admissionYear="
                + admissionYear + ", entranceScore=" + entranceScore + "]";
    }
    
}
