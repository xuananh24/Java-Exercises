package entity;
import java.time.LocalDate;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;

    public Experience(String id, String name, LocalDate birthDay, String phone, String email, int employeeType, int expInYear, String proSkill) {
        super(id, name, birthDay, phone, email, employeeType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String showInfo() {
        return "Experience [id=" + this.getId() + ", name=" + this.getName() + ", birthDay=" + this.getBirthDay() + ", phone=" + this.getPhone() + ", email="
                + this.getEmail() + ", employeeType=" + this.getEmployeeType() + ", expInYear=" + this.expInYear + ", proSkill=" + this.proSkill + "]";
    }
    
    
}
