package entity;
import java.time.LocalDate;

public class Intern extends Employee{
    private String majors;
    private String semester;
    private String universityName;

    public Intern(String id, String name, LocalDate birthDay, String phone, String email, int employeeType, String majors, String semester, String universityName) {
        super(id, name, birthDay, phone, email, employeeType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String showInfo() {
        return "Intern [id=" + this.getId() + ", name=" + this.getName() + ", birthDay=" + this.getBirthDay() + ", phone=" + this.getPhone() + ", email="
                + this.getEmail() + ", employeeType=" + this.getEmployeeType() + ", majors=" + this.majors + ", semester=" + this.semester
                + ", universityName=" + this.universityName + "]";
    }
    
    
}
