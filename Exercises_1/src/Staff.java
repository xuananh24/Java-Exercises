public class Staff extends Employee{
    private String task;

    public Staff(String name, int age, String gender, String address, String task) {
        super(name, age, gender, address);
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
    
    @Override
    public String toString() {
        return "Staff " 
        + " name:" + this.getName() 
        + " age:" + this.getAge()
        + " gender:" + this.getGender()
        + " address:" + this.getAddress()
        + " major:" + this.getTask(); 
    }
}
