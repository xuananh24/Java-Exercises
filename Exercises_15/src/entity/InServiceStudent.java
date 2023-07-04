package entity;

import java.util.Scanner;

import exception.AdmissionYearException;
import exception.DateOfBirthException;
import exception.FullNameException;
import utils.DefaultValue;

public class InServiceStudent extends Student{
    private String trainingLocation;

    public InServiceStudent(String id, String fullname, String dateOfBirth, String admissionYear,
            double entranceScore, String trainingLocation) {
        super(id, fullname, dateOfBirth, admissionYear, entranceScore);
        this.trainingLocation = trainingLocation;
    }

    public String getTrainingLocation() {
        return trainingLocation;
    }

    public void setTrainingLocation(String trainingLocation) {
        this.trainingLocation = trainingLocation;
    }
    
    @Override
    public boolean isRegularStudent() {
        return false;
    }

    @Override
    public void input(Scanner scanner) {
        System.out.println("Enter id: ");
        this.id = scanner.nextLine();

        System.out.println("Enter name: ");
        this.fullname = scanner.nextLine();
        try {
            if (utils.Validator.isValidName(fullname)) {
                throw new FullNameException("invalid name");
            }
        } catch (FullNameException e) {
            System.out.println(e.getMessage());
            this.fullname = DefaultValue.NAME;
        }

        System.out.println("Enter date of birth: ");
        this.dateOfBirth = scanner.nextLine();
        try {
            if (utils.Validator.isValidDateOfBirth(this.dateOfBirth)) {
                throw new DateOfBirthException("invalid date of birth");
            }
        } catch (DateOfBirthException e) {
            System.out.println(e.getMessage());
            this.dateOfBirth = DefaultValue.DATE_OF_BIRTH;
        }

        System.out.println("Enter admission year: ");
        this.admissionYear = scanner.nextLine();
        try {
            if (utils.Validator.isValidYear(this.admissionYear)) {
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

        System.out.println("Enter training location: ");
        String location = scanner.nextLine();
        this.trainingLocation = location;

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
        return "InServiceStudent [id=" + id + ", fullname=" + fullname + ", dateOfBirth=" + dateOfBirth + ", admissionYear="
                + admissionYear + ", entranceScore=" + entranceScore +  "trainingLocation=" + trainingLocation + "]"; 
    }
    
}
