package entity;
import java.time.LocalDate;

public class Fresher extends Employee{
    private LocalDate graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String id, String name, LocalDate birthDay, String phone, String email, int employeeType, LocalDate graduationDate, String graduationRank, String eduacation) {
        super(id, name, birthDay, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = eduacation;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String showInfo() {
        return "Fresher [id=" + this.getId() + ", name=" + this.getName() + ", birthDay=" + this.getBirthDay() + ", phone=" + this.getPhone() + ", email="
                + this.getEmail() + ", employeeType=" + this.getEmployeeType() + ", graduationDate=" + this.graduationDate + ", graduationRank=" + this.graduationRank
                + ", education=" + this.education + "]";
    }

    
}
