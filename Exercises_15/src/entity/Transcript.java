package entity;
public class Transcript {
    private String semester;
    private double gpa;
    
    public Transcript(String semester, double gpa) {
        this.semester = semester;
        this.gpa = gpa;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Transcript [semester=" + semester + ", gpa=" + gpa + "]";
    }
    
}
